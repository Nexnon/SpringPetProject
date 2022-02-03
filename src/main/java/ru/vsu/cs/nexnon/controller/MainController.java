package ru.vsu.cs.nexnon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.vsu.cs.nexnon.hibernate.Word;
import ru.vsu.cs.nexnon.hibernate.WordService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model){
        return "index";
    }
    @GetMapping("/1")
    public @ResponseBody  Map<String, String> words(Model model){
        Map<String, String> map = new HashMap<>();
        WordService wordService = new WordService();
        Word word = wordService.getRandomWord();
        map.put("wordEng", word.getWordEng());
        map.put("wordRus", word.getWordRus());
        return map;
    }
}
