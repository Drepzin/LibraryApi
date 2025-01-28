package com.livraria.api.ApiUtils.validators;

import com.livraria.api.entitys.Author;
import com.livraria.api.exceptions.DuplicatedAuthor;
import com.livraria.api.repositorys.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorValidator {

    @Autowired
    private AuthorRepo authorRepo;

    public void validate(Author author) {
        if(verifyAuthor(author)){
            throw new DuplicatedAuthor("This author already exist!");
        }
    }

    public boolean verifyAuthor(Author author){
        Optional<Author> optionalAuthor = authorRepo.findByNameAndNationalityAndBirthDate(
                author.getName(), author.getNationality(), author.getBirthDate()
        );
        return optionalAuthor.isPresent();
    }
}
