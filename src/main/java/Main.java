import controller.Controller;
import storage.Storage;
import userinterface.MainMenu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        MainMenu menu = new MainMenu();
        Storage storage = new Storage();
        Controller controller = new Controller(menu, storage);
        controller.startMainMenuScreen();
    }
}
