package storage;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Storage {

    public void saveToJson(ArrayList<String> arrayList) {
        try {
            FileWriter fw = new FileWriter("urlList.json");
            new Gson().toJson(arrayList, fw);
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getUrlData(){
        ArrayList<String> urlList = new ArrayList<String>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("urlList.json"));
            urlList = new Gson().fromJson(reader, ArrayList.class);
            reader.close();
        } catch (Exception e){
            if (e instanceof NoSuchFileException){
                System.out.println("ERROR: url list file not found! Please save your URLs for the file to become available");
            } else {
                e.printStackTrace();
            }
        }
        return urlList;
    }

}
