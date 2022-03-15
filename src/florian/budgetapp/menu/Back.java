package florian.budgetapp.menu;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Back {
    private AnchorPane anchorPane;
    private Label label;
    private Button yes;
    private Button no;
    private HBox buttonBox;
    private MenuController menuController;

    public Back(MenuController menuController){
        this.menuController = menuController;
        this.anchorPane = new AnchorPane();
        this.label = new Label("Wollen Sie abbrechen?");
        this.yes = new Button("Ja");
        this.no = new Button("Nein");
        this.buttonBox = new HBox();

        this.buttonBox.getChildren().addAll(this.yes,this.no);
        this.buttonBox.setSpacing(20.0);

        AnchorPane.setLeftAnchor(buttonBox,50.0);
        AnchorPane.setRightAnchor(buttonBox,50.0);
        AnchorPane.setTopAnchor(buttonBox,30.0);

        AnchorPane.setLeftAnchor(label,30.0);
        AnchorPane.setTopAnchor(label,5.0);

        anchorPane.getChildren().addAll(this.buttonBox,this.label);

        this.yes.setOnAction(this::yesEvent);
        this.no.setOnAction(this::noEvent);

    }

    private void yesEvent(ActionEvent event) {
        this.menuController.getBack();
        this.menuController.closeBackStage();
    }

    private void noEvent(ActionEvent event) {
        this.menuController.closeBackStage();
    }

    public Pane getBackPane(){
        return this.anchorPane;
    }
}
