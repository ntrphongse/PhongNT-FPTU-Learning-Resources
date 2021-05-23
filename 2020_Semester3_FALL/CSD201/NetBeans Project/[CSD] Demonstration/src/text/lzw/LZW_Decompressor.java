/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.lzw;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class LZW_Decompressor {
    Hashtable<Integer, String> dict; // Từ điển giải mã
    String unzippedStr; // Chuỗi kết quả giải mã
    int code = 256; // code 0..255 -> ASCII table
    boolean unzipped = false;

    public LZW_Decompressor() {
        this.dict = new Hashtable<>();
        initDict();
    }
    
    private void initDict() {
        for (int i = 0; i < 256; i++)
            dict.put(i, "" + (char)i);
    }
    
    private void putToDict(String term) {
        dict.put(code++, term);
    }
    
    private void output(String entry) {
        unzippedStr += entry;
    }
    
    public void unzip(ArrayList<Integer> zippedCodes) { // Input: Mảng các mã
        unzippedStr = "";
        int prevCode, curCode;
        char ch;
        String entry;
        
        // Giải nén mã đầu tiên, vị trí 0 -> ASCII character
        prevCode = zippedCodes.get(0); // unzipped the first code
        // get first subStrings
        String prevTranslation = dict.get(prevCode); // <code, entry>
        entry = prevTranslation;
        output(entry); // unzip the first code
        
        String curTranslation; // Chuỗi con đã giải nén hiện hành
        int i = 1; // Đi từ mã ở vị trí 1
        
        // Unzip remaining codes
        while (i < zippedCodes.size()) { // unzip remainder
            curCode = zippedCodes.get(i); // read in a code
            // Giải nén mã thứ i => Entry (Chuỗi con) đưa vào kết quả giải nén hiện hành
            curTranslation = dict.get(curCode);
            entry = curTranslation;
            output(entry);
            
            ch = entry.charAt(0);
            
            // Chuỗi con mới = chuỗi con cũ nối thêm kí tự đầu của entry
            // --> Đưa chuỗi con mới vào từ điển
            // Add ((translation of prevcode) + ch) to dictionary
            putToDict(prevTranslation + ch);
            prevCode = curCode;
            prevTranslation = curTranslation;
            i++;
            // Lặp lại giải nén mã kế tiếp
        }
        unzipped = true;
    }

    public String getUnzippedStr() {
        return unzipped ? unzippedStr : null;
    }
}
