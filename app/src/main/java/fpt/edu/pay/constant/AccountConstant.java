package fpt.edu.pay.constant;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.model.account.GroupMenuAccount;
import fpt.edu.pay.model.account.MenuAccount;

public class AccountConstant {
    public static final List<GroupMenuAccount> GROUP_MENU_ACCOUNTS = List.of(new GroupMenuAccount(List.of(
                    new MenuAccount("Mã QR nhận tiền", "", R.drawable.ic_qr_scan)
            )), new GroupMenuAccount(List.of(
                    new MenuAccount("Số dư", "100.000đ", R.drawable.ic_balance),
                    new MenuAccount("Xu tích lũy", "25 xu", R.drawable.ic_hold_coin),
                    new MenuAccount("1 ưu đãi", "1 ưu đãi", R.drawable.ic_gift)
            )), new GroupMenuAccount(List.of(
                    new MenuAccount("Ngân hàng", "1 liên kết", R.drawable.ic_card),
                    new MenuAccount("Quản lý hóa đơn", "Thêm hóa đơn", R.drawable.ic_bill),
                    new MenuAccount("Liên kết ngân hàng", "", R.drawable.ic_linked_bank)
            )), new GroupMenuAccount(List.of(
                    new MenuAccount("Thiết lập tài khoản", "", R.drawable.ic_setting_account),
                    new MenuAccount("Tài khoản thông báo", "", R.drawable.ic_setting_noti),
                    new MenuAccount("Trung tâm hỗ trợ", "", R.drawable.ic_support),
                    new MenuAccount("Thông tin ứng dụng", "", R.drawable.ic_info_app)
            ))
    );
}
