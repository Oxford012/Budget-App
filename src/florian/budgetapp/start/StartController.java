package florian.budgetapp.start;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import florian.budgetapp.group.Group;
import florian.budgetapp.group.SpendOn;
import florian.budgetapp.menu.Menu;
import florian.budgetapp.menu.MenuController;
import florian.budgetapp.main.SceneController;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class StartController {
    private SceneController sceneController;
    private File file;


    public StartController(){
    }

    public void importEvent(){
        FileChooser fileChooser = new FileChooser();
        boolean cancel = false;
        try{
            this.file = fileChooser.showOpenDialog(new Stage());
            ArrayList<String> groupObject = new ArrayList<>();
            Scanner scanner = new Scanner(Paths.get(this.file.getPath()));
            while(scanner.hasNextLine()){
                groupObject.add(scanner.nextLine());
            }

            String[] basicData = groupObject.get(0).split(" ");
            Group group = new Group(Integer.valueOf(basicData[0]),Double.valueOf(basicData[1]));

            ObservableList<SpendOn> spendings = FXCollections.observableArrayList();
            for(int i = 1; i < groupObject.size(); i++){
                String[] item = groupObject.get(i).split(" ");
                SpendOn newSpend = new SpendOn(item[0],item[1],Double.valueOf(item[2]));
                spendings.add(newSpend);
            }
            group.setSpendings(spendings);

            MenuController menuController = new MenuController(group,this.sceneController);
            Menu menu = new Menu(menuController);
            this.sceneController.addScene("Menu", menu.getMenuGrid());
            this.sceneController.changeScene("Menu");

        }catch (Exception e){
            System.out.println("Error");
        }

    }

    public void createGroup(int persons, double amount){
        Group group = new Group(persons,amount);
        MenuController menuController = new MenuController(group,this.sceneController);
        Menu menu = new Menu(menuController);
        this.sceneController.addScene("Menu", menu.getMenuGrid());
        this.sceneController.changeScene("Menu");
    }

    public void getSceneController(SceneController sceneController){
        this.sceneController = sceneController;
    }



}
