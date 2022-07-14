package com.example;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontPosture;

public class FirstScene extends Application {
    ObservableList<FileData> data;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Inventory Management");

        //Label for education
      Label label = new Label("Stock info:");
      Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
      label.setFont(font);
      //Creating a table view
      TableView<FileData> table = new TableView<FileData>();
       data = FXCollections.observableArrayList();
      data.add(new FileData("file5", "random", "45 MB", "iroje"));
      StockInsert obj= new StockInsert();
      obj.stockListView(data);
      //Creating columns
      TableColumn fileNameCol = new TableColumn("Product Name");
      fileNameCol.setCellValueFactory(new PropertyValueFactory<>("fileName"));
      fileNameCol.setResizable(false);
      fileNameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

      TableColumn pathCol = new TableColumn("Price");
      pathCol.setCellValueFactory(new PropertyValueFactory("path"));
      pathCol.setResizable(false);
      pathCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

      TableColumn sizeCol = new TableColumn("Stock Availble");
      sizeCol.setResizable(false);
      sizeCol.setCellValueFactory(new PropertyValueFactory("size"));
      sizeCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

      TableColumn dateCol = new TableColumn("Retailer");
      dateCol.setResizable(false);
      dateCol.setCellValueFactory(new PropertyValueFactory("dateModified"));
      dateCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

      //Adding data to the table
      ObservableList<String> list = FXCollections.observableArrayList();
      table.setItems(data);
      table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      table.getColumns().addAll(fileNameCol, pathCol, sizeCol, dateCol);
      //Setting the size of the table
      table.setMaxSize(700, 400);
       


        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(gridPane,label,table);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(vbox, 800, 500);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Stock Update");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Product : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField productname = new TextField();
        productname.setPrefHeight(40);
        gridPane.add(productname, 1,1);


        // Add Email Label
        Label pricelabel = new Label("Price : ");
        gridPane.add(pricelabel, 0, 2);

        // Add Email Text Field
        TextField pricefield = new TextField();
        pricefield.setPrefHeight(40);
        gridPane.add(pricefield, 1, 2);

        // Add stockavailable Label
        Label stockavailable = new Label("Stock Present:");
        gridPane.add(stockavailable, 0, 3);

        // Add stockavailable Field
        TextField stockavailabletext = new TextField();
        stockavailabletext.setPrefHeight(40);
        gridPane.add(stockavailabletext, 1, 3);


        // Add retailer Label
        Label retailer = new Label("Retailer:");
        gridPane.add(retailer, 0, 4);

        // Add Password Field
        TextField retailertext = new TextField();
        retailertext.setPrefHeight(40);
        gridPane.add(retailertext, 1, 4);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 5, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(productname.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter Product Name");
                    return;
                }
                if(pricefield.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter Price of the Product");
                    return;
                }
                if(retailertext.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter Retailer Name");
                    return;
                }   
                if(stockavailabletext.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter available stock");
                    return;
                }

                StockInsert obj = new StockInsert();
                String ans=obj.insertStockUpdate(productname.getText(), pricefield.getText(), retailertext.getText(), stockavailabletext.getText());
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Stock Update Successful!", "Product:" + productname.getText()+"\n"+ans);
                if(ans=="Success"){
                    productname.clear();
                    pricefield.clear();
                    retailertext.clear();
                    stockavailabletext.clear();
                }
                obj.stockListView(data);
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}