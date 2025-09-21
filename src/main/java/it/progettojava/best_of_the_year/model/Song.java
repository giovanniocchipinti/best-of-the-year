package it.progettojava.best_of_the_year.model;

public class Song {
    private int id;
    private String title;

    public Song(int id, String title){
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return title;
    }
    public void setTitolo(String title) {
        this.title = title;
    }
}
