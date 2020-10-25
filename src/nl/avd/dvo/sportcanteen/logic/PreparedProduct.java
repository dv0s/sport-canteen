package nl.avd.dvo.sportcanteen.logic;

public class PreparedProduct extends Product {

    private FoodType foodType;

    public PreparedProduct(String name, double price, FoodType foodType) {
        super(name, price);
        this.foodType = foodType;
    }

    @Override
    public void order() {
        System.out.println(foodType + " order sent to kitchen");
    }
}
