package org.prieto.repository;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.BeanContext;
import io.micronaut.data.annotation.Query;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.prieto.domain.Author;
import org.prieto.domain.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class RepositoryTest {

    @Inject
    BeanContext beanContext;

    @Inject
    BookRepository bookRepository;

    @Inject
    AuthorRepository authorRepository;

    @Inject
    ApplicationContext applicationContext;

    @Test
    void testAnnotationMetadata() {
        String query = beanContext.getBeanDefinition(BookRepository.class)
                .getRequiredMethod("find", String.class)
                .getAnnotationMetadata().stringValue(Query.class)
                .orElse(null);
        assertEquals("SELECT book_ FROM org.prieto.domain.Book AS book_ WHERE (book_.title = :p1)", query);

    }

    @Test
    void testSaveBook(){
        Author author = new Author();
        author.setName("Harper Lee");
        author.setAge(65);
        Book book = new Book("To kill a mockingbird", "65412");
        author.setBooks(List.of(book));
        authorRepository.save(author);
        assertEquals(bookRepository.count(), 1);
        assertEquals(authorRepository.count(), 1);
    }

    @Test
    void testFindByName(){
        Author author = new Author();
        author.setName("Harper Lee");
        author.setAge(65);
        Book book = new Book("To kill a mockingbird", "65412");
        author.setBooks(List.of(book));
        authorRepository.save(author);
        assertTrue(authorRepository.findByName("Harper Lee").isPresent());
        
    }
}


