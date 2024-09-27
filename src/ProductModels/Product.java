package ProductModels;

import java.util.Comparator;

public class Product implements Comparable <Product> {
    private final String productName;
    private final int price;



    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return  this.getProductName() + " con un valor de ($" + this.getPrice() + ")";
    }


    @Override
    public int compareTo(Product nextProduct) {
        return Integer.compare(this.price, nextProduct.price);
    }
}
