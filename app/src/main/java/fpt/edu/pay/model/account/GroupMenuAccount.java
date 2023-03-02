package fpt.edu.pay.model.account;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupMenuAccount {
    private List<MenuAccount> menuAccounts;

    public GroupMenuAccount(List<MenuAccount> menuAccounts) {
        this.menuAccounts = menuAccounts;
    }

    public List<MenuAccount> getMenuAccounts() {
        return menuAccounts;
    }

    public void setMenuAccounts(List<MenuAccount> menuAccounts) {
        this.menuAccounts = menuAccounts;
    }
}
