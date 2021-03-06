package controller;

import scraper.Scraper;
import scraper.Url;
import storage.Storage;
import userinterface.MainMenu;
import utils.InputClass;
import utils.IoUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class Controller {

    private final MainMenu menu;
    private Storage storage;
    private ArrayList<Url> urlList;

    public Controller(MainMenu menu, Storage storage){
        this.menu = menu;
        this.storage = storage;
        this.urlList = new ArrayList<Url>();
    }

    public ArrayList<Url> getUrlList(){
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
                case 3 -> removeUrlMenu();
                case 4 -> exitingMessage();
                default -> invalidMenuInputMessage();
            }
        } while (!(choice == 4));
    }

    public void removeUrlMenu() throws Exception{
        menu.removeUrlMenu();
        String urlOptionsOutput = "";
        if (this.urlList != null && !this.urlList.isEmpty()){
            for (int i = 0; i < this.urlList.size(); i++){
                urlOptionsOutput = urlOptionsOutput + (i+1) +". " + this.urlList.get(i).getProductName() + IoUtils.EOL;
            }
            System.out.println(urlOptionsOutput);
            int choice = InputClass.readInt("Input number of the url to remove: ");
            choice--; // need to reduce the value by one to be consistent with array index numbers
            removeUrl(choice);
        } else {
            System.out.println("No urls have been added yet!");
        }
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
            for (Url url : this.urlList){
                scraper = new Scraper(url.getUrl());
                trackedProductInfo = trackedProductInfo + url.getProductName() + IoUtils.EOL + scraper.getProductPrice() + IoUtils.EOL + scraper.getSuggestedDeliveryTime() + IoUtils.EOL + IoUtils.OUTPUT_LINE + IoUtils.EOL;
            }
            return trackedProductInfo;
        } else {
            return "No products are currently being tracked! " + IoUtils.EOL;
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
        Url url = getNewURL();
        if (!isDuplicate(url.getUrl())){
            this.urlList.add(url);
            storage.saveToJson(this.urlList);
        } else {
            System.out.println("This URL already exists!");
        }
    }

    private Url getNewURL(){
        Url url = new Url(menu.getNewUrl(), menu.getNewUrlName());
        return url;
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

    private void removeUrl(int index){
        this.urlList.remove(index);
        storage.saveToJson(this.urlList);
    }
}
