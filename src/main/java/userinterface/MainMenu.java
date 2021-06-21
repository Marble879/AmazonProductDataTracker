package userinterface;
import utils.IoUtils;

public class MainMenu {

    public void startMenu() {
        System.out.println("Please select an option: "+ IoUtils.EOL + "1. View tracked items" + IoUtils.EOL + "2. Add a new item to be tracked" + IoUtils.EOL + "3. exit" + IoUtils.EOL);
    }

    public void addUrlMenu(){
        System.out.println("Please select an option: " + IoUtils.EOL + "1. Add a new URL" + "2. return" + IoUtils.EOL);
    }

    public void setupNotificationsMenu(){
        System.out.println("Please select an option: " + IoUtils.EOL + "1. Enable notifications" + IoUtils.EOL + "2. Disable notifications" + IoUtils.EOL + "3. return" + IoUtils.EOL);
    }

    public void addNewURLMessage(){ // will be used by the addUrlMenu()
        System.out.println("Please input the URL: " + IoUtils.EOL);
    }

    public void addEmailAddressMessage() { // Will be used by sssetupNotiicationsMenu()
        System.out.println("Please input your email: " + IoUtils.EOL);
    }

}
