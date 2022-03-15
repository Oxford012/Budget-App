package florian.budgetapp.charts;

import florian.budgetapp.group.SpendOn;
import florian.budgetapp.menu.MenuController;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

public class BarChartGraph {
    private MenuController menuController;
    private final BarChart<String, Number> barChart;
    private final CategoryAxis xAxis;
    private final NumberAxis yAxis;
    private int i;

    public BarChartGraph(MenuController menuController){

        this.menuController = menuController;
        this.xAxis = new CategoryAxis();
        this.yAxis = new NumberAxis();
        this.barChart = new BarChart<>(xAxis,yAxis);


        this.yAxis.setLabel("Euro");
        this.barChart.setAnimated(true);
        this.barChart.setTitle("Bar-Chart");
        this.barChart.setLegendVisible(false);
        this.barChart.setBarGap(10);
        this.barChart.lookupAll(".default-color0.chart-bar").forEach(n -> n.setStyle("-fx-bar-fill: blue;"));





    }


    public BarChart getBarChart(){
        return this.barChart;
    }

    public XYChart.Series getData(){
        XYChart.Series<String,Number> serie = new XYChart.Series<>();
        HashMap<String,Double> pieChartData = new HashMap<>();

        for(SpendOn item : this.menuController.getGroup().getSpendings()){
            if(pieChartData.containsKey(item.getCategory())){
                pieChartData.put(item.getCategory(), pieChartData.get(item.getCategory()) + item.getAmount());
            }else{
                pieChartData.put(item.getCategory(),item.getAmount());
            }
        }

        Iterator pieChartDataIterator = pieChartData.entrySet().iterator();

        while(pieChartDataIterator.hasNext()){
            Map.Entry element = (Map.Entry) pieChartDataIterator.next();
            serie.getData().add(new XYChart.Data(element.getKey(),element.getValue()));
        }

        return serie;

    }

}
