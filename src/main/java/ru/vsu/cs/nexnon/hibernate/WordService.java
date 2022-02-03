package ru.vsu.cs.nexnon.hibernate;

import java.util.List;
import java.util.Random;

public class WordService {
    private WordDAO wordDao = new WordDAO();

    public WordService() {
    }

    public Word findWord(int id) {
        return wordDao.findById(id);
    }

    public Word getRandomWord(){
        List<Word> words = wordDao.findAll();
        return words.get(new Random().nextInt(words.size()));
    }

    public void saveWord(Word word) {
        wordDao.save(word);
    }

    public void deleteWord(Word word) {
        wordDao.delete(word);
    }

    public void updateWord(Word word) {
        wordDao.update(word);
    }
}
