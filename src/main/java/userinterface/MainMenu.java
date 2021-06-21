package userinterface;
import utils.IoUtils;

public class MainMenu {

    public void startMenu() {
        System.out.println("Please select an option: "+ IoUtils.EOL + "1. View tracked items" + IoUtils.EOL + "2. Add a new item to be tracked" + IoUtils.EOL);
    }

    public void addUrlMenu(){
        System.out.println("Please input the URL: ");
    }

    public void setupNotifications(){
        System.out.println();
    }

    private void addEmailAddress(){

    }

}
