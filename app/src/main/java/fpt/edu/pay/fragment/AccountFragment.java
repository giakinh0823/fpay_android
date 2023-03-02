package fpt.edu.pay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.GroupMenuAccountAdapter;
import fpt.edu.pay.constant.AccountConstant;
import fpt.edu.pay.model.account.GroupMenuAccount;
import fpt.edu.pay.model.account.MenuAccount;
import fpt.edu.pay.model.recycle.VerticalSpaceItemDecoration;


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

        int dividerColor = ContextCompat.getColor(view.getContext(), R.color.divider_color);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(groupMenuAccountAdapter);
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(20, dividerColor));

        return view;
    }

    private void mapping(View view) {
        recyclerView = view.findViewById(R.id.recycle_view_menu_account);
        groupMenuAccountAdapter = new GroupMenuAccountAdapter(Stream.concat(Stream.of(
                        new GroupMenuAccount(List.of(
                                new MenuAccount("Hà Gia Kính", "0972141556", R.raw.avatar)
                        ))),
                        AccountConstant.GROUP_MENU_ACCOUNTS.stream())
                .collect(Collectors.toList()));
    }
}