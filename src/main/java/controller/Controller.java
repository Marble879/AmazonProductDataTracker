package controller;

import userinterface.MainMenu;

import java.util.ArrayList;

public class Controller {

    private final MainMenu menu;

    public Controller(MainMenu menu){
        this.menu = menu;
    }

    public void startMainMenuScreen() throws Exception{
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
        String URL = getNewURL();
        // TODO make object call that will store the url as json format.
        // TODO maybe separate method: check if make new json file, or update if there is an existing file.
    }
    private String getNewURL(){
        String URL;
        URL = menu.getNewURL();
        return URL;
    }

    private void returningMenuMessage(){
        menu.returningMessage();
    }

    private boolean isDuplicate(ArrayList<String> urlList, String urlToAdd){
        return urlList.contains(urlToAdd);
    }
}
