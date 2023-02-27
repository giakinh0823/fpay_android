package com.example.project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project.R;
import com.example.project.adapter.SettingAdapter;
import com.example.project.model.Setting;

import java.util.ArrayList;
import java.util.List;

public class SettingAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingaccount);

        List<Setting> list = new ArrayList<>();
        Setting c1 = new Setting("Đổi mật khẩu", R.drawable.ic_right);
        Setting c2 = new Setting("Quên mật khẩu", R.drawable.ic_right);
        Setting c3 = new Setting("Thay đổi số điện thoại", R.drawable.ic_right);
        Setting c4 = new Setting("Điều khoản sử dụng",R.drawable.ic_right);
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