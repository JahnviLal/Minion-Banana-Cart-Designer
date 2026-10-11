//Jahnvi Lal
//CS2450
//Assignment 2
//10/11/2026

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
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
        
        //Build the Interface
        Label partsLabel = new Label("Select Cart Parts:");
        VBox cartParts = new VBox
        (
            partsLabel, 
            cartPartsSection(), 
            suppliesSection()
        );
        cartParts.setAlignment(Pos.TOP_CENTER);
        cartParts.setStyle("-fx-background-color: #f9f0ac;");

        //Create the scene and display the stage
        Scene scene = new Scene(cartParts, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Create the cart parts selection controls
    private HBox cartPartsSection()
    {
        ComboBox<String> cartBodies = new ComboBox<>();
        cartBodies.getItems().addAll("Banana Blaster [$60]","Jelly Lab Runner [$45]","Gru Escape Cart [$50]");
        ComboBox<String> engineAssemblies = new ComboBox<>();
        engineAssemblies.getItems().addAll("7.75-inch axle [$35]", "8-inch axle [$40]", "8.5-inch axle [$45]");
        ComboBox<String> wheelSets = new ComboBox<>();
        wheelSets.getItems().addAll("51 mm [$20]", "55 mm [$22] ", "58 mm [$24]", "61 mm [$28] ");

        VBox bodyBox = new VBox(new Label("Cart Bodies"), cartBodies);
        VBox engineBox = new VBox(new Label("Engine Assemblies"), engineAssemblies);
        VBox wheelBox = new VBox(new Label("Wheel Sets"), wheelSets);

        bodyBox.setAlignment(Pos.CENTER);
        engineBox.setAlignment(Pos.CENTER);
        wheelBox.setAlignment(Pos.CENTER);
 
        bodyBox.setSpacing(5);
        engineBox.setSpacing(5);
        wheelBox.setSpacing(5);

        HBox selections = new HBox(bodyBox, engineBox, wheelBox);
        selections.setSpacing(25);

        return selections;
    }

        //Create option supplies controls
        private VBox suppliesSection()
        {
            Label suppliesLabel = new Label("Optional Supplies:");
            suppliesLabel.setAlignment(Pos.CENTER);

            CheckBox gripTape = new CheckBox("Banana grip tape [$10]");
            CheckBox goggles = new CheckBox("Goggles [$30]");
            CheckBox riserPads = new CheckBox("Riser pads [$2]");
            CheckBox nutsBolts = new CheckBox("Nuts and bolts kit [$3]");

            HBox supplies = new HBox(gripTape, goggles, riserPads, nutsBolts);
            supplies.setAlignment(Pos.CENTER);
            supplies.setSpacing(20);

            VBox suppliesSection = new VBox(suppliesLabel, supplies);
            suppliesSection.setAlignment(Pos.TOP_CENTER);

            return suppliesSection;
        }   
}
 


