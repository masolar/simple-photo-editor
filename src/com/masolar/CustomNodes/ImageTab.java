package com.masolar.CustomNodes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class ImageTab extends Tab {

    @FXML
    ImageView imageView;

    public ImageTab(Image image) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "ImageTab.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        imageView.setImage(image);
    }
}
