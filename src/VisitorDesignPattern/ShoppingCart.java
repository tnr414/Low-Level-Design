package VisitorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<ItemElement> shoppingList = new ArrayList<>();

    void addItem(ItemElement item) {
        shoppingList.add(item);
    }

    void checkout(Visitor visitor) {
        for(ItemElement item: shoppingList) {
            item.accept(visitor);
        }
    }
}
