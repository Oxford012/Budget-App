package florian.budgetapp.menu;

import florian.budgetapp.charts.BarChartGraph;
import florian.budgetapp.charts.PieChartGraph;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Charts {
    private TabPane tabPane;
    private MenuController menuController;
    private Stage stage;
    private Button update1;
    private Button update2;
    private BarChartGraph barChart;
    private PieChartGraph pieChart;




    public Charts(MenuController menuController){
        this.menuController = menuController;
        this.tabPane = new TabPane();
        this.stage = new Stage();

        this.update1 = new Button("Aktualisieren");
        this.update2 = new Button("Aktualisieren");

        this.stage.setTitle("Charts");
        this.stage.setWidth(500);
        this.stage.setHeight(500);


        this.pieChart = new PieChartGraph(this.menuController);
        this.barChart = new BarChartGraph(this.menuController);



        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();


        this.barChart.getBarChart().getData().clear();
        this.barChart.getBarChart().getData().add(this.barChart.getData());
        this.pieChart.getPieChart().getData().clear();
        this.pieChart.getPieChart().setData(this.pieChart.getData());

        this.update1.setOnAction(this::updateEvent);
        this.update2.setOnAction(this::updateEvent);

        Tab tab1 = new Tab(" Pie-Chart ");
        tab1.setId("Pie");
        Tab tab2 = new Tab("Bar-Chart");
        tab2.setId("Bar");


        vBox1.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.CENTER);

        vBox1.setSpacing(10);

        vBox1.getChildren().addAll(pieChart.getPieChart(),this.update1);
        vBox2.getChildren().addAll(barChart.getBarChart(),this.update2);

        tab1.setContent(vBox1);
        tab2.setContent(vBox2);

        tabPane.getTabs().addAll(tab1,tab2);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);


    }

    private void updateEvent(ActionEvent event) {
        this.barChart.getBarChart().getData().clear();
        this.barChart.getBarChart().getData().add(this.barChart.getData());
        this.pieChart.getPieChart().getData().clear();
        this.pieChart.getPieChart().setData(this.pieChart.getData());
    }

    public TabPane getChartPane(){
        return this.tabPane;
    }


}
