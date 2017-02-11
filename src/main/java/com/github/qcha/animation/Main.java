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

    private static final String TITLE_TXT = "Animation";
    private static final int VBOX_SPACING = 30;
    private static final int BUTTONVB_SPACING = 10;
    private static final int FONT_SIZE = 20;
    private static final int INSETS_TOP = 25;
    private static final int INSETS_RIGHT = 25;
    private static final int INSETS_BOTTOM = 25;
    private static final int INSETS_LEFT = 25;
    private static final int SCENE_WIDTH = 300;
    private static final int SCENE_HEIGHT = 280;

    Stage primaryStage;
    private Label label;
    private HBox labelHb;
    private Button btnOneBodyOrbit;
    private Button btnTwoBodiesOrbit;
    private Button btnOneBodyRotation;
    private Button btnTwoBodiesRotation;
    private VBox buttonVb;
    private VBox vbox;
    private Text actionStatus;

    private File fileToAnimate;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        primaryStage = stage;
        primaryStage.setTitle(TITLE_TXT);

        // Window label
        label = new Label("Choose file to animate");
        labelHb = new HBox();
        labelHb.setAlignment(Pos.CENTER);
        labelHb.getChildren().add(label);

        // Buttons
        btnOneBodyOrbit = new Button("One Body Orbit Animation");
        btnOneBodyOrbit.setOnAction(new ButtonOneBodyOrbitListener());
        btnTwoBodiesOrbit = new Button("Two Bodies Orbit Animation");
        btnTwoBodiesOrbit.setOnAction(new ButtonTwoBodiesOrbitListener());
        btnOneBodyRotation = new Button("One Body Rotation Animation");
        btnOneBodyRotation.setOnAction(new ButtonOneBodyRotationListener());
        btnTwoBodiesRotation = new Button("Two Bodies Rotation Animation");
        btnTwoBodiesRotation.setOnAction(new ButtonTwoBodiesRotationListener());
        buttonVb = new VBox(BUTTONVB_SPACING);
        buttonVb.setAlignment(Pos.CENTER);
        buttonVb.getChildren().addAll(btnOneBodyOrbit, btnTwoBodiesOrbit, btnOneBodyRotation, btnTwoBodiesRotation);

        // Status message text
        actionStatus = new Text();
        actionStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, FONT_SIZE));
        actionStatus.setFill(Color.FIREBRICK);

        // Vbox
        vbox = new VBox(VBOX_SPACING);
        vbox.setPadding(new Insets(INSETS_TOP, INSETS_RIGHT, INSETS_BOTTOM, INSETS_LEFT));
        vbox.getChildren().addAll(labelHb, buttonVb, actionStatus);

        // Scene
        Scene scene = new Scene(vbox, SCENE_WIDTH, SCENE_HEIGHT); // w x h
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private class ButtonOneBodyOrbitListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            oneBodyOrbitFileChooser();
        }
    }

    private class ButtonTwoBodiesOrbitListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            twoBodiesOrbitFileChooser();
        }
    }

    private class ButtonOneBodyRotationListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            oneBodyRotationFileChooser();
        }
    }

    private class ButtonTwoBodiesRotationListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            twoBodiesRotationFileChooser();
        }
    }

    private void oneBodyOrbitFileChooser() {

        if (isFileChoose()) {
            OneBodyOrbitAnimation.startAnimation(primaryStage, Paths.get(fileToAnimate.getPath()));
        }
    }

    private void twoBodiesOrbitFileChooser() {
        if (isFileChoose()) {
            TwoBodiesOrbitAnimation.startAnimation(primaryStage, Paths.get(fileToAnimate.getPath()));
        }
    }

    private void oneBodyRotationFileChooser() {
        if (isFileChoose()) {
            OneBodyRotationAnimation.startAnimation(primaryStage, Paths.get(fileToAnimate.getPath()));
        }
    }

    private void twoBodiesRotationFileChooser() {
        if (isFileChoose()) {
            TwoBodiesRotationAnimation.startAnimation(primaryStage, Paths.get(fileToAnimate.getPath()));
        }
    }
    private boolean isFileChoose(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.setTitle("Select text file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        if(selectedFile != null){
            fileToAnimate = selectedFile;
            return true;
        }else {
            return false;
        }
    }
}