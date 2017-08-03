package com.masolar;

/**
 * Created by Mason on 6/11/2017.
 */

import com.masolar.CustomNodes.ZoomableImageView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class MainFrame extends Application {

    static TabPane tabPane;// = new TabPane();

    public static void main(String[] args) {
        launch(args);
    }

    /*
    Represents the starting point of the program. Sets up the stage and the menus.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Photo Editor");

        BorderPane root = new BorderPane();

        MenuBar menuBar = setupMenus(primaryStage);
        root.setTop(menuBar);

        Scene scene = new Scene(root);

        tabPane = new TabPane();



        root.setCenter(tabPane);
        root.setLeft(new Rectangle(100, 500));

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    /*
    Sets up all of the menus, menu items, and menu item actions.
     */
    private MenuBar setupMenus(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();

        // Start of the file menu
        Menu menuFile = new Menu("File");
        MenuItem open = new MenuItem("Open");
        open.setOnAction(event -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("Open Image");
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.tif"));
            List<File> selectedFiles = fc.showOpenMultipleDialog(primaryStage);
            for (File selectedFile : selectedFiles)
                if (selectedFile != null) {
                    Image displayImage = new Image("file:" + selectedFile.getAbsolutePath());

                    tabPane.getTabs().add(generateImageTab(displayImage));
                }
        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> System.exit(0));

        menuFile.getItems().addAll(open, new SeparatorMenuItem(), exit);

        menuBar.getMenus().addAll(menuFile);

        return menuBar;
    }

    public Tab generateImageTab(Image image) {
        Tab tab = new Tab();

        // Will hold the picture in the center area
        BorderPane pane = new BorderPane();

        // Used for scrolling the image
        ScrollPane scroll = new ScrollPane();
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        ZoomableImageView zoomableImageView = new ZoomableImageView(image);

        scroll.setContent(zoomableImageView);
        pane.setCenter(scroll);


        ImageView imagePreview = new ImageView();
        imagePreview.setPreserveRatio(true);
        imagePreview.setImage(image);
        imagePreview.setFitHeight(80);
        imagePreview.setFitWidth(80);

        tab.setGraphic(imagePreview);
        tab.setContent(pane);

        return tab;
    }
}
