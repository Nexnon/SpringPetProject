package ru.vsu.cs.nexnon;

import ru.vsu.cs.nexnon.hibernate.Word;
import ru.vsu.cs.nexnon.hibernate.WordService;

import java.util.Scanner;

public class CreaterWord {
    public static void main(String[] args) {
        WordService wordService = new WordService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Word-eng:");
            String wordEng = scanner.nextLine();
            System.out.println("Word-rus:");
            String wordRus = scanner.nextLine();
            Word word = new Word(wordEng, wordRus);
            wordService.saveWord(word);
        }
    }
}
