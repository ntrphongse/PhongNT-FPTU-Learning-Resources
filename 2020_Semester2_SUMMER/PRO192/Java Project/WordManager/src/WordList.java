
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class WordList {
    HashMap<String, ArrayList<String>> list;
    
    public WordList()
    {
        list = new HashMap<>();
    }
    
    // Chèn các words cho trước vào list
    public void createVocabulary()
    {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("Apple");
        a1.add("arm");
        a1.add("Ant");
        list.put("A", a1);
        
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("Book");
        a2.add("ban");
        list.put("B", a2);
        
        ArrayList<String> a3 = new ArrayList<>();
        a3.add("Can");
        list.put("C", a3);
    }
    
    // Xuất key và value của list
    public void display()
    {
        Set<String> ks = list.keySet(); // Lấy tất cả các key
        for (String k : ks) {
            ArrayList<String> v = list.get(k);
            System.out.println(k + " -> " + v);
        }
    }
    
    // Xuất các Words trong list không cần dùng key
    public void display2()
    {
        Collection<ArrayList<String>> kq = list.values();
        for (ArrayList<String> arrayList : kq) {
            System.out.println(arrayList);
        }
    }
    
    // Tìm key có chứa nhiều word (từ) nhất
    public String getKeyMax()
    {
        //TODO:
        String rKey = "";
        int MaxSize = 0;
        Set<String> sKey = list.keySet();
        for (String key : sKey) {
            ArrayList<String> rValues = list.get(key);
            if (rValues.size() > MaxSize)
            {
                MaxSize = rValues.size();
                rKey = key;
            }
            else if (rValues.size() == MaxSize)
                rKey += ", " + key;
        }
        return rKey;
    }
    
    // Trả về value trong list chứa nhiều từ nhất
    public ArrayList<String> getMax()
    {
        //TODO:
        int MaxNumWord = 0;
        ArrayList<String> rValues = null;
        Set<String> sKey = list.keySet();
        for (String key : sKey) {
            ArrayList<String> sValues = list.get(key);
            if (sValues.size() > MaxNumWord)
            {
                rValues = sValues;
                MaxNumWord = sValues.size();
            }
        }
        return rValues;
    }
    
    // Check 1 word có trong list hay không
    public boolean checkWord(String word)
    {
        //TODO:
        String cKey = Character.toString(word.charAt(0));
        ArrayList<String> sValues = list.get(cKey);
        if (sValues == null)
            return false;
        for (String sValue : sValues) {
            if (word.equalsIgnoreCase(sValue))
                return true;
        }
        return false;
    }
    
    // Thêm một word mới vào list
    public void addWord(String word)
    {
        int checkAdd = 0;
        if (checkWord(word))
            System.out.println("Word existed! Can't add!");
        else
        {
            String aKey = Character.toString(word.charAt(0)).toUpperCase();
            Set<String> sKey = list.keySet();
            for (String key : sKey) {
                if (aKey.equals(key))
                {
                    list.get(key).add(word);
                    checkAdd = 1;
                }
            }
            if (checkAdd == 0)
            {
                ArrayList<String> aValues = new ArrayList<>();
                aValues.add(word);
                list.put(aKey, aValues);
            }
            System.out.println("Add successfully!");
        }
    }
    
    // Xóa 1 word trong list
    public void deleteWord(String word)
    {
        if (!checkWord(word))
            System.out.println("No such word to delete!");
        else
        {
            Set<String> sKey = list.keySet();
            for (String key : sKey) {
                if (Character.toString(word.charAt(0)).equalsIgnoreCase(key))
                {
                    ArrayList<String> sValues = list.get(key);
                    int indexWord = -1;
                    for (int i = 0; i < sValues.size(); i++)
                        if (sValues.get(i).equalsIgnoreCase(word))
                            indexWord = i;
                    list.get(key).remove(indexWord);
                    if (list.get(key).size() == 0)
                        list.remove(key);
                }
            }
            System.out.println("Delete word successfully!");
        }
    }
    
    // Sửa một word tìm thấy thanh word khac
    /*
    oldWord = "arm"
    newWord = "array"
    //
    oldWord = "arm"
    newWord = "Berry" => Không sửa được
    //
    oldWord = "arm"
    newWord = "Apple" => Không sửa được
    //
    oldWord = "arm"
    newWord = "Arm"   => Không sửa
    */
    public void editWord(String oldWord, String newWord)
    {
        String fOldWord = Character.toString(oldWord.charAt(0)).toUpperCase();
        String fNewWord = Character.toString(newWord.charAt(0)).toUpperCase();
        if (!fOldWord.equals(fNewWord))
            System.out.println("New Word is not the same first character as the old word! Can't edit!");
        else if (oldWord.equalsIgnoreCase(newWord))
            System.out.println("Old Word and New Word are the same! Can't edit!");
        else if (checkWord(newWord))
            System.out.println("New Word is existed in the Map! Can't edit!");
        else if (!checkWord(oldWord))
            System.out.println("The Old Word is not existed in the Map! Can't edit!!");
        else
        {
            ArrayList<String> sValues = list.get(fOldWord);
            int indexWord = -1;
            for (int i = 0; i < sValues.size(); i++)
                if (sValues.get(i).equalsIgnoreCase(oldWord))
                {
                    indexWord = i;
                    break;
                }
            list.get(fOldWord).set(indexWord, newWord);
        }
            System.out.println("Edit word successfully!");
    }
}
