package com.masolar;

/**
 * Created by Mason on 6/11/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    // Allows the use of the stage outside this class
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    /*
    Exists to set up the stage for this program.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Photo Editor");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    /*
    Sets up all of the menus, menu items, and menu item actions.
     */
    /*private MenuBar setupMenus(Stage primaryStage) {
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

                    tabPane.getTabs().add(createImageTab(displayImage));
                }
        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> System.exit(0));

        menuFile.getItems().addAll(open, new SeparatorMenuItem(), exit);

        menuBar.getMenus().addAll(menuFile);

        return menuBar;
    }

    public Tab createImageTab(Image image) {
        Tab tab = new Tab();

        // Will hold the picture in the center area
        StackPane pane = new StackPane();

        // Used for scrolling the image
        ScrollPane scroll = new ScrollPane();
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        ZoomableImageView zoomableImageView = new ZoomableImageView(image);

        scroll.setContent(zoomableImageView);
        pane.getChildren().add(scroll);


        ImageView imagePreview = new ImageView();
        imagePreview.setPreserveRatio(true);
        imagePreview.setImage(image);
        imagePreview.setFitHeight(80);
        imagePreview.setFitWidth(80);

        tab.setGraphic(imagePreview);
        tab.setContent(pane);

        return tab;
    }*/
}
