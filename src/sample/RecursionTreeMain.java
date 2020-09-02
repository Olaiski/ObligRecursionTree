package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class RecursionTreeMain extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        RecursiveTreePane pane = new RecursiveTreePane();
        RightMenuVbox rBox = new RightMenuVbox();


        rBox.getBtnOk().setOnAction(e ->
                pane.setTree(rBox.getOrder(), rBox.getLength())
        );



        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setRight(rBox);


        Scene scene = new Scene(borderPane, 700, 600);
        primaryStage.setTitle("RecTree");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }

    static class RecursiveTreePane extends Pane {

        private int order;
        private double len;


        public void setTree(int order) {
            this.order = order;
            paint();
        }

        public void setTree(int order, double len){
            this.order = order;
            this.len = len;
            paint();
        }


        public RecursiveTreePane() {
            this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        }


        protected void paint() {
            Point2D p = new Point2D(getWidth() / 2, getHeight());

            this.getChildren().clear();
            displayTree(order, p, -90, getHeight() / 4);
        }


        /**
         *
         * @param n number of recursive "iterations"
         * @param origin the x and y on where to start drawing
         * @param rotation degrees
         * @param length how long the line should be (pixels)
         */
        private void displayTree(int n, Point2D origin, double rotation, double length) {

            Point2D endPoint = endPoint(origin, rotation, length);


            if (n == 0) {
                Line line = new Line(origin.getX(), origin.getY(), endPoint.getX(), endPoint.getY());
                line.setStroke(Color.WHITE);
                getChildren().add(line);
            }
            else if (length > 2) {

                Line line = new Line(origin.getX(), origin.getY(), endPoint.getX(), endPoint.getY());
                line.setStroke(Color.WHITE);
                getChildren().add(line);

                displayTree(n - 1, endPoint, rotation - 30, length * 0.67f);
                displayTree(n - 1, endPoint, rotation + 30, length * 0.67f);

            }
            
        }

        private Point2D endPoint(Point2D origin, double rotation, double len) {
            double x = origin.getX();
            double y = origin.getY();

            double radians = Math.PI / 180.0 * rotation;  // Math.toRadians()

            x += (len * Math.cos(radians));
            y += (len * Math.sin(radians));

            return new Point2D(x, y);
        }
    }




    public static void main(String[] args) {
        launch(args);
    }
}
