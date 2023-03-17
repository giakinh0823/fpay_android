package fpt.edu.pay.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.TransferMoneyDetailAdapter;
import fpt.edu.pay.config.database.TransferMoneyDatabaseHelper;
import fpt.edu.pay.model.Money;

public class TransferMoneyDetailActivity extends AppCompatActivity {

    TransferMoneyDatabaseHelper transferMoneyDatabaseHelper = new TransferMoneyDatabaseHelper(TransferMoneyDetailActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_money_detail);

        List<Money> list = transferMoneyDatabaseHelper.getAll();


        RecyclerView rec = findViewById(R.id.recycle_moneyDetail);
        TransferMoneyDetailAdapter adapter = new TransferMoneyDetailAdapter(list);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);
    }
}