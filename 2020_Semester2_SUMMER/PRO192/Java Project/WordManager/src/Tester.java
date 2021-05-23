
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Tester {
    public static void main(String[] args) {
        WordList obj = new WordList();
        obj.createVocabulary();
        obj.display();
        obj.display2();
        
        // Test getKeyMax()
        String k = obj.getKeyMax();
        System.out.println("Key co nhieu word nhat: " + k); // k = "A"
        
        // Test getMax()
        ArrayList<String> kq = obj.getMax();
        System.out.println("Value co nhieu word nhat: " + kq);
        
        
        // Test checkWord()
        String word = "apple";
        boolean kq2 = obj.checkWord(word);
        if (kq2) System.out.println("Found the word " + word);
        else System.out.println("Not Found the word " + word); // In ra
        
        // Test addWord()
        String newword = "apple";
        obj.addWord(newword);
        obj.display();
        
        // Test deleteWord()
        String delWord = "ban";
        obj.deleteWord(delWord);
        obj.display();
        
        // Test editWord()
        String eWord = "apple";
        String nWord = "arm";
        obj.editWord(eWord, nWord);
        obj.display();
    }
}
