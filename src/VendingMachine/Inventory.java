package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static int productId = 0;
    List<Product> products = new ArrayList<>();

    public Inventory(List<Product> products) {
        this.products = products;
    }

    Product getProduct(int productId) {
        for (Product product: products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(Product product) {
       products.stream().filter(p -> p.getId() != product.getId()).close();
    }

    public List<Product> getProducts() {
        return products;
    }
}
