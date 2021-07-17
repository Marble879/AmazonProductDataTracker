package storage;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Storage {

    public void saveToJson(ArrayList<String> arrayList) {
        try {
            FileWriter fw = new FileWriter("urlList.json");
            new Gson().toJson(arrayList, fw);
            fw.close();
            System.out.println(new Gson().toJson(arrayList));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
