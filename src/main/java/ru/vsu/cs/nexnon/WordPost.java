package ru.vsu.cs.nexnon;

import com.sun.istack.NotNull;

public class WordPost {
    @NotNull
    private final String WordEng;
    @NotNull
    private final String WordRus;

    public WordPost(String wordEng, String wordRus) {
        WordEng = wordEng;
        WordRus = wordRus;
    }

    public String getWordEng() {
        return WordEng;
    }

    public String getWordRus() {
        return WordRus;
    }
}
