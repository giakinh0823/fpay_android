package fpt.edu.pay.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.SettingAdapter;
import fpt.edu.pay.model.Setting;

public class AccountSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        List<Setting> list = new ArrayList<>();
        Setting c1 = new Setting("Đổi mật khẩu", R.drawable.baseline_arrow_forward_ios_24);
        Setting c2 = new Setting("Quên mật khẩu", R.drawable.baseline_arrow_forward_ios_24);
        Setting c3 = new Setting("Thay đổi số điện thoại", R.drawable.baseline_arrow_forward_ios_24);
        Setting c4 = new Setting("Điều khoản sử dụng",R.drawable.baseline_arrow_forward_ios_24);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        RecyclerView rec = findViewById(R.id.rec_chapters);
        SettingAdapter adapter = new SettingAdapter(list);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);
    }
}