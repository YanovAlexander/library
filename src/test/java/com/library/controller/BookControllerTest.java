package com.library.controller;

import com.library.BooksUtil;
import com.library.dto.AuthorDTO;
import com.library.dto.BookDTO;
import com.library.service.AuthorService;
import com.library.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookControllerTest {
    @Autowired
    private WebApplicationContext context;
    @MockBean
    private AuthorService authorService;
    @MockBean
    private BookService bookService;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @WithMockUser(roles = {"USER"})
    @Test
    void testShowBooksPageShouldReturnBooksPage() throws Exception {
        //when
        BookDTO book = BooksUtil.getBookDTO(1);
        when(bookService.findAll()).thenReturn(Collections.singletonList(book));
        //then
        mvc.perform(MockMvcRequestBuilders.get("/books").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("books"))
                .andExpect(model().attribute("books", Collections.singletonList(book)));
    }

    @Test
    void testShowBooksPageShouldRedirectToLoginPage() throws Exception {
        //when
        BookDTO book = BooksUtil.getBookDTO(1);
        when(bookService.findAll()).thenReturn(Collections.singletonList(book));
        //then
        mvc.perform(MockMvcRequestBuilders.get("/books").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is3xxRedirection());
    }

    @WithMockUser(roles = {"USER"})
    @Test
    void testShowAddFormBookPageShouldReturnPermissionDenied() throws Exception {
        //then
        mvc.perform(MockMvcRequestBuilders.get("/books/form/add").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.FORBIDDEN.value()));
    }

    @WithMockUser(roles = {"USER"})
    @Test
    void testShowUpdateBookPageShouldReturnBookPage() throws Exception {
        //when
        AuthorDTO author = BooksUtil.getAuthorDTO();
        BookDTO book = BooksUtil.getBookDTO(author.getId());
        when(bookService.findById(book.getId())).thenReturn(book);
        when(authorService.getAuthor(book.getAuthorId())).thenReturn(author);

        mvc.perform(MockMvcRequestBuilders.get("/books/findById?id=" + book.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("showBook"))
                .andExpect(model().attribute("book", book))
                .andExpect(model().attribute("author", author));
    }
}