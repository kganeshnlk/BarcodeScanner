package com.barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.scanner.ScannerActivity;

public class BarcodeScanActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvScan;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scan);
        initView();
    }

    private void initView() {
        tvScan = findViewById(R.id.tv_scan);
        tvResult = findViewById(R.id.tv_result);
        tvScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ScannerActivity.class);
        intent.setAction("com.google.zxing.client.android.SCAN");
        intent.putExtra("SAVE_HISTORY", false);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK && data != null) {
                String number = !TextUtils.isEmpty(data.getStringExtra("number")) ? data.getStringExtra("number") : "";
                tvResult.setText(number);
            } else {
                onBackPressed();
                Log.d("Scan", "RESULT_CANCELED");
            }
        }
    }
}
