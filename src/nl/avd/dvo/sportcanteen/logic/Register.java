package nl.avd.dvo.sportcanteen.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Register implements Serializable {
    private List<Product> chosenProducts;

    public Register() {
        this.chosenProducts = new ArrayList<>();
    }

    public HashMap<Product, Integer> getChosenProducts() {
        HashMap<Product, Integer> count = new HashMap<>();
        // Walk through chosenProducts and count the number of times a product is chosen.
        for (Product chosenProduct : chosenProducts) {
            if (count.containsKey(chosenProduct)) {
                int freq = count.get(chosenProduct);
                count.put(chosenProduct, freq + 1);
            } else {
                count.put(chosenProduct, 1);
            }
        }

        return count;
    }

    public void chooseProduct(Product product) {
        chosenProducts.add(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        for (Product chosenProduct : chosenProducts) {
            totalPrice += chosenProduct.getPrice();
        }

        return totalPrice;
    }

    public void pay() {
        for (Product chosenProduct : chosenProducts) {
            chosenProduct.order();
        }
        chosenProducts.clear();
    }
}
