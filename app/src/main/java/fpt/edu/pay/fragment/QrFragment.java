package fpt.edu.pay.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import fpt.edu.pay.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class QrFragment extends Fragment {


    ImageView imgView;
    Button button_camera;

    TextView tvText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_qr, container, false);
        imgView = view.findViewById(R.id.image_camera);
        button_camera = view.findViewById(R.id.button_camera);
        button_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScanQRCode();
            }
        });
        return  view;
    }

    private void ScanQRCode()
    {
        IntentIntegrator intel = new IntentIntegrator(getActivity());
        intel.setPrompt("QRCode");
        intel.setOrientationLocked(true);
        intel.setCameraId(0);  // Use a specific camera of the device
        intel.setBeepEnabled(true);
        intel.setBarcodeImageEnabled(true);
        intel.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result  = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null)
        {
            if(result.getContents()!="")
            {
                tvText.setText(result.getContents());
            }
        }
    }



}