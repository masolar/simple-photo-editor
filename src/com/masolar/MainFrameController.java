package com.masolar;

import com.masolar.CustomNodes.ImageTab;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class MainFrameController {

    @FXML
    private TabPane tabPane;

    @FXML
    private void openImage() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open Image");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.tif"));
        List<File> selectedFiles = fc.showOpenMultipleDialog(App.stage);
        for (File selectedFile : selectedFiles)
            if (selectedFile != null) {
                Image image = new Image("file:" + selectedFile.getAbsolutePath());

                tabPane.getTabs().add(new ImageTab(image));
            }
    }

    @FXML
    private void doExit() {
        System.exit(0);
    }
}
