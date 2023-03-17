package fpt.edu.pay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import fpt.edu.pay.R;

public class RechargeWithdraw extends AppCompatActivity {
    ImageView imv1;
    ImageView imv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_withdraw);
        imv1 = findViewById(R.id.imageView29);
        imv2 = findViewById(R.id.imageView31);

        imv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RechargeWithdraw.this, RechargeDetailActivity.class);
                startActivity(intent);
            }
        });

        imv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RechargeWithdraw.this, WithdrawDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}