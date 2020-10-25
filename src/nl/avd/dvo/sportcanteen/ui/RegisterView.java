package nl.avd.dvo.sportcanteen.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import nl.avd.dvo.sportcanteen.logic.Product;
import nl.avd.dvo.sportcanteen.logic.Register;

import java.util.List;
import java.util.Map;

public class RegisterView {
    private Register register;
    private List<Product> products;

    public RegisterView(Register register, List<Product> products) {
        this.register = register;
        this.products = products;
    }

    public Parent getView(){

        VBox productButtons = new VBox();
        productButtons.setPadding(new Insets(10));

        VBox registerOverview = new VBox();
        registerOverview.setSpacing(10);

        TextArea overview = new TextArea();
        Label totalPrice = new Label("Totaal");
        Button payButton = new Button("Afrekenen");
        payButton.setOnAction(e -> {
            overview.clear();
            totalPrice.setText("Totaal: ");
            register.pay();
        });

        for (Product product : products) {
            Button button = new Button(product.getDescription());
            productButtons.getChildren().add(button);
            button.setOnAction(new ChosenProductListener(product, overview, totalPrice));
        }

        registerOverview.getChildren().addAll(overview, totalPrice, payButton);
        registerOverview.alignmentProperty().setValue(Pos.TOP_CENTER);

        BorderPane layout = new BorderPane();
        layout.setLeft(productButtons);
        layout.setRight(registerOverview);

        return layout;
    }

    private class ChosenProductListener implements EventHandler<ActionEvent> {
        private final Product product;
        private final TextArea overview;
        private final Label totalPrice;

        public ChosenProductListener(Product product, TextArea overview, Label totalPrice) {
            this.product = product;
            this.overview = overview;
            this.totalPrice = totalPrice;
        }

        @Override
        public void handle(ActionEvent actionEvent){
            register.chooseProduct(product);
            Map<Product, Integer> productCount = register.getChosenProducts();
            int count = productCount.get(product);

            if (count == 1){
                overview.appendText(count + "x " + product.getName() + " " + (count * product.getPrice()));
            } else {
                overview.clear();
                productCount.forEach((product, freq) -> {
                    overview.appendText(freq + "x " + product.getName() + " " + (freq * product.getPrice()));
                });
            }
            overview.appendText("\n");

            totalPrice.setText("Totaal: " + register.calculateTotalPrice());
        }
    }
}
