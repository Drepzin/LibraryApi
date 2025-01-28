package com.livraria.api.entitys;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String nationality;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(String nationality, LocalDate birthDate, String name) {
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", titulo='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
