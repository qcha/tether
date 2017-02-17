package com.github.qcha.animation;

/*
 * управление котроллеров на маске выбора файла для анимирования
 */

import java.io.File;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class ChooserController {
    private static Stage stage;
    private File fileToAnimate;

    @FXML
    private void oneBodyOrbitFileChooser(){
        if (isFileChoose()) {
            OneBodyOrbitAnimation.startAnimation(stage, Paths.get(fileToAnimate.getPath()));
        }
    }

    @FXML
    private void twoBodiesOrbitFileChooser() {
        if (isFileChoose()) {
            TwoBodiesOrbitAnimation.startAnimation(stage, Paths.get(fileToAnimate.getPath()));
        }
    }

    @FXML
    private void oneBodyRotationFileChooser() {
        if (isFileChoose()) {
            OneBodyRotationAnimation.startAnimation(stage, Paths.get(fileToAnimate.getPath()));
        }
    }

    @FXML
    private void twoBodiesRotationFileChooser() {
        if (isFileChoose()) {
            TwoBodiesRotationAnimation.startAnimation(stage, Paths.get(fileToAnimate.getPath()));
        }
    }

    private boolean isFileChoose() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.setTitle("Select text file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        if (selectedFile != null) {
            fileToAnimate = selectedFile;
            return true;
        } else {
            return false;
        }
    }

    public static void setStage(Stage stage) {
        ChooserController.stage = stage;
    }


}
