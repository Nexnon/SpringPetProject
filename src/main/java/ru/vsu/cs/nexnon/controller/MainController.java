package ru.vsu.cs.nexnon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.nexnon.WordPost;
import ru.vsu.cs.nexnon.hibernate.Word;
import ru.vsu.cs.nexnon.hibernate.WordService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/1")
    public @ResponseBody  Map<String, String> words(){
        Map<String, String> map = new HashMap<>();
        WordService wordService = new WordService();
        Word word = wordService.getRandomWord();
        map.put("wordEng", word.getWordEng());
        map.put("wordRus", word.getWordRus());
        return map;
    }
    @PostMapping("/words")
    @ResponseStatus(HttpStatus.CREATED)
    public String addWord(@RequestParam("wordEng") String wordEng, @RequestParam("wordRus") String wordRus){
        Word word = new Word(wordEng, wordRus);
        WordService wordService = new WordService();
        wordService.saveWord(word);
        return "index";
    }

    @PostMapping("/add-word")
    @ResponseStatus(HttpStatus.CREATED)
    public void addWord(@RequestBody WordPost wordPost){
        WordService wordService = new WordService();
        Word word = new Word(wordPost.getWordEng(), wordPost.getWordRus());
        wordService.saveWord(word);
    }
}
