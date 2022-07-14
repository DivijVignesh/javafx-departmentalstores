package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class SettingData extends Application {
   public void start(Stage stage) {
      //Label for education
      Label label = new Label("Stock info:");
      Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
      label.setFont(font);
      //Creating a table view
      TableView<FileData> table = new TableView<FileData>();
       ObservableList<FileData> data = FXCollections.observableArrayList();
      data.add(new FileData("file5", "random", "45 MB", "iroje"));
      StockInsert obj= new StockInsert();
      obj.stockListView(data);
      //Creating columns
      TableColumn fileNameCol = new TableColumn("Product Name");
      fileNameCol.setCellValueFactory(new PropertyValueFactory<>("fileName"));
      TableColumn pathCol = new TableColumn("Price");
      pathCol.setCellValueFactory(new PropertyValueFactory("path"));
      TableColumn sizeCol = new TableColumn("Stock Availble");
      sizeCol.setCellValueFactory(new PropertyValueFactory("size"));
      TableColumn dateCol = new TableColumn("Retailer");
      dateCol.setCellValueFactory(new PropertyValueFactory("dateModified"));
      dateCol.setPrefWidth(100);
      //Adding data to the table
      ObservableList<String> list = FXCollections.observableArrayList();
      table.setItems(data);
      table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      table.getColumns().addAll(fileNameCol, pathCol, sizeCol, dateCol);
      //Setting the size of the table
      // table.setMaxSize(350, 200);
      VBox vbox = new VBox();
      vbox.setSpacing(5);
      vbox.setPadding(new Insets(10, 50, 50, 60));
      vbox.getChildren().addAll(label, table);
      //Setting the scene
      Scene scene = new Scene(vbox, 595, 230);
      stage.setTitle("Table View Exmple");
      stage.setScene(scene);
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}
