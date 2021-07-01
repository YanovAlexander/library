package com.library.controller;

import com.library.config.HibernateDatabaseConnector;
import com.library.dto.AuthorDTO;
import com.library.model.AuthorRepository;
import com.library.model.Repository;
import com.library.model.entity.AuthorDAO;
import com.library.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books/add")
public class AddBookServlet extends HttpServlet {
    private Repository<AuthorDAO> repository;
    private AuthorService authorService;

    @Override
    public void init() throws ServletException {
        this.repository = new AuthorRepository(HibernateDatabaseConnector.getSessionFactory());
        this.authorService = new AuthorService(repository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<AuthorDTO> authors = authorService.findAuthors();
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("/view/addBooks.jsp").forward(req, resp);
    }
}
