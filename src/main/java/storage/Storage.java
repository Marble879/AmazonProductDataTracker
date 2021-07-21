package storage;
import com.google.gson.Gson;
import scraper.Url;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Storage {

    public void saveToJson(ArrayList<Url> arrayList) {
        try {
            FileWriter fw = new FileWriter("urlList.json");
            new Gson().toJson(arrayList, fw);
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Url> getUrlData(){
        ArrayList<Url> urlList = new ArrayList<Url>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("urlList.json"));
            urlList = new Gson().fromJson(reader, ArrayList.class);
            reader.close();
        } catch (Exception e){
            if (e instanceof NoSuchFileException){
                System.out.println("Url list file not found! Please save your URLs for the file to become available");
            } else {
                e.printStackTrace();
            }
        }
        return urlList;
    }

}
