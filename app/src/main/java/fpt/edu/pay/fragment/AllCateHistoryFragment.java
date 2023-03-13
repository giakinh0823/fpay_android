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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.history_categories_all, container, false);
        recyclerView = view.findViewById(R.id.rcv_cate_all);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        adapter = new ListHistoryAdapter(new ArrayList<History>());
        recyclerView.setAdapter(adapter);
        HistoryDatabaseHelper dbHelper = new HistoryDatabaseHelper(getContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        List<History> historyList = dbHelper.getAll();
        Cursor cursor = db.rawQuery("SELECT status FROM bank_trans", null);
        View view_item =  inflater.inflate(R.layout.history_categories_all_item, container, false);
        TextView textView = view_item.findViewById(R.id.status);
        if (cursor != null && cursor.moveToFirst()) {
            // Lấy giá trị của cột "status"
            int columnIndex = cursor.getColumnIndex("status");
            if (cursor.getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER) {
                int status = cursor.getInt(columnIndex);
                if (status == 1) {
                    textView.setText("Chuyển thành công");
                }
            }else{
                Log.e("TAG", "Column 'status' is not an integer");
            }
            // Kiểm tra nếu giá trị của cột "status" bằng 1, hiển thị nội dung tương ứng trong TextView

        }
        cursor.close();
        adapter.setData(historyList);
        adapter.notifyDataSetChanged();
        return view;

    }
}
