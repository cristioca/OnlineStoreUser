import java.util.Arrays;

public class User {
    private String email_user;
    private String password;
    private String[] addresses; // lista de adrese
    private Orders[] orders;  // lista de comenzi
    private Wishlist wishlist;  // lista de produse dorite

    // constructor pt user
    public User(String email_user, String password) {
        this.email_user = email_user;
        this.password = password;
    }

    // getters
    public String getEmail_user() {
        return email_user;
    }

    public String getPassword() {
        return password;
    }

    public String[] getAddresses() {
        return addresses;
    }

    public Orders[] getOrders() {
        return orders;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    //setters
    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    public void setOrders(Orders[] orders) {
        this.orders = orders;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    @Override
    public String toString() {
        return "User{" +
                "email_user='" + email_user + '\'' +
                ", password='" + password + '\'' +
                ", addresses=" + Arrays.toString(addresses) +
                ", orders=" + Arrays.toString(orders) +
                ", wishlist=" + wishlist +
                '}';
    }
}
