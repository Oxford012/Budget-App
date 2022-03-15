package florian.budgetapp.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import florian.budgetapp.start.Start;
import florian.budgetapp.start.StartController;

public class Main extends Application {

    private SceneController sceneController;
    private Start start;
    private StartController startController;

    public void start(Stage primaryStage) {

        this.startController = new StartController();
        this.start = new Start(this.startController);
        this.sceneController = new SceneController(new Scene(start.getStartPane(),400,400));
        this.startController.getSceneController(this.sceneController);
        this.sceneController.addScene("Start",start.getStartPane());




        primaryStage.setTitle("Budget-Manager");
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setScene(sceneController.getScene());
        primaryStage.show();

    }

        public static void main (String[]args){
            launch(args);
        }



}
