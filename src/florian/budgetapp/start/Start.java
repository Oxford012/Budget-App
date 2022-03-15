package florian.budgetapp.start;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Start {
    private AnchorPane anchorPane;
    private VBox vbox;
    private Button createButton;
    private Button importButton;
    private TextField amountTextField;
    private TextField personsTextField;
    private Label error;
    private Label personsLabel;
    private Label amountLabel;
    private StartController startController;



    public Start(StartController startController){
        this.startController = startController;
        this.anchorPane = new AnchorPane();
        this.personsLabel = new Label("Wie viele Personen seid ihr?");
        this.personsTextField = new TextField();
        this.amountLabel = new Label("Wie viel soll jede Person bezahlen?");
        this.amountTextField = new TextField();
        this.createButton = new Button("Bestätigen");
        this.error = new Label();
        this.importButton = new Button("Import");
        this.vbox = new VBox();





        this.vbox.getChildren().addAll(this.personsLabel,this.personsTextField,this.amountLabel,this.amountTextField,this.createButton,this.importButton,this.error);
        this.vbox.setAlignment(Pos.CENTER);
        this.vbox.setSpacing(10);




        AnchorPane.setLeftAnchor(vbox,100.0);
        AnchorPane.setRightAnchor(vbox,100.0);
        AnchorPane.setTopAnchor(vbox,50.0);


        this.anchorPane.getChildren().add(vbox);
        this.createButton.setOnAction(this::createEvent);
        this.importButton.setOnAction(this::importEvent);

    }

    private void importEvent(ActionEvent event) {
        this.startController.importEvent();
    }

    public void createEvent(ActionEvent e){
        try{
            this.error.setText("");
            this.startController.createGroup(this.getPersons(),this.getAmount());
        }catch(Exception ex){
            System.out.println(ex);;

            }
    }

    public Pane getStartPane(){
        return this.anchorPane;
    }

    public int getAmount(){
        return Integer.valueOf(this.amountTextField.getText());
    }

    public int getPersons(){
        return Integer.valueOf(this.personsTextField.getText());
    }

}

