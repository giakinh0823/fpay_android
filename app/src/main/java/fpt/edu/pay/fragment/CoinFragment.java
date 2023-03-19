package fpt.edu.pay.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.CoinAdapter;
import fpt.edu.pay.model.coin.Coin;
public class CoinFragment extends Fragment {

    private RecyclerView coin;
    private CoinAdapter coinAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_coin, container, false);

        List<Coin> list = new ArrayList<>();
        list.add(new Coin(R.drawable.ic_coin_2, "Go2Joy", "Giảm 5%", "Cho đơn từ 300k"));
        list.add(new Coin(R.drawable.ic_coin_3, "Go2Joy", "Giảm 5%", "Cho đơn từ 300k"));
        list.add(new Coin(R.drawable.ic_coin_4, "Go2Joy", "Giảm 5%", "Cho đơn từ 300k"));
        list.add(new Coin(R.drawable.ic_coin_5, "Go2Joy", "Giảm 5%", "Cho đơn từ 300k"));
        list.add(new Coin(R.drawable.ic_coin_6, "Go2Joy", "Giảm 5%", "Cho đơn từ 300k"));
        list.add(new Coin(R.drawable.ic_coin_2, "Go2Joy", "Giảm 5%", "Cho đơn từ 300k"));
        coin = view.findViewById(R.id.rcv_coin);
        CoinAdapter coinAdapter = new CoinAdapter(list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        coin.setLayoutManager(gridLayoutManager);
        coin.setAdapter(coinAdapter);
        return  view;

    }
}