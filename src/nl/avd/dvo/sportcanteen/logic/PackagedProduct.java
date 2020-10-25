package nl.avd.dvo.sportcanteen.logic;

public class PackagedProduct extends Product {

    public PackagedProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public void order() {
        System.out.println("Packaged product served");
    }

}
