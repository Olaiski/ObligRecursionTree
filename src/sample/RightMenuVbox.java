package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RightMenuVbox extends VBox {

    private Slider angleSlider = new Slider(30, 150, 90);
    private TextField lengthTf = new TextField();
    private TextField orderTf = new TextField();
    private Button btnOk = new Button("Ok");

    public RightMenuVbox() {

        angleSlider.setMajorTickUnit(10);
        angleSlider.setShowTickMarks(true);
        angleSlider.setShowTickLabels(true);
        angleSlider.setSnapToTicks(true);

        lengthTf.setText("0");
        orderTf.setText("0");

        this.setSpacing(5);
        this.setPadding(new Insets(20));
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));


        getChildren().addAll(new Label(""),
                new Label("Grad:"), angleSlider,
                new Label("Lengde (stamme): "), lengthTf,
                new Label("Nivå: "), orderTf,
                btnOk

        );
    }

    public Slider getAngleSlider() {
        return angleSlider;
    }

    public TextField getLengthTf() {
        return lengthTf;
    }

    public TextField getOrderTf() {
        return orderTf;
    }

    public Button getBtnOk() {
        return btnOk;
    }
}
