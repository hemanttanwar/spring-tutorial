package com.tutorial.movies.rest.springboot.movies;

public class Movie {
    private int id;
    private String name;
    private int year;
    private String starring;

    /**The constructor takes in information and set the attributs.*/
    public Movie(int id, String name, int year, String starring){
        this.id = id;
        this.name = name;
        this.year = year;
        this.starring = starring;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }
}
