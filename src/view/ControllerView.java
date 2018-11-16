package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ControllerView extends Application
{
    @Override
    public void start(Stage primaryStage) // throws Exception
    {
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Ticket To Ride");

        GridPane grid = new GridPane();
        Label label = new Label("Hello world.");
        Scene scene = new Scene(grid, 300, 275);
        grid.add(label, 0, 0);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
