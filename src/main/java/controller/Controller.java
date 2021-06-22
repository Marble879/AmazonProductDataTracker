package controller;

import userinterface.MainMenu;

public class Controller {

    private MainMenu menu;

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
            //System.out.println(choice);
        } while (!(choice == 4));
    }

    private void addUrlMenu(){
        menu.addUrlMenu();
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

}
