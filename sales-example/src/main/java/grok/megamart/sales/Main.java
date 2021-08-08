package grok.megamart.sales;

import grok.megamart.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Item> shoppingCart = new ArrayList<>();
    private static double shoppingCartTotal;

    public static void main(String[] args) {
        addItemToCart("Футболка", 5.00);
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
        logAvailableItems();
        logCartTotal();
    }

    private static void logCartTotal() {
        System.out.println("-----");
        System.out.printf("Общая стоимость товаров в корзине: %3.2f", shoppingCartTotal);
    }

    private static void logAvailableItems() {
        System.out.printf("%-10s:%7.2f%n", "Футболка", 5.0);
        System.out.printf("%-10s:%7.2f%n", "Кроссовки", 12.0);
        System.out.printf("%-10s:%7.2f%n", "Галстук", 8.0);
    }
}
