package com.livraria.api.author;

import com.livraria.api.entitys.Author;
import com.livraria.api.repositorys.AuthorRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AuthorTest {

    @Autowired
    AuthorRepo authorRepo;

    @Test
    void saveAuthor(){
        Author author = new Author("Brasil", LocalDate.of(2000, 05, 12),
                "eliezer");

        System.out.println(authorRepo.save(author));
    }

    @Test
    void findAuthor(){
        System.out.println(authorRepo.findByName("eliezer"));
    }

    @Test
    void findAuthorData(){
        System.out.println("Author: " +authorRepo.findByData(LocalDate.of(2000, 05, 12)));
    }

    @Test
    void findAuthorByName(){
        System.out.println("Author: " +authorRepo.findByName("pedrosa"));
    }

}
