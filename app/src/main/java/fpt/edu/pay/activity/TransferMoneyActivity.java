package fpt.edu.pay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.TransferBankAdapter;
import fpt.edu.pay.adepter.TransferBankRecycleAdapter;
import fpt.edu.pay.common.OnItemClickListener;
import fpt.edu.pay.model.TransferMoney;

public class TransferMoneyActivity extends AppCompatActivity {
    private int currentPage = 0;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_money);
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.img_chuyentien123);
        images.add(R.drawable.img_chuyen100d);
        images.add(R.drawable.img_quetma);
        images.add(R.drawable.img_chuyen100xu);

        TransferBankAdapter adapter = new TransferBankAdapter(images);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        Runnable runnable = new Runnable() {
            public void run() {
                if (currentPage == images.size() - 1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
                handler.postDelayed(this, 5000);
            }
        };

        List<TransferMoney> transferMoneyList = new ArrayList<>();
        TransferMoney c1 = new TransferMoney(R.drawable.icon1,"Cho bạn bè trong Zalo", "Miễn phí - chỉ cần số điện thoại", R.drawable.baseline_arrow_forward_ios_24_blue);
        TransferMoney c2 = new TransferMoney(R.drawable.icon2,"Đến tài khoản ngân hàng", "Chuyển tiền đến số tài khoản/số thẻ", R.drawable.baseline_arrow_forward_ios_24_blue);

        transferMoneyList.add(c1);
        transferMoneyList.add(c2);


        RecyclerView rec = findViewById(R.id.recyle_transfer);
        TransferBankRecycleAdapter adapter2 = new TransferBankRecycleAdapter(transferMoneyList);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter2);
        adapter2.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(TransferMoneyActivity.this, TransferMoneyDetailActivity.class);
                startActivity(intent);
            }

        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void backToHome(View view) {
        onBackPressed();
    }


}