import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: satish
 */
public class SupermarketImpl implements Supermarket {

    Map<Character, Item> items;

    public SupermarketImpl() {
        // initialize the items
        // Can be done various ways - read the items from file, DB etc.
        /*
         Product A = $20

        Product B = $50 (or 5 for the price of 3)

        Product C = $30
        */
        items = new HashMap<Character, Item>();
        items.put('A', new Item('A', 20));
        items.put('B', new Item('B', 50, 5, 3));
        items.put('C', new Item('C', 30));
    }

    public int checkout(final String itemsString) {
        Map<String, Integer> productTotals;

        int totalPrice = 0;
        // first calculate number of items
        Map<Character, Integer> itemCounts = itemCount(itemsString);

        // now calculate the price to charge
        for (Map.Entry<Character, Integer> itemEntry : itemCounts.entrySet()) {
            Item item = items.get(itemEntry.getKey());
            totalPrice += (item.price * item.items(itemEntry.getValue()));
        }

        return totalPrice;
    }

    private Map<Character, Integer> itemCount(final String s) {
        // todo: case sesitive check/conversion
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if (s == null || s.trim().isEmpty()) {
            return map;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // TODO: check if this product is items catalog or not
            Integer val = map.get(new Character(c));
            if (val != null) {
                map.put(c, val + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
