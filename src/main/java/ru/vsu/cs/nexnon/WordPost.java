package ru.vsu.cs.nexnon;

import com.sun.istack.NotNull;

public class WordPost {
    @NotNull
    private String WordEng;
    @NotNull
    private String WordRus;

    public String getWordEng() {
        return WordEng;
    }

    public String getWordRus() {
        return WordRus;
    }

    public void setWordEng(String wordEng) {
        WordEng = wordEng;
    }

    public void setWordRus(String wordRus) {
        WordRus = wordRus;
    }
}
