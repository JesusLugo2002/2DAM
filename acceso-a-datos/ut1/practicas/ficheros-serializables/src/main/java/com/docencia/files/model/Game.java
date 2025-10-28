package com.docencia.files.model;

public class Game {
    private String id;
    private String name;
    private int tries;

    public Game(String id, String name, int tries) {
        this.id = id;
        this.name = name;
        this.tries = tries;
    }
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTries() {
        return this.tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

}
