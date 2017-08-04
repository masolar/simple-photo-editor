package com.masolar.CustomNodes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;

/**
 * Created by Mason on 8/3/2017.
 */
public class ZoomableImageView extends ImageView {

    final DoubleProperty zoomProperty = new SimpleDoubleProperty(1);
    public ZoomableImageView(Image image) {
        super();

        zoomProperty.addListener(observable -> {
            setFitWidth(zoomProperty.get() * image.getWidth());
            setFitHeight(zoomProperty.get() * image.getHeight());
        });

        addEventFilter(ScrollEvent.SCROLL, event -> {
            if (event.isControlDown()) {
                if (event.getDeltaY() < 0) {
                    zoomProperty.set(zoomProperty.get() - .07);
                } else if (event.getDeltaY() > 0) {
                    zoomProperty.set(zoomProperty.get() + .07);
                }
            }
        });

        setPreserveRatio(true);
        setImage(image);
    }
}
