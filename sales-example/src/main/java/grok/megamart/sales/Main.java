package grok.megamart.sales;

import grok.megamart.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Item> shoppingCart = new ArrayList<>();
    private static double shoppingCartTotal;

    public static void main(String[] args) {
        addItemToCart("T-shirt", 5.00);
    }

    private static void addItemToCart(String name, double price) {
        shoppingCart.add(new Item(name, price));
        calcCartTotal();
    }

    private static void calcCartTotal() {
        shoppingCartTotal = 0.0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            Item item = shoppingCart.get(i);
            shoppingCartTotal += item.getPrice();
        }
        logCartTotal();
    }

    private static void logCartTotal() {
        System.out.printf("Shopping cart total is: %3.2f", shoppingCartTotal);
    }
}
