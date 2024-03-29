package fpt.edu.pay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.config.database.TransferMoneyDatabaseHelper;
import fpt.edu.pay.model.Money;

public class RechargeDetailActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    EditText edt1;
    ImageView imv1;
    TextView totalmoney;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_detail);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        edt1 = findViewById(R.id.money_input);
        imv1 = findViewById(R.id.back);
        totalmoney = findViewById(R.id.totalmoney);
        submit = findViewById(R.id.confirm_button);
        TransferMoneyDatabaseHelper transferMoneyDatabaseHelper = new TransferMoneyDatabaseHelper(RechargeDetailActivity.this);
        List<Money> listMoney = transferMoneyDatabaseHelper.getAll();
        Money moneyRoot = listMoney.get(0);
        totalmoney.setText(""+ moneyRoot.getTotalMoney() +"đ");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn1.getText());

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn2.getText());

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn3.getText());

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn4.getText());

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn5.getText());

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn6.getText());

            }
        });

        imv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RechargeDetailActivity.this, RechargeWithdraw.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float totalMoney =Float.parseFloat(edt1.getText().toString().trim()) + moneyRoot.getTotalMoney();
                transferMoneyDatabaseHelper.decreaseMoney(moneyRoot.getId(),totalMoney);
                recreate();
            }
        });

    }


}