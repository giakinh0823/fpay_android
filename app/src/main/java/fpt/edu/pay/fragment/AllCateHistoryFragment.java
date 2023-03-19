package fpt.edu.pay.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.ListHistoryAdapter;
import fpt.edu.pay.config.database.DatabaseHelper;
import fpt.edu.pay.config.database.HistoryDatabaseHelper;
import fpt.edu.pay.model.histoty.History;

public class AllCateHistoryFragment extends Fragment {
    private static final String TABLE_NAME = "bank_trans";
    private RecyclerView recyclerView;
    private ListHistoryAdapter adapter;
    private ArrayList<History> listHistory = new ArrayList<History>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_categories_all, container, false);

        listHistory.add(new History(1,1,"Nạp ví ShopeePay","12/12/2023",12000,1,"moa moa moa"));
        listHistory.add(new History(2,1,"Nạp ví ShopeePay","12/12/2023",100000,0,"moa moa moa"));
        listHistory.add(new History(3,1,"Nạp ví ShopeePay","12/12/2023",562000,1,"moa moa moa"));
        listHistory.add(new History(4,1,"Nạp ví ShopeePay","12/12/2023",123000,0,"moa moa moa"));
        listHistory.add(new History(5,1,"Nạp ví ShopeePay","12/12/2023",52300,1,"moa moa moa"));
        listHistory.add(new History(6,1,"Nạp ví ShopeePay","12/12/2023",33000,1,"moa moa moa"));
//        HistoryDatabaseHelper dbHelper = new HistoryDatabaseHelper(getContext());
//        listHistory = (ArrayList<History>) dbHelper.getAll();
        recyclerView = view.findViewById(R.id.rcv_cate_all);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        adapter = new ListHistoryAdapter(listHistory);
        recyclerView.setAdapter(adapter);
        return view;

    }
}
