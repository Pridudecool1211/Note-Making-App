package com.example.learnrecyclerview;

public class ListOfNotes {

    private int id;
    private String h;
    private String d;

    public ListOfNotes(int id, String h, String d) {
        this.id = id;
        this.h = h;
        this.d = d;
    }

    public String getH() {
        return h;
    }

    public String getD() {
        return d;
    }

    public int getId() {
        return id;
    }
}
