package fpt.edu.pay.model;

public class Setting {
    private String title;
    private int img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Setting(String title, int img) {
        this.title = title;
        this.img = img;
    }

    public Setting() {
    }
}
