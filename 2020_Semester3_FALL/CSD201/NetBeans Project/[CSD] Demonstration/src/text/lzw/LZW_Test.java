/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.lzw;

import java.util.ArrayList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class LZW_Test {
    public static void main(String[] args) {
        String src = "LZW starts out with a dictionary of 256 characters\n" +
                "(in the case of 8 bits) and uses those as the \"standard\" character set.\n" +
                "It then reads data 8 bits at a time (e.g., 't', 'r', etc.) and encodes \n" +
                "the data as the number that represents its index in the dictionary.\n" +
                "Everytime it comes across a new substring (say, \"tr\")\n";
        System.out.println("Length of src string: " + src.length());
        LZW_Compressor compressor = new LZW_Compressor();
        compressor.zip(src);
        ArrayList<Integer> zippedData = compressor.getZippedData();
        System.out.println("Zipped data:\n" + zippedData);
        System.out.println("\nNumber of codewords after zipping: " + zippedData.size());
        
        // Unzip
        LZW_Decompressor decompressor = new LZW_Decompressor();
        decompressor.unzip(zippedData);
        String unzippedStr = decompressor.getUnzippedStr();
        System.out.println("After unzipping:\n\n" + unzippedStr);
    }
}
