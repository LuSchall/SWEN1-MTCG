package at.technikum.apps.mtcg.entity;

public enum CardType {
    SPELL("Spell"),
    GOBLIN("Goblin"),
    DRAGON("Dragon"),
    WIZARD("Wizard"),
    ORK("Ork"),
    KNIGHT("Knight"),
    KRAKEN("Kraken"),
    ELVE("Elve"),
    TROLL("Troll");

    private final String type;

    CardType(String type) {
        this.type = type;
    }

    public String get() {
        return type;
    }

    public static CardType getTypeFromName(String name) {
        if (name.endsWith("Spell")) return SPELL;
        if (name.endsWith("Goblin")) return GOBLIN;
        if (name.endsWith("Dragon")) return DRAGON;
        if (name.endsWith("Wizard")) return WIZARD;
        if (name.endsWith("Ork")) return ORK;
        if (name.endsWith("Knight")) return KNIGHT;
        if (name.endsWith("Kraken")) return KRAKEN;
        if (name.endsWith("Elve")) return ELVE;
        return TROLL;
    }
}
