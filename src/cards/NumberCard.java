package cards;

public class NumberCard extends Card {
    private int number;

    public NumberCard(Integer points, Color color, Type type, int number) {
        super(points, color, type);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "NumberCard{" +
                "color=" + getColor() +
                ", type=" + getType() +
                ", number=" + getNumber() +
                '}';
    }
}
