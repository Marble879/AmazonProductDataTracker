package controller;

import scraper.Scraper;
import storage.Storage;
import userinterface.MainMenu;
import utils.IoUtils;

import java.io.File;
import java.net.URL;
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
        System.out.println(getAllTrackedProductInfo());
    }

    private String getAllTrackedProductInfo(){
        if (this.urlList != null && !this.urlList.isEmpty()) {
            String trackedProductInfo = "";
            Scraper scraper;
            for (String url : this.urlList){
                scraper = new Scraper(url);
                trackedProductInfo = scraper.getProductPrice() + IoUtils.EOL + scraper.getSuggestedDeliveryTime() + IoUtils.EOL;
            }
            return trackedProductInfo;
        } else {
            return "No products are currently being tracked!";
        }

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
