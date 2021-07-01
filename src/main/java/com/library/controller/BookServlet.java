package com.library.controller;

import com.library.config.HibernateDatabaseConnector;
import com.library.dto.BookDTO;
import com.library.dto.Genre;
import com.library.model.AuthorRepository;
import com.library.model.BookRepository;
import com.library.model.Repository;
import com.library.model.entity.AuthorDAO;
import com.library.model.entity.BookDAO;
import com.library.service.AuthorService;
import com.library.service.BookService;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private Repository<BookDAO> repository;
    private Repository<AuthorDAO> authorRepository;
    private BookService bookService;
    private AuthorService authorService;

    @Override
    public void init() throws ServletException {
        final SessionFactory sessionFactory = HibernateDatabaseConnector.getSessionFactory();
        this.repository = new BookRepository(sessionFactory);
        this.bookService = new BookService(repository);
        this.authorRepository = new AuthorRepository(sessionFactory);
        this.authorService = new AuthorService(authorRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookDTO> books = bookService.findAll();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/view/books.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDTO book = new BookDTO();
        book.setAuthor(authorService.getAuthor(Integer.parseInt(req.getParameter("authorId"))));
        book.setName(req.getParameter("name"));
        book.setCountPages(Integer.parseInt(req.getParameter("countPages")));
        book.setPublicationYear(Integer.parseInt(req.getParameter("publicationYear")));
        book.setDescription( req.getParameter("description"));
        book.setGenre(Genre.valueOf(req.getParameter("genre")));
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/books");
    }
}
