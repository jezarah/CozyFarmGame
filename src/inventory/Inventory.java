package inventory;

import entity.Item;

import java.util.*;

// Represents an Inventory with Items (Crops, Flowers, and Tools) and an amount of gold

public class Inventory {
    private final int INVENTORY_SIZE = 27;
    private final int MAX_PER_SLOT = 10;
    private HashSet<Item> items;
    private int gold;

    // Constructs an Inventory without an amount of gold
    public Inventory() {
        this.gold = 1000;
        items = new LinkedHashSet<>(INVENTORY_SIZE);
    }

    // Constructs an Inventory with a set amount of gold
    public Inventory(int gold) {
        this.gold = gold;
        items = new LinkedHashSet<>(INVENTORY_SIZE);
    }

    // getters
    public int getGold() {
        return gold;
    }

    public HashSet<Item> getItems() {
        return items;
    }

    // EFFECTS: returns true if the inventory is full
    public boolean inventoryFull() {
       return (items.size() >= INVENTORY_SIZE);
    }

    // MODIFIES: this
    // EFFECTS: if inventory is full throws InventoryFullException
    // otherwise adds item with n count to items OR increases item
    // count of same ItemType already in inventory by n
    public void addItem(Item item, int n) throws InventoryFullException {
        if (inventoryFull()) throw new InventoryFullException();
        if (items.contains(item)) {
            Iterator<Item> itr = items.iterator();
            while (itr.hasNext()) {
                if (itr.next().getType() == item.getType()) {
                    itr.next().increaseCount(n);
                    break;
                }
            }
        } else {
            items.add(item);
        }
    }

}
