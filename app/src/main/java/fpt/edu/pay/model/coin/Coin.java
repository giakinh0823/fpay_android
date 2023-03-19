package fpt.edu.pay.model.coin;

public class Coin {
    private int image;
    private String name_app;
    private String name_discount;
    private String name_max;

    public Coin(int image, String name_app, String name_discount, String name_max) {
        this.image = image;
        this.name_app = name_app;
        this.name_discount = name_discount;
        this.name_max = name_max;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName_app() {
        return name_app;
    }

    public void setName_app(String name_app) {
        this.name_app = name_app;
    }

    public String getName_discount() {
        return name_discount;
    }

    public void setName_discount(String name_discount) {
        this.name_discount = name_discount;
    }

    public String getName_max() {
        return name_max;
    }

    public void setName_max(String name_max) {
        this.name_max = name_max;
    }
}
