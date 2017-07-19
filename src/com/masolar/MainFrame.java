package com.masolar;

/**
 * Created by Mason on 6/11/2017.
 */

import com.masolar.CustomNodes.ImageTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
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
                if (selectedFile != null)
                    tabPane.getTabs().add(new ImageTab(new Image("file:" + selectedFile.getAbsolutePath())));
        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> System.exit(0));

        menuFile.getItems().addAll(open, new SeparatorMenuItem(), exit);

        menuBar.getMenus().addAll(menuFile);

        return menuBar;
    }
}
