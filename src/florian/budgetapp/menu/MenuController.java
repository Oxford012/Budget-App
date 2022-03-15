package florian.budgetapp.menu;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import florian.budgetapp.group.Group;
import florian.budgetapp.group.SpendOn;
import florian.budgetapp.main.SceneController;
import java.io.*;
import java.util.concurrent.*;


public class MenuController {
    private final Group group;
    private final SceneController sceneController;
    private Stage stageAdd;
    private Stage stageClose;
    private Stage stagePie;
    private SpendOn spending;
    private boolean closeBool = false;

    public MenuController(Group group,SceneController sceneController){
        this.group = group;
        this.sceneController = sceneController;
    }

    public void openAddWindow(){
        try{
            Add add = new Add(this);
            this.spending = new SpendOn();
            Scene scene = new Scene(add.getAddPane(),200,250);
            this.stageAdd = new Stage();
            this.stageAdd.setScene(scene);
            this.stageAdd.setTitle("Hinzufügen");
            this.stageAdd.show();
        }catch(Exception e){
            System.out.println();
        }

    }

    public void openBackWindow(){
        try{
            Back back = new Back(this);
            Scene scene = new Scene(back.getBackPane(),200,60);
            this.stageClose = new Stage();
            this.stageClose.setScene(scene);
            this.stageClose.show();
        }catch (Exception e){
            System.out.println();
        }
    }

    public void setNewSpending(String name, String category, double amount){
        this.spending.setName(name);
        this.spending.setCategory(category);
        this.spending.setAmount(amount);
    }

    public void closeAddStage(){
        this.stageAdd.close();
        this.group.addSpending(this.spending);
        this.group.updateBudget();
    }

    public void closeBackStage(){
        this.stageClose.close();
    }

    public void getBack(){
        this.sceneController.changeScene("Start");
    }

    public void removeSpending(ListView listView){
        if(listView.getSelectionModel().isEmpty()){
            return;
        }
        Object removeSpend = listView.getSelectionModel().getSelectedItem();
        this.group.getSpendings().remove(removeSpend);
        this.group.updateBudget();
    }

    public Group getGroup(){
        return this.group;
    }

    public void openPieChartWindow() {
        try{
            Charts chart = new Charts(this);
            this.stagePie = new Stage();
            Scene scene = new Scene(chart.getChartPane(),500,500);
            this.stagePie.setScene(scene);
            this.stagePie.setOnCloseRequest(e -> this.closeBool = true);
            this.stagePie.show();
        }catch(Exception e){
            System.out.println(e);
        }
    }



    public void safeData(){
        try{
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(new Stage());
            fileChooser.setInitialDirectory(file);
            File myWriter = new File(file + ".txt");
            PrintWriter printWriter = new PrintWriter(myWriter);
            printWriter.println(this.group.getPersons() + " " + this.group.getAmount());
            for(SpendOn item : this.group.getSpendings()){
                printWriter.println(item.getCategory() + " " + item.getName() + " " + item.getAmount());
            }
            printWriter.close();



        }catch (IOException e){
            System.out.println("Error");
        }

    }

    public void update() {

    }
}
