package com.scanner;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;

import com.scanner.camera.CameraManager;
import com.google.zxing.Result;

/*
 * Created by Ganesh K on 05-05-2018.
 */
public interface ScanListener {

    ViewfinderView getViewfinderView();

    void drawViewFinder();

    void handleDecode(Result rawResult, Bitmap barcode, float scaleFactor);

    void restartPreviewAfterDelay(long delay);

    CameraManager getCameraManager();

    Handler getHandler();

    void setScanResult(int resultCode, Intent data);

}
