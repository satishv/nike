import javax.swing.text.AttributeSet;

/**
 * User: satish
 */
public class Item {
    // id of item A, B, etc.
    char id;

    // price of the item
    int price;

    // pricing like the following 5 for the price of 3
    // can be represented as follows.
    // paidItems = 3 and totalItems = 5.
    // If both are null, then there is no special offer/pricing
    // TODO: the "rule" can be refactored into a difference interface/class as well
    Integer paidItems;
    Integer totalItems;

    public Item(final char id, final int price) {
        this.id = id;
        this.price = price;
    }

    public Item(final char id, final int price, final int totalItems, final int paidItems) {
        this.id = id;
        this.price = price;
        this.paidItems = paidItems;
        this.totalItems = totalItems;
    }

    public int items(final int total) {
        if (totalItems != null && paidItems != null) {
            return (total/totalItems) * paidItems + (total % totalItems);
        } else {
            return total;
        }
    }
}
