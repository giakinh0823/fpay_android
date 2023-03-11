package fpt.edu.pay.model;

public class TransferMoney {
    private int img;
    private String title;
    private String des;
    private int icon;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public TransferMoney(int img, String title, String des, int icon) {
        this.img = img;
        this.title = title;
        this.des = des;
        this.icon = icon;
    }

    public TransferMoney() {
    }
}
