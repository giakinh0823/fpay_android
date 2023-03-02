package fpt.edu.pay.model.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuAccount {
    private String title;
    private String desc;
    private int image;


    public MenuAccount() {
    }

    public MenuAccount(String title, String desc, int image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
