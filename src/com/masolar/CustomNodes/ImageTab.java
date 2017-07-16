package com.masolar.CustomNodes;

import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * Created by Mason on 7/16/2017.
 */
public class ImageTab extends Tab {

    /*
    Represents a tab with an image inside of it.
     */
    public ImageTab(Image image) {
        super();

        // Will hold the picture in the center area
        BorderPane pane = new BorderPane();

        // Will display the working image
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setImage(image);

        pane.setCenter(imageView);

        // Displays the iamge preview in a tab
        // TODO: Fix tab height to see the image.
        ImageView imagePreview = new ImageView();
        imagePreview.setPreserveRatio(true);
        imagePreview.setImage(image);
        imagePreview.setFitHeight(80);
        imagePreview.setFitWidth(80);

        setGraphic(imagePreview);
        setContent(pane);
    }
}
