package com.livraria.api.repositorys;

import com.livraria.api.entitys.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Optional<Book> findByTitle(@Param("title") String title);
}
