package controller;

import userinterface.MainMenu;

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

    private String addNewURL(){
        String URL;
        URL = menu.addNewURL();
        return URL;
    }

    private void returningMenuMessage(){
        menu.returningMessage();
    }
}
