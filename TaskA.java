//Jahnvi Lal
//CS2450
//Assignment 2
//10/11/2026

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;


public class TaskA extends Application 
{
    public static void main(String [] args)
    {
        // Launch the apllication
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  
    {
        //Set stage title
        primaryStage.setTitle("Minion Banana Cart Designer");

        // Create ComboBox Controls
        ComboBox<String> cartBodies = new ComboBox<>();
        cartBodies.getItems().addAll("Banana Blaster","Jelly Lab Runner","Gru Escape Cart");

        ComboBox<String> engineAssemblies = new ComboBox<>();
        engineAssemblies.getItems().addAll("7.75-inch axle", "8-inch axle", "8.5-inch axle");

        ComboBox<String> wheelSets = new ComboBox<>();
        wheelSets.getItems().addAll("51 mm", "55 mm", "58 mm", "61 mm");

        VBox bodyBox = new VBox(
            new Label("Cart Bodies", 
            cartBodies));
        VBox engineBox = new VBox(
            new Label("Engine Assemblies",
            engineAssemblies)
            );
        VBox wheelBox = new VBox(
            new Label("Wheel Sets", 
            wheelSets));

        HBox selections = new HBox(bodyBox, engineBox, wheelBox);
        selections.setSpacing(20);

        // Create a VBox for the parts label 
        Label partsLabel = new Label("Select Cart Parts:");

        Label suppliesLabel = new Label("Optional Supplies:");
        suppliesLabel.setAlignment(Pos.CENTER);

        VBox cartParts = new VBox(partsLabel, selections, suppliesLabel);
        cartParts.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(cartParts, 500, 300);

        primaryStage.setScene(scene);
        primaryStage.show();  
    } 
}
 



