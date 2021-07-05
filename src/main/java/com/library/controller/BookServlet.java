package com.library.controller;

import com.library.dto.BookDTO;
import com.library.dto.Genre;
import com.library.service.AuthorService;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books")
@Configurable
public class BookServlet extends HttpServlet {
    private BookService bookService;
    private AuthorService authorService;

    public BookServlet() {
    }


    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
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
        book.setDescription(req.getParameter("description"));
        book.setGenre(Genre.valueOf(req.getParameter("genre")));
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/books");
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
}
