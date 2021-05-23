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
public class LZW_Compressor {
    // <substring, code>
    Hashtable<String, Integer> dict; // từ điển mã hóa
    ArrayList<Integer> zippedData; // mảng kết quả mã hóa
    boolean zipped = false; // Mã hóa xong chưa?
    int code = 256; // Mã cho chuỗi con >= 2 kí tự sẽ đi từ 256
    // code 0..255 -> ASCII table

    public LZW_Compressor() {
        this.dict = new Hashtable<>();
        this.zippedData = new ArrayList<>();
        initDict();
    }
    
    // initialize the dict contains 255 entries for ASCII codes
    private void initDict() {
        for (int i = 0; i < 256; i++) 
            dict.put("" + (char)i, i);
    }
    
    // Add a new subString into dict
    private void putToDict(String s) {
        dict.put(s, code++); // code tự động tăng 1
    }
    
    // Output to file: RE-write this method
    private void output(int code) {
        zippedData.add(code); // Add a code into the zipped result
    }
    
    // Zip
    public void zip(String src) {
        int newCode = 256; // code 0.255 -> ASCII table
        Integer code;
        String subStr = ""; // Chuỗi con đang được xem xét
        String newSubStr; // Chuỗi con mới phát hiện
        char c; // data read from source
        int i = 0;
        int n = src.length();
        /*
        Chuỗi mới = chuỗi cũ nối thêm ký tự vừa đọc (c) vào cuối
        Nếu chuỗi mới chưa có trong dict
            (1) Mã hóa chuỗi cũ
            (2) Đưa chuỗi mới vào dict
            (3) Bắt đầu đi khám phá chuỗi mới bắt đầu từ ký tự (c)
        */
        while (i < n) {
            c = src.charAt(i);
            newSubStr = subStr + c;
            if (dict.containsKey(newSubStr))
                subStr = newSubStr;
            else {
                code = dict.get(subStr);
                output(code); // Mã hóa chuỗi cũ
                putToDict(newSubStr); // Add newSubStr to dict
                subStr = "" + c;
            }
            i++;
        }
        
        // Get the last code
        code = dict.get(subStr);
        output(code);
        zipped = true;
    }

    public Hashtable<String, Integer> getDict() {
        return dict;
    }

    public ArrayList<Integer> getZippedData() {
        return zippedData;
    }
    
    public int getMaxCode() {
        return code-1;
    }
}
