package com.github.qcha.animation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;

public class Main extends Application {
    private static final String TITLE = "Animation";

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(TITLE);

        // Window label
        HBox labelHb = new HBox();
        labelHb.setAlignment(Pos.CENTER);
        labelHb.getChildren().add(new Label("Choose file to animate"));

        // Buttons
        Button btnOneBodyOrbit = new Button("One Body Orbit Animation");
        btnOneBodyOrbit.setOnAction(e -> oneBodyOrbitFileChooser(primaryStage));

        Button btnTwoBodiesOrbit = new Button("Two Bodies Orbit Animation");
        btnTwoBodiesOrbit.setOnAction(e -> twoBodiesOrbitFileChooser(primaryStage));

        Button btnOneBodyRotation = new Button("One Body Rotation Animation");
        btnOneBodyRotation.setOnAction(e -> oneBodyRotationFileChooser(primaryStage));

        Button btnTwoBodiesRotation = new Button("Two Bodies Rotation Animation");
        btnTwoBodiesRotation.setOnAction(e -> twoBodiesRotationFileChooser(primaryStage));

        VBox buttonVb = new VBox(10);
        buttonVb.setAlignment(Pos.CENTER);
        buttonVb.getChildren().addAll(btnOneBodyOrbit, btnTwoBodiesOrbit, btnOneBodyRotation, btnTwoBodiesRotation);

        // Status message text
        Text actionStatus = new Text();
        actionStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        actionStatus.setFill(Color.FIREBRICK);

        // Vbox
        VBox vbox = new VBox(30);
        vbox.setPadding(new Insets(25, 25, 25, 25));
        vbox.getChildren().addAll(labelHb, buttonVb, actionStatus);

        // Scene
        Scene scene = new Scene(vbox, 300, 280); // w x h
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void oneBodyOrbitFileChooser(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.setTitle("Select text file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        if (selectedFile != null) {
            OneBodyOrbitAnimation.startAnimation(primaryStage, Paths.get(selectedFile.getPath()));
        }
    }

    private void twoBodiesOrbitFileChooser(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.setTitle("Select text file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        if (selectedFile != null) {
            TwoBodiesOrbitAnimation.startAnimation(primaryStage, Paths.get(selectedFile.getPath()));
        }
    }

    private void oneBodyRotationFileChooser(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.setTitle("Select text file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        if (selectedFile != null) {
            OneBodyRotationAnimation.startAnimation(primaryStage, Paths.get(selectedFile.getPath()));
        }
    }

    private void twoBodiesRotationFileChooser(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.setTitle("Select text file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        if (selectedFile != null) {
            TwoBodiesRotationAnimation.startAnimation(primaryStage, Paths.get(selectedFile.getPath()));
        }
    }
}