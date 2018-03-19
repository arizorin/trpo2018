package practice4.server;

public class Coin {
    private String name;
    private double price;
    private double oldprice;

    public double getOldprice() {
        return oldprice;
    }

    public void setOldprice(double oldprice) {
        this.oldprice = oldprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"price\":" + price +
                '}';
    }
}
