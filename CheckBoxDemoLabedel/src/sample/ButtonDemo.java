package sample;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonDemo extends Application {

    Text text = new Text(50, 50, "JavaFX Programming");

    public BorderPane getPane() {

        HBox paneForButtons = new HBox(20);
        // kreiranje dugmeta za levo. Potrebno je u projekat dodati sliku sa nazivom left.jpg
        ImageView img_left = new ImageView("left.jpg");
        img_left.setFitHeight(50);
        img_left.setFitWidth(50);
        Button btLeft = new Button("Left", img_left);

        //kreiranje dugmeta za desno. Potrebno je u projekat dodati sliku sa nazivom right.jpg
        ImageView img_right = new ImageView("right.jpg");
        img_right.setFitHeight(50);
        img_right.setFitWidth(50);
        Button btRight = new Button("Right", img_right);

        //dodavanje panela sa dugmucima na border layout
        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        //dodavanje teksta na centar BorderPane-a
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        //dodavanje akcija na dugmice
        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        return pane;
    }

    @Override //redefinisanje metoda start() klase Application
    public void start(Stage primaryStage) {
        //kreiranje scene i njeno postavljanje na pozornicu
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("ButtonDemo"); //unos naslova pozornice
        primaryStage.setScene(scene); //postavljanje scene na scenu
        primaryStage.show(); //prikaz pozornice
    }

}
