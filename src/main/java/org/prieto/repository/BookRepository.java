package org.prieto.repository;


import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.prieto.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Executable
    Book find(String title);
}