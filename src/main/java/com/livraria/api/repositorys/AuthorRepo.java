package com.livraria.api.repositorys;

import com.livraria.api.entitys.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface AuthorRepo extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE a.name = :name")
    Optional<Author> findByName(@Param("name") String name);

    @Query("SELECT a FROM Author a WHERE a.birthDate = :data")
    Optional<Author> findByData(@Param("data") LocalDate localDate);

    @Query("SELECT a FROM Author a WHERE a.name = :name AND a.nationality = :nationality AND a.birthDate = :birthDate")
    Optional<Author> findByNameAndNationalityAndBirthDate(@Param("name") String name,
                                                          @Param("nationality") String nationality, @Param("birthDate") LocalDate localDate);

    Boolean existsByNameAndNationalityAndBirthDate(String name, String nationality, LocalDate localDate);


}
