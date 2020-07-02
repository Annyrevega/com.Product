package app.object;

public class Customer {
    private int product_id;
    private String product_name;
    private int price;
    private int shop_id;

    public Customer() {
    }

    public Customer(String product_name, int price, int shop_id) {

        this.product_name = product_name;
        this.price = price;
        this.shop_id = shop_id;
    }



    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getPrice() {
        return price;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }
}
