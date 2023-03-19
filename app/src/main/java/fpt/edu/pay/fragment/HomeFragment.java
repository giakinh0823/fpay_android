package fpt.edu.pay.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import fpt.edu.pay.R;
import fpt.edu.pay.activity.PayBillActivity;
import fpt.edu.pay.activity.RechargeWithdraw;
import fpt.edu.pay.activity.TransferMoneyActivity;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.bill);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PayBillActivity.class);
                startActivity(intent);
            }
        });


        ImageView imageView = view.findViewById(R.id.exchange);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TransferMoneyActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageView2 = view.findViewById(R.id.recharge_withdraw);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RechargeWithdraw.class);
                startActivity(intent);
            }
        });

        return view;
    }

}