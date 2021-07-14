package com.library.controller;

import com.library.dto.AuthorDTO;
import com.library.dto.BookDTO;
import com.library.dto.Genre;
import com.library.service.AuthorService;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(path = "/books")
public class BookController {

    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public BookController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @GetMapping(path = "/form/add")
    public ModelAndView showAddFormBookPage(ModelAndView model) {
        List<AuthorDTO> authors = authorService.findAuthors();
        model.addObject("authors", authors);
        model.setViewName("addBookForm");
        return model;
    }

    @GetMapping(path = "/form/update")
    public String showUpdateBookPage(@RequestParam(name = "id") Integer id, Model model) {
        BookDTO book = bookService.findById(id);
        List<AuthorDTO> authors = authorService.findAuthors();
        model.addAttribute("authors", authors);
        model.addAttribute("genres", Genre.values());
        model.addAttribute("book", book);
        return "updateBookForm";
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("book") BookDTO book) {
        bookService.update(book, authorService.getAuthor(book.getAuthorId()));
        return new RedirectView("/books");
    }

    @ModelAttribute("book")
    public BookDTO defaultBook() {
        return new BookDTO();
    }
}

