package model;

public enum ItemType {

    CARROT("CARROT",100, true, false, true),
    TOMATO("TOMATO", 150, true, false, true),
    STRAWBERRY("STRAWBERRY", 200,true, false, true),
    PUMPKIN("PUMPKIN", 300, true, false, true),
    WHEAT("WHEAT", 50, true, false, true),
    POTATO("POTATO", 80,true, false, true),
    RADISH("RADISH", 60,true, false, true),
    CABBAGE("CABBAGE",180,true, false, true),
    BEET("BEET",120,true, false, true),
    WATERMELON("WATERMELON", 400,true, false, true),
    TULIP("TULIP", 80, true, false,false),
    ROSE("ROSE", 200, true, false,false),
    GARDENIA("GARDENIA", 180, true, false,false),
    PERIWINKLE("PERIWINKLE", 150,true, false,false),
    MARIGOLD("MARIGOLD", 230,true, false,false),
    DAFFODIL("DAFFODIL",110,true, false,false),
    HOE("HOE",0,false, true, false),
    WATERINGCAN("WATERINGCAN",0,false, true, false);

    public final String name;
    public final int value;
    public final boolean sellable;
    public final boolean equipable;
    public final boolean edible;

    ItemType(String name, int value, boolean sellable, boolean equipable, boolean edible) {
        this.name = name;
        this.value = value;
        this.sellable = sellable;
        this.equipable = equipable;
        this.edible = edible;
    }
}
