package fpt.edu.pay.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

import fpt.edu.pay.R;

public class PayBillActivity extends AppCompatActivity {
    private ImageSlider imageSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bill);

        imageSlider = findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModel= new ArrayList<>();
        slideModel.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        slideModel.add(new SlideModel(R.drawable.banner2, ScaleTypes.CENTER_CROP));
        slideModel.add(new SlideModel(R.drawable.banner3, ScaleTypes.CENTER_CROP));
        slideModel.add(new SlideModel(R.drawable.ic_20, ScaleTypes.FIT));

        imageSlider.setImageList(slideModel);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void backToHome(View view) {
        onBackPressed();
    }
}