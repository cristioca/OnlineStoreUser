import java.util.Arrays;

public class User {
    private String email_user;
    private String password;
    private String[] addresses; // lista de adrese
    private Order[] orders;  // lista de comenzi
    private Wishlist wishlist;  // lista de produse dorite

    // constructor pt user
    public User(String email_user, String password) {
        this.email_user = email_user;
        this.password = password;
        addresses = new String[1];
        orders = new Order[1];
        wishlist = new Wishlist();
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

    public void getOrders() {
        for (Order order: orders) {

            System.out.println("Order number: "+order.getId());
            for(int i=0;i<order.itemList.length;i++){
                System.out.println("Item: "+order.itemList[i]+" --- cost: "+order.priceList[i]+" lei");
            }
        }

    }

    public void getWishlist() {
        System.out.println(wishlist.toString());
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

    public void setOrders(Order[] orders) {
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


    ///////////////////// - alte metode


    // adaugare adresa - intoarce true daca a reusit
    public boolean addAddress(String addr){

        // daca exista adrese atunci fa un nou vector cu nr de elemente+1,
        // copiaza adresele existente si adauga adresa noua la final,
        // apoi inlocuieste vectorul vechi cu cel nou
        if(addresses[0]!=null){
            String[] addrs = new String[addresses.length+1];
            System.arraycopy(addresses, 0, addrs, 0, addresses.length);
            addrs[addresses.length]=addr;
            addresses = addrs;
        } else { // daca nu exista adresa atunci declara vector si pune adresa
            addresses[0]=addr;
        }
        // daca a ajuns aici inseamna ca s-a adaugat adresa si intoarce true
        return true;
    }

    public void newOrder(){
        Order order = new Order();
        if(orders[0]!=null){
            Order[] tempOrders = new Order[orders.length+1];
            System.arraycopy(orders, 0, tempOrders, 0, orders.length);
            tempOrders[orders.length]=order;
            orders = tempOrders;
        } else { // daca nu exista adresa atunci declara vector si pune adresa
            orders[0]=order;
        }
    }

    public void addItemToCurrentOrder(String item, double price){
        orders[orders.length-1].addItemToOrder(item,price);
    }

    public void addItemToWishlist(String item){
        wishlist.addItemToWishlist(item);
    }

    private class Order {
        private int id;
        private String[] itemList;
        private double[] priceList;

        public Order() {
            this.id = Helper.newID();
            itemList = new String[1];
            priceList = new double[1];
        }

        public int getId() {
            return id;
        }


        public String[] getItemList() {
            return itemList;
        }

        public void setItemList(String[] itemList) {
            this.itemList = itemList;
        }

        public double[] getPriceList() {
            return priceList;
        }

        public void setPriceList(double[] priceList) {
            this.priceList = priceList;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "id=" + id +
                    ", itemList=" + Arrays.toString(itemList) +
                    ", priceList=" + Arrays.toString(priceList) +
                    '}';
        }

        ///// alte metode

        // adaugare item la order
        public void addItemToOrder(String item, double price){
            if(itemList[0]!=null){
                String[] tempList = new String[itemList.length+1];
                double[] tempPrices = new double[itemList.length+1];
                System.arraycopy(itemList, 0, tempList, 0, itemList.length);
                System.arraycopy(priceList, 0, tempPrices, 0, itemList.length);
                tempList[itemList.length]=item;
                tempPrices[itemList.length] = price;
                priceList=tempPrices;
                itemList = tempList;
            } else { // daca lista e goala, pune item
                itemList[0]=item;
                priceList[0]=price;
            }
        }


    }

    private class Wishlist{
        private String[] itemList;

        @Override
        public String toString() {
            return "Wishlist{" +
                    "itemList=" + Arrays.toString(itemList) +
                    '}';
        }

        public Wishlist() {
            itemList = new String[1];
        }

        public String[] getItemList() {
            return itemList;
        }

        public void addItemToWishlist(String item){
            if(itemList[0]!=null){
                String[] tempList = new String[itemList.length+1];
                System.arraycopy(itemList, 0, tempList, 0, itemList.length);
                tempList[itemList.length]=item;
                itemList = tempList;
            } else { // daca lista e goala, pune item
                itemList[0]=item;
            }
        }
    }
}
