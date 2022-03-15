package florian.budgetapp.main;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class SceneController {
    private Scene scene;
    private HashMap<String, Pane> scenes = new HashMap<>();

    public SceneController(Scene scene){
        this.scene = scene;
    }

    public void addScene(String name, Pane pane){
        scenes.put(name, pane);
    }


    public void changeScene(String name){
        scene.setRoot(scenes.get(name));
    }

    public Scene getScene(){
        return this.scene;
    }


}
