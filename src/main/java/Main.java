import controller.Controller;
import userinterface.MainMenu;

public class Main {

    public static void main(String[] args) throws Exception {
        MainMenu menu = new MainMenu();

        Controller controller = new Controller(menu);
        controller.startMainMenuScreen();
    }
}
