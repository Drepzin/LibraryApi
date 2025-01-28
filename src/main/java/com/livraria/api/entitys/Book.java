package com.livraria.api.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Theme theme;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    private Double price;

    @Column(name = "native_language")
    private String nativeLanguage;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Author author;


    public Book() {
    }

    public Book(LocalDate publicationDate, Theme theme, String title, Double price, String nativeLanguage) {
        this.publicationDate = publicationDate;
        this.theme = theme;
        this.title = title;
        this.price = price;
        this.nativeLanguage = nativeLanguage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }
}
