package com.library.service;

import com.library.BooksUtil;
import com.library.config.CustomTestConfiguration;
import com.library.dto.AuthorDTO;
import com.library.dto.BookDTO;
import com.library.model.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CustomTestConfiguration.class)
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;


    @Test
    void testAddBookShouldSaveBookHappyPath() {
        //given
        AuthorDTO authorDTO = BooksUtil.getAuthorDTO();
        BookDTO bookDTO = BooksUtil.getBookDTO(authorDTO.getId());
        when(bookRepository.save(any())).thenReturn(BooksUtil.getBookDAO(BooksUtil.getAuthor()));
        //when
        BookDTO savedBook = bookService.addBook(bookDTO, authorDTO);
        //then
        assertThat(savedBook).isEqualTo(bookDTO);
    }
}
