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
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class TaskA extends Application 
{
    //Create Fields
    private ComboBox<String> cartBodies;
    private ComboBox<String> engineAssemblies;
    private ComboBox<String> wheelSets;

    private CheckBox gripTape;
    private CheckBox goggles;
    private CheckBox riserPads;
    private CheckBox nutsBolts;

    private Button calculateButton;
    private Label subtotalLabel;
    private Label salesTaxLabel;
    private Label totalLabel;
    private Label messageLabel;

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
        partsLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2F5D8C");
        Label spacer = new Label("\n");

        VBox cartParts = new VBox
        (
            partsLabel, 
            cartPartsSection(), 
            suppliesSection(),
            spacer,
            calculationSection()
        );
        cartParts.setAlignment(Pos.TOP_CENTER);
        cartParts.setStyle("-fx-background-color: #f9f0ac;");
        cartParts.setSpacing(10);
        cartParts.setPadding(new Insets(20));

        //Create the scene and display the stage
        Scene scene = new Scene(cartParts, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Create the cart parts selection controls
    private HBox cartPartsSection()
    {
        cartBodies = new ComboBox<>();
        cartBodies.getItems().addAll("[$60] Banana Blaster","[$45] Jelly Lab Runner","[$50] Gru Escape Cart");
        engineAssemblies = new ComboBox<>();
        engineAssemblies.getItems().addAll("[$35] 7.75-inch axle", "[$40] 8-inch axle", "[$45] 8.5-inch axle");
        wheelSets = new ComboBox<>();
        wheelSets.getItems().addAll("[$20] 51 mm", "[$22] 55 mm", "[$24] 58 mm", "[$28] 61 mm");

        Label cartLabel = new Label("Cart Bodies");
        Label engineLabel = new Label("Engine Assemblies");
        Label wheelLabel = new Label("Wheel Sets");

        VBox bodyBox = new VBox(cartLabel, cartBodies);
        VBox engineBox = new VBox(engineLabel, engineAssemblies);
        VBox wheelBox = new VBox(wheelLabel, wheelSets);

        cartLabel.setStyle("-fx-font-size: 17px; -fx-text-fill: #2F5D8C");
        engineLabel.setStyle("-fx-font-size: 17px; -fx-text-fill: #2F5D8C");
        wheelLabel.setStyle("-fx-font-size: 17px; -fx-text-fill: #2F5D8C");

        bodyBox.setAlignment(Pos.CENTER);
        engineBox.setAlignment(Pos.CENTER);
        wheelBox.setAlignment(Pos.CENTER);
 
        bodyBox.setSpacing(5);
        engineBox.setSpacing(5);
        wheelBox.setSpacing(5);

        HBox selections = new HBox(bodyBox, engineBox, wheelBox);
        selections.setAlignment(Pos.CENTER);
        selections.setSpacing(25);

        return selections;
    }

        //Create option supplies controls
        private VBox suppliesSection()
        {
            Label suppliesLabel = new Label("Optional Supplies:");
            suppliesLabel.setAlignment(Pos.CENTER);
            suppliesLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2F5D8C");


            gripTape = new CheckBox("[$10] Banana grip tape");
            goggles = new CheckBox("[$30] Goggles");
            riserPads = new CheckBox("[$2] Riser pads");
            nutsBolts = new CheckBox("[$3] Nuts and bolts kit");

            String supplyStyle = "-fx-font-size: 16px; -fx-text-fill: #2F5D8C";
            gripTape.setStyle(supplyStyle);
            goggles.setStyle(supplyStyle);
            riserPads.setStyle(supplyStyle);
            nutsBolts.setStyle(supplyStyle);

            HBox supplies = new HBox(gripTape, goggles, riserPads, nutsBolts);
            supplies.setAlignment(Pos.CENTER);
            supplies.setSpacing(20);

            VBox suppliesSection = new VBox(suppliesLabel, supplies);
            suppliesSection.setAlignment(Pos.CENTER);
            suppliesSection.setSpacing(10);

            return suppliesSection;
        }

    private VBox calculationSection()
    {
        calculateButton = new Button("Calculate cost:");

        subtotalLabel = new Label("Subtotal: ");
        salesTaxLabel = new Label("Sales Tax: ");
        totalLabel = new Label("Total: ");
        messageLabel = new Label();
        
        calculateButton.setOnAction(event -> 
        {
            if(cartBodies.getValue()==null || engineAssemblies.getValue()==null || wheelSets.getValue()==null)
            {
                messageLabel.setText("Please select all cart parts.");
                return;
            }
            messageLabel.setText("Selections Complete");

            double subtotal = calculateSubtotal();
            double salesTax = subtotal * 0.07;
            double total = subtotal + salesTax;

            subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
            salesTaxLabel.setText(String.format("Sales Tax: $%.2f", salesTax));
            totalLabel.setText(String.format("Total: $%.2f", total));
        });

        VBox calculation = new VBox(calculateButton, subtotalLabel, salesTaxLabel, totalLabel);

        calculation.setAlignment(Pos.BOTTOM_LEFT);
        calculation.setSpacing(10);

        return calculation;
    }

    private double calculateSubtotal()
    {
        double subtotal = 0;

        String selectedBody = cartBodies.getValue();

        if(selectedBody.equals("[$60] Banana Blaster"))
        {
            subtotal +=60;
        }
        else if(selectedBody.equals("[$45] Jelly Lab Runner"))
        {
            subtotal +=45;    
        }
        else if(selectedBody.equals("[$50] Gru Escape Cart"))
        {
            subtotal +=50;        
        }
        return subtotal;
    }
      
        //"[$35] 7.75-inch axle"
        //"[$40] 8-inch axle"
        //"[$45] 8.5-inch axle"
        // "[$20] 51 mm"
        // "[$22] 55 mm"
        // "[$24] 58 mm"
        // "[$28] 61 mm")

}
 


