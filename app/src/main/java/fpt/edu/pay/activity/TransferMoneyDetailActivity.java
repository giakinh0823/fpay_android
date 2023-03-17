package fpt.edu.pay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.TransferMoneyDetailAdapter;
import fpt.edu.pay.config.database.TransferMoneyDatabaseHelper;
import fpt.edu.pay.model.Money;

public class TransferMoneyDetailActivity extends AppCompatActivity{

    private EditText edtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TransferMoneyDatabaseHelper transferMoneyDatabaseHelper = new TransferMoneyDatabaseHelper(TransferMoneyDetailActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_money_detail);

//        Money money1 = new Money(300, "duck1", 1, "0923");
//        Money money2 = new Money(400, "duck2", 1, "0923");
//        Money money3 = new Money(500, "duck3", 1, "0923");
//        Money money4 = new Money(600, "duck4", 1, "0923");
//        Money money5 = new Money(700, "duck5", 1, "0923");
//
//        transferMoneyDatabaseHelper.insert(money1);
//        transferMoneyDatabaseHelper.insert(money2);
//        transferMoneyDatabaseHelper.insert(money3);
//        transferMoneyDatabaseHelper.insert(money4);
//        transferMoneyDatabaseHelper.insert(money5);


        List<Money> list = transferMoneyDatabaseHelper.getAll();

        RecyclerView rec = findViewById(R.id.recycle_moneyDetail);
        TransferMoneyDetailAdapter adapter = new TransferMoneyDetailAdapter(list);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);

        ImageView back = findViewById(R.id.id_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransferMoneyDetailActivity.this, TransferMoneyActivity.class);
                startActivity(intent);
            }
        });

        TextView tv_listFriend = findViewById(R.id.tv_listFriend);
        tv_listFriend.setText(tv_listFriend.getText() + " (" + adapter.getItemCount() + ")");

        edtSearch = findViewById(R.id.edtSearch);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Money money = (Money) bundle.getSerializable("money");
            edtSearch.setText(money.getFriendName());
        }
    }


}