package nl.avd.dvo.sportcanteen;

import nl.avd.dvo.sportcanteen.logic.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import nl.avd.dvo.sportcanteen.logic.Register;
import nl.avd.dvo.sportcanteen.ui.RegisterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        primaryStage.setTitle("Cash Register");
        primaryStage.setScene(new Scene(new Label("Cash Register"), 500, 400));
        primaryStage.show();

        Register register = new Register();
        List<Product> testProducts = new ArrayList<>();
        testProducts.add(new PackagedProduct("Cola", 1.5));
        testProducts.add(new PackagedProduct("Mars", 1.0));
        testProducts.add(new PreparedProduct("Broodje Kaas", 1.5, FoodType.SANDWICH));
        testProducts.add(new PreparedProduct("Broodje Ham", 1.5, FoodType.SANDWICH));

//        TEXT IO voobeeld
//        HashMap<String, Double> productsFromFile = RegisterTextIO.readProducts("products.txt");
//        productsFromFile.forEach((n,p) -> System.out.println(n + " -- " + p));
//
//        HashMap<String, Integer> sales = new HashMap<>();
//        sales.put("coffee", 99);
//        sales.put("soup", 50);
//
//        RegisterTextIO.writeSales("sales.txt", sales);

//      OBJECT IO voorbeeld
        Register testRegister = new Register();
        testRegister.chooseProduct(new PackagedProduct("Cola", 1.5));
        testRegister.chooseProduct(new PackagedProduct("Mars", 1.0));
        testRegister.chooseProduct(new PreparedProduct("Broodje Kaas", 1.5, FoodType.SANDWICH));
        testRegister.chooseProduct(new PreparedProduct("Broodje Ham", 1.5, FoodType.SANDWICH));

        RegisterObjectIO.writeRegister("register.obj", testRegister);
        Register readRegister = RegisterObjectIO.readRegister("register.obj");
        System.out.println(readRegister);

        RegisterView view = new RegisterView(register, testProducts);
        Parent layout = view.getView();

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
