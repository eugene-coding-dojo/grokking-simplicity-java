package grok.megamart.sales;

import grok.megamart.domain.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static List<Item> shoppingCart = new ArrayList<>();
    private static double shoppingCartTotal;
    private static Map<Item, Boolean> shippingInfo = new HashMap<>();

    static {
        shippingInfo.put(new Item("Футболка", 5.00), false);
        shippingInfo.put(new Item("Кроссовки", 12.00), false);
        shippingInfo.put(new Item("Галстук", 8.00), false);
    }

    public static void main(String[] args) {
        addItemToCart("Джинсы", 10.00);
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
        updateShippingInfo();
        logCartTotal();
        logAvailableItems();
    }

    private static void updateShippingInfo() {
        for (Item item : shippingInfo.keySet()) {
            if (item.getPrice() + shoppingCartTotal >= 20) {
                shippingInfo.put(item, true);
            } else {
                shippingInfo.put(item, false);
            }
        }
    }

    private static void logCartTotal() {
        System.out.printf("Общая стоимость товаров в корзине: %3.2f%n", shoppingCartTotal);
        System.out.println("-----");
    }

    private static void logAvailableItems() {
        for (Item item : shippingInfo.keySet()) {
            System.out.printf("%-10s:%7.2f\t%s%n",
                    item.getName(), item.getPrice(),
                    shippingInfo.get(item) ? "Бесплатная доставка!!!" : "");
        }
    }
}
