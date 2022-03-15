package florian.budgetapp.charts;

import florian.budgetapp.group.SpendOn;
import florian.budgetapp.menu.MenuController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


public class PieChartGraph {
    private MenuController menuController;
    private Stage stage;
    private Scene scene;
    private final PieChart chart;
    private ObservableList<PieChart.Data> pieChartData;



    public PieChartGraph(MenuController menuController){
        this.menuController = menuController;
        this.stage = new Stage();
        this.scene = new Scene(new Group());
        this.pieChartData = FXCollections.observableArrayList();
        this.stage.setTitle("Pie-Chart");
        this.stage.setWidth(500);
        this.stage.setHeight(500);

        this.chart = new PieChart();

        this.chart.setAnimated(true);




        chart.setTitle("Geld pro Kategorie");

        ((Group) scene.getRoot()).getChildren().add(chart);


    }


    public PieChart getPieChart(){
        return this.chart;
    }

    public ObservableList<PieChart.Data> getData(){
        if(this.menuController.getGroup().getBudget().getValue() > 0){
            PieChart.Data remainingBudget = new PieChart.Data("Restliches Budget",this.menuController.getGroup().getBudget().getValue());
            pieChartData.add(remainingBudget);
        }

        for(SpendOn item : this.menuController.getGroup().getSpendings()){
            boolean con = false;
            PieChart.Data newData = new PieChart.Data(item.getCategory(), item.getAmount());
            for(PieChart.Data data : pieChartData){
                if(data.getName().equals(newData.getName())){
                    data.setPieValue(data.getPieValue()+ newData.getPieValue());
                    con = true;
                }
            }
            if(!con){
                pieChartData.add(newData);
            }
        }
        return pieChartData;
    }
}
