package fpt.edu.pay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.TransferMoneyDetailAdapter;
import fpt.edu.pay.config.database.TransferMoneyDatabaseHelper;
import fpt.edu.pay.model.Money;

public class TransferMoneyDetailActivity extends AppCompatActivity{

    private EditText edtSearch;
    private EditText edtAmount;
    private TextView txtAmountRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TransferMoneyDatabaseHelper transferMoneyDatabaseHelper = new TransferMoneyDatabaseHelper(TransferMoneyDetailActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_money_detail);

//        Money money1 = new Money(300, "duck1", 1, "0923");
//        Money money2 = new Money(400, "duck2", 1, "0923");
//        Money money3 = new Money(500, "duck3", 0, "0923");
//        Money money4 = new Money(600, "duck4", 0, "0923");
//        Money money5 = new Money(700, "duck5", 1, "0923");
//
//        transferMoneyDatabaseHelper.insert(money1);
//        transferMoneyDatabaseHelper.insert(money2);
//        transferMoneyDatabaseHelper.insert(money3);
//        transferMoneyDatabaseHelper.insert(money4);
//        transferMoneyDatabaseHelper.insert(money5);

        List<Money> list = transferMoneyDatabaseHelper.getAll();
        Money moneyRoot = list.get(0);   // tai khoan goc
        txtAmountRoot = findViewById(R.id.textView5);
        txtAmountRoot.setText(txtAmountRoot.getText() + " " + moneyRoot.getTotalMoney());
        list.remove(list.get(0));

        RecyclerView rec = findViewById(R.id.recycle_moneyDetail);
        TransferMoneyDetailAdapter adapter = new TransferMoneyDetailAdapter(list);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rec.addItemDecoration(itemDecoration);
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

        Button btn_cf = findViewById(R.id.btn_cf);
        edtAmount = findViewById(R.id.edt_amount);
        btn_cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtSearch.getText().toString().trim().isEmpty()){
                    edtSearch.setError("Xin vui lòng nhập tên hoặc số điện thoại !");
                    return;
                }
                if(edtAmount.getText().toString().trim().isEmpty()){
                    edtAmount.setError("Xin vui lòng nhập số tiền cần chuyển !");
                    return;
                }else{
                    try {
                        float amount = Float.parseFloat(edtAmount.getText().toString().trim());
                        Money moneyFind = transferMoneyDatabaseHelper.getMoneyByNameOrNumberPhone(edtSearch.getText().toString().trim());
                        if(moneyFind != null){
                            if(moneyRoot.getTotalMoney() < amount){
                                edtAmount.setError("Số tiền trong tài khoản không đủ để thực hiện giao dịch !");
                            }else{
                                transferMoneyDatabaseHelper.decreaseMoney(moneyRoot.getId(), moneyRoot.getTotalMoney() - amount);
                                transferMoneyDatabaseHelper.decreaseMoney(moneyFind.getId(), moneyFind.getTotalMoney() + amount);
                                Toast.makeText(TransferMoneyDetailActivity.this, "Giao dịch thành công.", Toast.LENGTH_SHORT).show();
                                recreate();
                            }
                        }else{
                            edtSearch.setError("Tài khoản không tồn tại !");
                        }

                    }catch (NumberFormatException e){
                        edtAmount.setError("Số tiền chưa đúng format !");
                        return;
                    }
                }
            }
        });
    }


}