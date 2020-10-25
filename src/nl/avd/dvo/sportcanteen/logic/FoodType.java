package nl.avd.dvo.sportcanteen.logic;

public enum FoodType {
    FRIED,
    COOKED,
    SANDWICH,
    OTHER;

    @Override
    public String toString() {
        switch (this) {
            case FRIED -> { return "Fried"; }
            case COOKED -> { return "Cooked"; }
            case SANDWICH -> { return "Sandwich"; }
            default -> { return "Other"; }
        }

    }
}
