package VendingMachine;

abstract public class Product {
    private int id;
    private ProductType type;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(ProductType IceCream, int price, int id) {
        this.type = IceCream;
        this.price = price;
        this.id = id;
    }
}
