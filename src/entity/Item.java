package entity;

// represents an Inventory Item with a ItemType and count

public class Item {
    private ItemType type;
    private int count;

    // Constructor for item
    public Item(ItemType type, int count) {
        this.type = type;
        this.count = count;
    }

    public Item(String str, int count) {
        this.type = ItemType.valueOf(str.toUpperCase());
    }

    // getters
    public ItemType getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    // MODIFIES: this
    // EFFECTS: increases count by n
    public void increaseCount(int n) {
        count += n;
    }

    // MODIFIES: this
    // EFFECTS: decreases count by n
    public void decreaseCount(int n) {
        count -= n;
    }
}
