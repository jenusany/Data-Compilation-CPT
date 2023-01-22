package cpt;
 
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
 
 
/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */
public class BarChartApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }
 
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
 
    public Parent createContent() {
        
        String[] years = {"2007", "2008", "2009", "2010"};
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("Units Sold", 0.0d, 10, 1000.0d);
        ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
                new BarChart.Series("Apples",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], 8),
                    new BarChart.Data(years[1], 8),
                    new BarChart.Data(years[2], 8))),

                new BarChart.Series("Lemons",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], 8),
                    new BarChart.Data(years[1], 8),
                    new BarChart.Data(years[2], 8))),

                new BarChart.Series("Oranges", FXCollections.observableArrayList(new BarChart.Data(years[0], 8),new BarChart.Data(years[1], 8),new BarChart.Data(years[2], 8))));
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);
        return chart;
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

}