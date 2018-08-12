# BarcodeScanner

Barcode scanning library for Android, using ZXing for decoding.

The project is loosely based on the ZXing Android Barcode Scanner application.

Features:

Can be used via Intents (little code required).
Can be embedded in an Activity, for advanced customization of UI and logic.
Scanning can be performed in portrait mode.
Camera is managed in a background thread, for fast startup time.




 


Launch the intent with the default options:

Intent intent = new Intent(this, ScannerActivity.class);
intent.setAction("com.google.zxing.client.android.SCAN");
intent.putExtra("SAVE_HISTORY", false);
startActivityForResult(intent, 0);


// Get the results:

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
