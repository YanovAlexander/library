package com.library.model;

import com.library.BooksUtil;
import com.library.model.entity.BookDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.library.BooksUtil.BOOK_NAME;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testGetByNameShouldReturnBooks() {
        //given
        authorRepository.save(BooksUtil.getAuthor());
        bookRepository.saveAll(BooksUtil.prepareBooks(BooksUtil.getAuthor()));
        //when
        final List<BookDAO> books = bookRepository.getByName(BOOK_NAME);
        //then
        assertThat(books.size()).isEqualTo(1);
        assertThat(books.stream().findFirst().get().getCountPages()).isEqualTo(100);
    }


    @Test
    void testGetByNameShouldReturnEmptyList() {
        //given
        final List<BookDAO> books = bookRepository.getByName(BOOK_NAME);
        //then
        assertThat(books.size()).isEqualTo(0);
    }
}