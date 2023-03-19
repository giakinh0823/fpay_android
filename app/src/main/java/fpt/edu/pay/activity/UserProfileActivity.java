package fpt.edu.pay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import fpt.edu.pay.MainActivity;
import fpt.edu.pay.R;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ImageView back = findViewById(R.id.user_profile_back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(UserProfileActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}