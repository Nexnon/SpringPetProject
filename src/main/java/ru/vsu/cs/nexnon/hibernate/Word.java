package ru.vsu.cs.nexnon.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String wordEng;

    private String wordRus;

    public Word(){
    }

    public Word(String wordEng, String wordRus) {
        this.wordEng = wordEng;
        this.wordRus = wordRus;
    }

    public String getWordEng() {
        return wordEng;
    }

    public void setWordEng(String wordEng) {
        this.wordEng = wordEng;
    }

    public String getWordRus() {
        return wordRus;
    }

    public void setWordRus(String wordRus) {
        this.wordRus = wordRus;
    }

    public int getId() {
        return id;
    }
}
