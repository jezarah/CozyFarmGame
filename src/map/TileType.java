package map;

public enum TileType {

    GRASS("Grass"),
    // MAP EDGE TILES
    GRASS_TOP_LEFT("Grass Top Left"),
    GRASS_TOP_RIGHT("Grass Top Right"),
    GRASS_TOP_MIDDLE("Grass Top Middle"),
    GRASS_LEFT_MIDDLE("Grass Left Middle"),
    GRASS_LEFT_BOTTOM("Grass Left Bottom"),
    GRASS_RIGHT_BOTTOM("Grass Right Bottom"),
    GRASS_RIGHT_MIDDLE("Grass Right Middle"),
    GRASS_BOTTOM_MIDDLE("Grass Bottom Middle"),
    COLLISION("Collision");

    public final String name;

    TileType(String name) {
        this.name = name;
    }
}
