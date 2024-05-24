package com.example.myapplication;

public class Book {
    private String name;
    private String author;
    private String year;
    private String publisher;

    public Book(String name, String author, String year, String publisher) {

        this.name = name;
        this.author = author;
        this.year = year;
        this.publisher = publisher;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getPublisher() {
        return this.publisher;

    }
    public void setpublisher(String publish){
        this.publisher = publisher;

    }
}