package nl.avd.dvo.sportcanteen.logic;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Objects;

public abstract class Product implements Serializable {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFormattedPrice(){
        DecimalFormat df2 = new DecimalFormat("#,00");
        String priceText = df2.format(this.price);
        return priceText;
    }

    public String getDescription(){
        return name + " (" + price + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public abstract void order();


}
