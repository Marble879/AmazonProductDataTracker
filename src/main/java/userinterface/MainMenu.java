package userinterface;
import utils.InputClass;
import utils.IoUtils;

public class MainMenu {

    public int startMenu() throws Exception{
        int choice = InputClass.readInt("Please select an option: "+ IoUtils.EOL + "1. View tracked items" + IoUtils.EOL + "2. Add a new item to be tracked" + IoUtils.EOL + "3. Remove a tracked product/url" + IoUtils.EOL + "4. exit" + IoUtils.EOL);
        return choice;
    }

    public int addUrlMenu() throws Exception {
        int choice = InputClass.readInt("Please select an option: " + IoUtils.EOL + "1. Add a new URL" + IoUtils.EOL + "2. return" + IoUtils.EOL);
        return choice;
    }

    public void setupNotificationsMenu(){
        System.out.println("Please select an option: " + IoUtils.EOL + "1. Enable notifications" + IoUtils.EOL + "2. Disable notifications" + IoUtils.EOL + "3. return" + IoUtils.EOL);
    }

    public String getNewUrl(){ // will be used by the addUrlMenu()
        String url;
        url = InputClass.readLine("Please input the URL: " + IoUtils.EOL);
        return url;
    }

    public String getNewUrlName(){
        String name;
        name = InputClass.readLine("Please input the name of the URL: " + IoUtils.EOL);
        return name;
    }

    public void addEmailAddressMessage() { // Will be used by setupNotiicationsMenu()
        System.out.println("Please input your email: " + IoUtils.EOL);
    }

    public void exitingMessage(){
        System.out.println("Exiting...");
    }

    public void returningMessage(){
        System.out.println("Returning...");
    }

    public void viewTrackedItems(){
        System.out.println("Currently tracked items: " + IoUtils.EOL);
    }

    public void invalidMenuInputMessage(){
        System.out.println("Error, invalid input. Please re-enter a menu option: " + IoUtils.EOL);
    }

    public void removeUrlMenu(){
        System.out.println("Please select the number of the product that should no longer be tracked: " + IoUtils.EOL);
    }

}
