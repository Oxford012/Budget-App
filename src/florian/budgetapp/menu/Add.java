package florian.budgetapp.menu;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Add {
    private AnchorPane addPane;
    private MenuController menuController;
    private Button addButton;
    private Label name;
    private Label amount;
    private Label category;
    private TextField nameTextField;
    private TextField amountTextField;
    private TextField categoryTextField;
    private VBox vbox;

    public Add(MenuController menuController){
        this.menuController = menuController;

        this.addPane = new AnchorPane();
        this.vbox = new VBox();

        this.addButton = new Button("Hinzufügen");
        this.amount = new Label("Kosten:");
        this.name = new Label("Beschreibung");
        this.category = new Label("Kategorie:");
        this.amountTextField = new TextField();
        this.categoryTextField = new TextField();
        this.nameTextField = new TextField();

        this.vbox.getChildren().addAll(this.name,this.nameTextField,this.category,this.categoryTextField,this.amount,this.amountTextField,this.addButton);
        this.vbox.setSpacing(10);

        AnchorPane.setTopAnchor(this.vbox,5.0);
        AnchorPane.setLeftAnchor(this.vbox, 20.0);

        addPane.getChildren().add(vbox);

        this.addButton.setOnAction(this::addNewSpending);
    }

    public Pane getAddPane(){
        return addPane;
    }

    public String getName(){
        return this.nameTextField.getText();
    }

    public String getCategory(){
        return this.categoryTextField.getText();
    }

    public double getAmount(){
        return Double.valueOf(amountTextField.getText());
    }

    public void addNewSpending(Event e){
        try{
            this.menuController.setNewSpending(this.getName(),this.getCategory(),this.getAmount());
            this.menuController.closeAddStage();
        }catch(Exception ex){
            System.out.println(ex);
        }

    }
}

