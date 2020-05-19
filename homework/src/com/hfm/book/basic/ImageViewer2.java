//package com.hfm.book.basic;
//
//import javax.swing.text.html.ImageView;
//import java.awt.*;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
///**
// * @author hfm
// * @version 1.01 2020-03-26 15:39
// * @date 2020/3/26
// */
//public class ImageViewer2 {
//    private static final int MIN_SIZE = 400;
//
//    public void start(Stage stage) throws IOException {
//        BorderPane pane = new BorderPane();
//        MenuBar bar = new MenuBar();
//        pane.setTop(bar);
//        Menu fileMenu = new Menu("File");
//        bar.getMenus().add(fileMenu);
//        MenuItem openItem = new MenuItem("Open");
//        openItem.setOnAction(event -> load(stage, pane));
//        MenuItem exitItem = new MenuItem("Exit");
//        exitItem.setOnAction(event -> System.exit(0));
//        fileMenu.getItems().addAll(openItem, exitItem);
//        stage.setScene(new Scene(pane, MIN_SIZE, MIN_SIZE));
//        stage.setTitle("ImageViewer");
//        stage.show();
//    }
//
//    /**
//     * Loads an image.
//     *
//     * @param stage the stage above which to place the file chooser
//     * @param pane  the pane into which to place the image view
//     */
//    public void load(Stage stage, BorderPane pane) {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
//                new FileChooser.ExtensionFilter("All Files", "*.*"));
//        File file = fileChooser.showOpenDialog(stage);
//        if (file != null) {
//            try {
//                Path path = file.toPath();
//                Image image = new Image(Files.newInputStream(path));
//                pane.setCenter(new ImageView(image));
//            } catch (IOException e) {
//                Alert alert = new Alert(Alert.AlertType.ERROR,
//                        "Cannot open file.");
//                alert.showAndWait();
//            }
//        }
//    }
//}
