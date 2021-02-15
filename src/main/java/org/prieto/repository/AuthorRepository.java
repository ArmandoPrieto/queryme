package org.prieto.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.prieto.domain.Author;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findByName(String title);

}