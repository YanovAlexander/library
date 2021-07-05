package com.library.controller;

import com.library.dto.BookDTO;
import com.library.dto.Genre;
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

@WebServlet("/books/update")
@Configurable
public class UpdateBookServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
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
        //TODO add author logic
//        book.setAuthor(req.getParameter("author"));
        book.setName(req.getParameter("name"));
        book.setCountPages(Integer.parseInt(req.getParameter("countPages")));
        book.setPublicationYear(Integer.parseInt(req.getParameter("publicationYear")));
        book.setDescription( req.getParameter("description"));
        book.setGenre(Genre.valueOf(req.getParameter("genre")));
        book.setId(Integer.parseInt(req.getParameter("id")));
        bookService.update(book);
        resp.sendRedirect(req.getContextPath() + "/books");
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
