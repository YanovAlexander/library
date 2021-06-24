package com.library.controller;

import com.library.config.DatabaseConnectionManager;
import com.library.config.HibernateDatabaseConnector;
import com.library.dto.BookDTO;
import com.library.dto.Genre;
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

@WebServlet("/books/update")
public class UpdateBookServlet extends HttpServlet {

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
        int id = Integer.parseInt(req.getParameter("id"));
        BookDTO book = bookService.findById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/view/updateForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDTO book = new BookDTO();
        book.setAuthor(req.getParameter("author"));
        book.setName(req.getParameter("name"));
        book.setCountPages(Integer.parseInt(req.getParameter("countPages")));
        book.setPublicationYear(Integer.parseInt(req.getParameter("publicationYear")));
        book.setDescription( req.getParameter("description"));
        book.setGenre(Genre.valueOf(req.getParameter("genre")));
        book.setId(Integer.parseInt(req.getParameter("id")));
        bookService.update(book);
        resp.sendRedirect(req.getContextPath() + "/books");
    }
}
