package florian.budgetapp.menu;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import florian.budgetapp.group.Group;
import florian.budgetapp.group.SpendOn;


public class Menu {
    private final AnchorPane menuPane;
    private final Button backButton;
    private final Label overview;
    private final MenuController menuController;
    private final Button addingButton;
    private Label budgetLabel;
    private Group group;
    private ListView<SpendOn> list;
    private ObservableList<SpendOn> spendList;
    private Button safeButton;
    private Button removeButton;
    private Button pieChartButton;
    private SimpleDoubleProperty budgetField;


    public Menu(MenuController menuController) {

        //Initialisierungen----------------------------------------------------
        this.removeButton = new Button("Entfernen");
        this.menuController = menuController;
        this.menuPane = new AnchorPane();
        this.safeButton = new Button("Speichern");
        this.backButton = new Button("Abbrechen");
        this.addingButton = new Button("Ausgabe\nhinzufügen");
        this.pieChartButton = new Button("Charts");
        this.overview = new Label("Personen: " + this.menuController.getGroup().getPersons() + "\nBudget:");
        this.budgetLabel = new Label();
        this.list = new ListView<>();
        this.group = this.menuController.getGroup();
        this.spendList = this.group.getSpendings();
        this.budgetLabel = new Label();
        this.budgetField = this.group.getBudget();
        //---------------------------------------------------------------------


        //AnchorPane Formatierungen---------------------------------------------
        AnchorPane.setRightAnchor(this.safeButton,5.0);
        AnchorPane.setBottomAnchor(this.safeButton,100.0);

        AnchorPane.setTopAnchor(this.budgetLabel, 22.0);
        AnchorPane.setLeftAnchor(this.budgetLabel, 50.0);

        AnchorPane.setRightAnchor(this.pieChartButton, 5.0);
        AnchorPane.setBottomAnchor(this.pieChartButton, 140.0);

        AnchorPane.setRightAnchor(this.removeButton,5.0);
        AnchorPane.setBottomAnchor(this.removeButton,60.0);

        AnchorPane.setRightAnchor(this.addingButton,5.0);
        AnchorPane.setBottomAnchor(this.addingButton,5.0);

        AnchorPane.setTopAnchor(this.overview, 5.0);
        AnchorPane.setLeftAnchor(this.overview, 5.0);

        AnchorPane.setBottomAnchor(this.backButton, 5.0);
        AnchorPane.setLeftAnchor(this.backButton, 5.0);

        AnchorPane.setLeftAnchor(this.list, 100.0);
        AnchorPane.setBottomAnchor(this.list, 5.0);
        AnchorPane.setRightAnchor(this.list, 100.0);
        AnchorPane.setTopAnchor(this.list, 5.0);
        //-----------------------------------------------------------------------


        //Funktionen-------------------------------------------------------------
        this.menuController.getGroup().updateBudget();
        this.budgetLabel.textProperty().bind(this.budgetField.asString());
        this.list.setItems(spendList);

        this.menuPane.getChildren().addAll(this.overview, this.budgetLabel, this.pieChartButton);
        this.menuPane.getChildren().addAll(this.backButton,this.addingButton,this.removeButton,this.safeButton);
        this.menuPane.getChildren().addAll(this.list);

        this.pieChartButton.setOnAction(this::openPieChartEvent);
        this.backButton.setOnAction(this::getBackEvent);
        this.addingButton.setOnAction(this::addingEvent);
        this.removeButton.setOnAction(this::removeEvent);
        this.safeButton.setOnAction(this::safeEvent);
        //-----------------------------------------------------------------------

    }

    private void safeEvent(ActionEvent event) {
        this.menuController.safeData();
    }

    private void openPieChartEvent(ActionEvent event) {
        this.menuController.openPieChartWindow();
    }

    public void addingEvent(ActionEvent e){
        this.menuController.openAddWindow();
    }

    public void removeEvent(ActionEvent event){
        this.menuController.removeSpending(this.list);
    }

    public void getBackEvent(ActionEvent e){
        this.menuController.openBackWindow();
    }

    public Pane getMenuGrid() {
        return this.menuPane;
    }



}


