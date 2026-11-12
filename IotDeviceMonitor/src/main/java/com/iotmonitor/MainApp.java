
package com.iotmonitor;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.control.Label;
import javafx.scene.layout.*;
//import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class MainApp extends Application {

    private TableView<Device> tableView;
    private ObservableList<Device> devices;

    @Override
    public void start(Stage stage) {

        System.out.println("Starting IoT Device Monitor");

        SensorDevice sd = new SensorDevice("PICO-001", "Temperature Sensor");
        System.out.println(sd);


        /****
        Label title = new Label("IoT Device Monitor");

        Label status = new Label("Device Status: Disconnected");

        Button connectButton = new Button("Connect");

        connectButton.setOnAction(event -> {
            status.setText("Device Status: Connected");
        });

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
            title,
            status,
            connectButton
        );
        ****/

        /******/
         BorderPane root = new BorderPane();

        // TOP: Toolbar
        Label title = new Label("IoT Device Monitor");
        Button refreshButton = new Button("Refresh");

        HBox topBar = new HBox(20, title, refreshButton);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-background-color: lightblue;");

        root.setTop(topBar);

        // LEFT: Navigation
        Button devicesButton = new Button("Devices");
        Button settingsButton = new Button("Settings");

        VBox leftMenu = new VBox(10, devicesButton,
                               settingsButton);
        leftMenu.setPadding(new Insets(10));
        leftMenu.setPrefWidth(130);

        root.setLeft(leftMenu);
        
        // CENTER: Main content
        Label deviceInfo = new Label("No device selected");

        /****
        VBox centerPane = new VBox(deviceInfo);
        centerPane.setAlignment(Pos.CENTER);

        root.setCenter(centerPane);
        ****/

        // CENTER: TableView
        tableView = new TableView<>();

        TableColumn<Device, String> nameCol =
                new TableColumn<>("Device Name");

        nameCol.setCellValueFactory(
                data -> data.getValue().nameProperty());
        
        TableColumn<Device, String> ipCol =
                new TableColumn<>("IP Address");

        ipCol.setCellValueFactory(
                data -> data.getValue().ipAddressProperty());

        TableColumn<Device, String> statusCol =
                new TableColumn<>("Status");

        statusCol.setCellValueFactory(
                data -> data.getValue().statusProperty());

        tableView.getColumns().addAll(
                nameCol, ipCol, statusCol);

        //tableView.setColumnResizePolicy(
        //        TableView.CONSTRAINED_RESIZE_POLICY);

        // Create device data
        devices = FXCollections.observableArrayList();

        devices.add(new Device(
                "Sensor 1", "192.168.1.10", "Online"));

        devices.add(new Device(
                "Sensor 2", "192.168.1.11", "Offline"));

        devices.add(new Device(
                "Sensor 3", "192.168.1.12", "Online"));

        tableView.setItems(devices);


        root.setCenter(tableView);


        // RIGHT: Device details
        /***
        Label details = new Label("Device Details");

        VBox rightPane = new VBox(details);
        rightPane.setPadding(new Insets(10));
        rightPane.setPrefWidth(150);

        root.setRight(rightPane);
        ***/

        // BOTTOM: Status bar
        Label status = new Label("Status: Ready");

        HBox bottomBar = new HBox(status);
        bottomBar.setPadding(new Insets(10));
        bottomBar.setStyle("-fx-background-color: lightgray;");

        root.setBottom(bottomBar);

        // Button event handlers
        refreshButton.setOnAction(e -> {
            status.setText("Status: Refreshing devices...");
        });

        devicesButton.setOnAction(e -> {
            deviceInfo.setText("Device list selected");
            status.setText("Status: Devices");
        });

        settingsButton.setOnAction(e -> {
            deviceInfo.setText("Settings selected");
            status.setText("Status: Settings");

            //devices.get(0).setStatusProperty("HELLO");
            Device selected = devices.get(0);
            
            if (selected != null) {
                String newStatus =
                    selected.getStatus().equals("Online")
                        ? "Offline" : "Online";

                selected.setStatusProperty(newStatus);
            }

            tableView.refresh();
        });
         /******/

        //Scene scene = new Scene(root, 450, 300);
        Scene scene = new Scene(root, 700, 400);

        stage.setTitle("IoT Device Monitor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
