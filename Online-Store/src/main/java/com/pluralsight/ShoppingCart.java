package com.pluralsight;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items;

    public ShoppingCart() {
        items = new ArrayList<Product>();
    }

    public void addProduct(Product p) {
        items.add(p);
    }

    public void removeProduct(int position) {
        if (position >= 0 && position < items.size()) {
            items.remove(position);
        }
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Your Shopping Cart:");
        for (int i = 0; i < items.size(); i++) {
            Product p = items.get(i);
            System.out.println((i+1) + ". " + p.getName() + " - $" + p.getPrice());
        }
        System.out.println("Your total is: $" + getTotal());
    }
}