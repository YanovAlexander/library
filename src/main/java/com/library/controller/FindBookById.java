package com.library.controller;

import com.library.config.DatabaseConnectionManager;
import com.library.config.HibernateDatabaseConnector;
import com.library.dto.BookDTO;
import com.library.model.BookRepository;
import com.library.model.Repository;
import com.library.model.entity.BookDAO;
import com.library.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books/findById")
public class FindBookById extends HttpServlet {

    private Repository<BookDAO> repository;
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        this.repository = new BookRepository(DatabaseConnectionManager.getDataSource(),
                HibernateDatabaseConnector.getSessionFactory());
        this.bookService = new BookService(repository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        BookDTO book = bookService.findById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/view/findById.jsp").forward(req, resp);
    }
}
