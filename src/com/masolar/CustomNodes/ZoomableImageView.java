package com.masolar.CustomNodes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Mason on 8/3/2017.
 */
public class ZoomableImageView extends ImageView {

    public ZoomableImageView(Image image) {
        super();

        setPreserveRatio(true);
        setImage(image);
    }
}
