package fpt.edu.pay.constant;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.model.account.GroupMenuAccount;
import fpt.edu.pay.model.account.MenuAccount;

public class AccountConstant {

    public static class Type {
        public static final String PROFILE = "PROFILE";
        public static final String ITEM = "ITEM";
    }
    public static final List<GroupMenuAccount> GROUP_MENU_ACCOUNTS = List.of(new GroupMenuAccount(List.of(
                    new MenuAccount(Type.ITEM, "Mã QR nhận tiền", "", R.drawable.ic_qr_scan)
            )), new GroupMenuAccount(List.of(
                    new MenuAccount(Type.ITEM, "Số dư", "100.000đ", R.drawable.ic_balance),
                    new MenuAccount(Type.ITEM, "Xu tích lũy", "25 xu", R.drawable.ic_hold_coin),
                    new MenuAccount(Type.ITEM, "1 ưu đãi", "1 ưu đãi", R.drawable.ic_gift)
            )), new GroupMenuAccount(List.of(
                    new MenuAccount(Type.ITEM, "Ngân hàng", "1 liên kết", R.drawable.ic_card),
                    new MenuAccount(Type.ITEM, "Quản lý hóa đơn", "Thêm hóa đơn", R.drawable.ic_bill),
                    new MenuAccount(Type.ITEM, "Liên kết ngân hàng", "", R.drawable.ic_linked_bank)
            )), new GroupMenuAccount(List.of(
                    new MenuAccount(Type.ITEM, "Thiết lập tài khoản", "", R.drawable.ic_setting_account),
                    new MenuAccount(Type.ITEM, "Tài khoản thông báo", "", R.drawable.ic_setting_noti),
                    new MenuAccount(Type.ITEM, "Trung tâm hỗ trợ", "", R.drawable.ic_support),
                    new MenuAccount(Type.ITEM, "Thông tin ứng dụng", "", R.drawable.ic_info_app)
            ))
    );
}
