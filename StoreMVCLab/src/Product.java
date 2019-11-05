import javafx.beans.property.*;

import java.util.LinkedList;

public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private String name;
    private IntegerProperty stock = new SimpleIntegerProperty();
    private DoubleProperty price = new SimpleDoubleProperty();

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock.set(stock);
        this.price.set(price);
    }

    public final String getName() {
        return name;
    }

    public final int getStock(){
        return stock.get();
    }

    public final double getPrice(){
        return price.get();
    }

    private final void setStock(int value){
        stock.set(value);
    }

    public ReadOnlyIntegerProperty stockProperty(){
        return stock;
    }

    public ReadOnlyDoubleProperty priceProperty(){
        return price;
    }

    public void sell(int n) {
        setStock(getStock() - n);
        double money = n * getPrice();
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n) {
        stock.add(n);
    }


    public boolean has(int n) {
        return stock.get() >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}
