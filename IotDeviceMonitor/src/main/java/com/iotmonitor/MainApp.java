
package com.iotmonitor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

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

        Scene scene = new Scene(root, 450, 300);

        stage.setTitle("IoT Device Monitor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
