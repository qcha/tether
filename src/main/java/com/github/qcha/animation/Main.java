package com.github.qcha.animation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String TITLE_TXT = "Animation";
    private static final int SCENE_WIDTH = 300;
    private static final int SCENE_HEIGHT = 280;


    @Override
    public void start(Stage stage) throws Exception {
        ChooserController.setStage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Chooser.fxml"));
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(TITLE_TXT);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}