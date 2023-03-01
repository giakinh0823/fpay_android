package fpt.edu.pay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.GroupMenuAccountAdapter;
import fpt.edu.pay.model.GroupMenuAccount;
import fpt.edu.pay.model.MenuAccount;


public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    GroupMenuAccountAdapter groupMenuAccountAdapter;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        mapping(view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(groupMenuAccountAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        return view;
    }

    private void mapping(View view) {
        recyclerView = view.findViewById(R.id.recycle_view_menu_account);
        List<GroupMenuAccount> groupMenuAccounts = List.of(new GroupMenuAccount(List.of(
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
        groupMenuAccountAdapter = new GroupMenuAccountAdapter(groupMenuAccounts);
    }
}