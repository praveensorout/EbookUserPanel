package cartdata;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CartSerializer {
    private static final String CART_FILE = "cart.ser";

    public static void serializeCart(CartDisplay cart) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CART_FILE))) {
            oos.writeObject(cart);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CartDisplay deserializeCart() {
        CartDisplay cart = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CART_FILE))) {
            cart = (CartDisplay) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cart;
    }
}
