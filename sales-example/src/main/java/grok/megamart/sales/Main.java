package grok.megamart.sales;

import grok.megamart.domain.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        shoppingCart = addItem(shoppingCart, name, price);
        calcCartTotal();
    }

    private static List<Item> addItem(List<Item> cart, String name, double price) {
        List<Item> newCart = new ArrayList<>(cart);
        newCart.add(new Item(name, price));
        return newCart;
    }

    private static void calcCartTotal() {
        shoppingCartTotal = calcTotal(shoppingCart);

        logTaxInfo();
        logCartTotal();

        System.out.println("-----");

        updateShippingInfo();
        logAvailableItems();
    }

    private static double calcTotal(List<Item> cart) {
        double total = 0.0;
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            total += item.getPrice();
        }
        return total;
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

    private static void logTaxInfo() {
        final double taxAmount = calcTaxAmount(shoppingCartTotal);
        System.out.printf("Сумма налога с продаж:%19.2f%n", taxAmount);
    }

    private static double calcTaxAmount(double totalCost) {
        return totalCost * 0.1;
    }

    private static void logCartTotal() {
        System.out.printf("Общая стоимость товаров в корзине:\t%3.2f%n",
                shoppingCartTotal);
    }

    private static void logAvailableItems() {
        for (Item item : shippingInfo.keySet()) {
            System.out.printf("%-10s:%7.2f\t%s%n",
                    item.getName(), item.getPrice(),
                    shippingInfo.get(item) ? "Бесплатная доставка!!!":"");
        }
    }
}