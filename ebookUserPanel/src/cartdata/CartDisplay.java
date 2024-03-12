package cartdata;
import cartstore.CartStore;
import userdata.UserData;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CartDisplay implements Serializable {
    private Map<Integer, CartStore> cartItems;

    public CartDisplay() {
        cartItems = new HashMap<>();
    }

    public void addToCart(CartStore cs) {
        cartItems.put(cs.getBookId(), cs);
    }

    public void removeFromCart(int bookId) {
        cartItems.remove(bookId);
    }

    public Map<Integer, CartStore> getCartItems() {
        return cartItems;
    }
}
