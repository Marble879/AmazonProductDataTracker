package controller;

import storage.Storage;
import userinterface.MainMenu;

import java.io.File;
import java.util.ArrayList;

public class Controller {

    private final MainMenu menu;
    private Storage storage;
    private ArrayList<String> urlList;

    public Controller(MainMenu menu, Storage storage){
        this.menu = menu;
        this.storage = storage;
        this.urlList = new ArrayList<String>();
    }

    public ArrayList<String> getUrlList(){
        return this.urlList;
    }

    public void startMainMenuScreen() throws Exception{
        loadUrlListIfExists();
        displayStartMenu();
    }

    private void displayStartMenu() throws Exception{
        int choice;
        do {
            choice = menu.startMenu();
            switch (choice) {
                case 1 -> viewTrackedItems();
                case 2 -> addUrlMenu();
                case 3 -> setupNotificationsMenu();
                case 4 -> exitingMessage();
                default -> invalidMenuInputMessage();
            }
        } while (!(choice == 4));
    }

    private void addUrlMenu() throws Exception{
        int choice;
        do{
            choice = menu.addUrlMenu();
            switch (choice) {
                case 1 -> addNewURL();
                case 2 -> returningMenuMessage();
                default -> invalidMenuInputMessage();
            }
        } while (!(choice == 2));
    }

    private void viewTrackedItems(){
        menu.viewTrackedItems();
    }

    private void exitingMessage(){
        menu.exitingMessage();
    }

    private void setupNotificationsMenu(){
        menu.setupNotificationsMenu();
    }

    private void invalidMenuInputMessage(){
        menu.invalidMenuInputMessage();
    }

    private void addNewURL(){
        String url = getNewURL();
        if (!isDuplicate(url)){
            this.urlList.add(url);
            storage.saveToJson(this.urlList);
        } else {
            System.out.println("This URL already exists!");
        }
    }

    private String getNewURL(){
        String URL;
        URL = menu.getNewURL();
        return URL;
    }

    private void returningMenuMessage(){
        menu.returningMessage();
    }

    private boolean isDuplicate(String urlToAdd){
        return this.urlList.contains(urlToAdd);
    }

    private void loadUrlListIfExists(){
        if(doesFileExist()){
            this.urlList = storage.getUrlData();
        }
    }

    private boolean doesFileExist(){
        File urlListFile = new File("urlList.json");
        return urlListFile.exists();
    }
}
