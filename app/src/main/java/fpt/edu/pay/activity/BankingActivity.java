package fpt.edu.pay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import fpt.edu.pay.MainActivity;
import fpt.edu.pay.R;

public class BankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);

        ImageView back = findViewById(R.id.back_id);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BankingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}