package sample;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class RecursionTreeMain extends Application {

//    private  int length = 100;

    @Override
    public void start(Stage primaryStage) throws Exception{

        RecursiveTreePane pane = new RecursiveTreePane();
//        TextField tfOrder = new TextField();
//        tfOrder.setOnAction(e -> pane.setOrder(Integer.parseInt(tfOrder.getText())));

//        tfOrder.setPrefColumnCount(4);
//        tfOrder.setAlignment(Pos.CENTER);

//        HBox hBox = new HBox(10);
//        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
//        hBox.setAlignment(Pos.CENTER);

        RightMenuVbox rBox = new RightMenuVbox();

        int order = Integer.parseInt(rBox.getOrderTf().getText());
        double degree = Double.parseDouble(String.valueOf(rBox.getAngleSlider().getValue()));
        int length = Integer.parseInt(rBox.getLengthTf().getText());

        rBox.getBtnOk().setOnAction(e ->
                pane.setTree(order, degree, length)
        );

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
//        borderPane.setBottom(hBox);
        borderPane.setRight(rBox);

        Scene scene = new Scene(borderPane, 700, 710);
        primaryStage.setTitle("RecTree");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class RecursiveTreePane extends Pane {
        private int order = 0;
        private double degree = 0d;
        private int len = 0;


        public void setTree(int order) {
            this.order = order;
            paint();
        }

        public void setTree(int order, double degree, int len) {
            this.order = order;
            this.degree = degree;
            this.len = len;

            paint();
        }

        public RecursiveTreePane() {
        }


        protected void paint() {
            Point2D p1 = new Point2D(getWidth() / 2, getHeight() - 10);
            Point2D p2 = new Point2D(getWidth() / 2, getHeight() - 10 - len);


            this.getChildren().clear();

            displayTree(order, len, p1, p2);
        }


        private void displayTree(int order, int len, Point2D p1, Point2D p2) {

            if (order == 0) {
                Line line = new Line();
                line.setStartX(p1.getX());
                line.setStartY(p1.getY());
                line.setEndX(p2.getX());
                line.setEndY(p2.getY());

                line.setStroke(Color.BLACK);
                line.setFill(Color.WHITE);

                this.getChildren().addAll(line);
            }
            else {
//                Point2D p12 = p1.midpoint(p2);
//                Point2D p23 = p2.midpoint(p3);
//                Point2D p31 = p3.midpoint(p1);
//
//
//                displayTriangles(order - 1 , p1, p12, p31);
//                displayTriangles(order - 1 , p12, p2, p23);
//                displayTriangles(order - 1 , p31, p23, p3);

            }
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}
