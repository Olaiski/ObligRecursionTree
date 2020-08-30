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
                pane.setTree(rBox.getOrder(), rBox.getLength(), rBox.getAngle())
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

        private double angle = 0;
        private int order = 0;
        private double len = 100;


        public void setTree(int order) {
            this.order = order;
            paint();
        }

        public void setTree(int order, double len){
            this.order = order;
            this.len = len;
            paint();
        }

        public void setTree(int order, double len, double degree) {
            this.order = order;
            this.len = len;
            this.angle = degree;
            paint();
        }

        public RecursiveTreePane() {
            this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        }


        protected void paint() {
//            Point2D p1 = new Point2D(getWidth() / 2, getHeight() - 10);
            Point2D p = new Point2D(getWidth() / 2, getHeight() - 10 - len);

            this.getChildren().clear();

//            displayTree(order, len, p1, p2);
            System.out.println(angle);
            displayTree(order, p.getX(), p.getY(), angle);

        }

        private void displayTree(int order,  double x1, double y1, double angle) {

            Point2D p1 = new Point2D(getWidth() / 2, getHeight() - 10);
            Point2D p2 = new Point2D(getWidth() / 2, getHeight() - 10 - len);


            if (order == 0) {
                Line line = new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                line.setStroke(Color.WHITE);
                getChildren().add(line);

            } else  {

                double x2 = x1 + (Math.cos(Math.toRadians(angle)) * order * 10.0);
                double y2 = y1 + (Math.sin(Math.toRadians(angle)) * order * 10.0);

                Line line = new Line(x1, y1, x2, y2);
                line.setStroke(Color.WHITE);
                getChildren().add(line);
                displayTree(order - 1, x2, y2, angle - 30);
                displayTree(order - 1, x2, y2, angle + 30);
            }



        }



    }


    public static void main(String[] args) {
        launch(args);
    }
}
