package at.technikum.apps.mtcg.entity;

public enum CardElement {
    NORMAL("Normal"),
    FIRE("Fire"),
    WATER("Water"),
    GODLIKE("Godlike");

    private final String element;

    CardElement(String element) {
        this.element = element;
    }

    public String get() {
        return element;
    }
    public static CardElement getElementFromName(String name) {
        if (name.startsWith("Fire")) return FIRE;
        if (name.startsWith("Water")) return WATER;
        if (name.startsWith("Godlike")) return GODLIKE;
        return NORMAL;
    }
}
