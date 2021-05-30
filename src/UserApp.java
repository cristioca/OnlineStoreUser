import java.util.Arrays;

public class UserApp {
    public static void main(String[] args) {
        User user = new User("Oka@kee","rorri");

        System.out.println("user: " + user.getEmail_user());
        System.out.println("pass: " + user.getPassword());

        //test adrese
        user.addAddress("Iasi");
        user.addAddress("Bucuresti, str Barza nr 4");
        System.out.println("adrese:" + Arrays.toString(user.getAddresses()));

        //test order
        user.newOrder();
        user.addItemToCurrentOrder("Ice cream",5.32);
        user.addItemToCurrentOrder("Pen",1.20);
        System.out.println(user);
        user.newOrder();
        user.addItemToCurrentOrder("Doll",3.04);
        System.out.println(user);
        user.getOrders();

        // test wishlist
        user.addItemToWishlist("Tablet");
        user.addItemToWishlist("Batteries");
        user.addItemToWishlist("Monitor Dell");
        user.getWishlist();

    }
}
