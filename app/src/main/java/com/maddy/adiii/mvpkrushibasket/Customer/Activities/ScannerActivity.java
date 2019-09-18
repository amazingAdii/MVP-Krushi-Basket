package com.maddy.adiii.mvpkrushibasket.Customer.Activities;

import android.Manifest.permission;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.maddy.adiii.mvpkrushibasket.R;
import java.io.IOException;

public class ScannerActivity extends AppCompatActivity {
	
	private SurfaceView mCameraSurface;
	private SurfaceView mOnlyShowSurface;
	private CameraSource mCameraSource;
	private BarcodeDetector mBarcodeDetector;
	
	private final int MY_PERMISSIONS_REQUEST_CAMERA = 101;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scanner);
		
		mCameraSurface = (SurfaceView) findViewById(R.id.previewCamera);
		mOnlyShowSurface = (SurfaceView)findViewById(R.id.onlyShow);
		
		mBarcodeDetector = new BarcodeDetector.Builder(this)
		        .setBarcodeFormats(Barcode.DATA_MATRIX|Barcode.QR_CODE).build();
		
		mCameraSource = new CameraSource.Builder(this, mBarcodeDetector)
		        .setRequestedPreviewSize(640, 480)
		        .setAutoFocusEnabled(true)
		        .build();
		
		mOnlyShowSurface.getHolder().addCallback(new Callback() {
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				if (VERSION.SDK_INT >= VERSION_CODES.M) {
					if (checkSelfPermission(permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
						ActivityCompat.requestPermissions(ScannerActivity.this,
						        new String[]{permission.CAMERA},
						        MY_PERMISSIONS_REQUEST_CAMERA);
					} else {
						try {
							mCameraSource.start(holder);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
			
			}
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				mCameraSource.stop();
			}
		});
		
		mCameraSurface.getHolder().addCallback(new Callback() {
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				if (VERSION.SDK_INT >= VERSION_CODES.M) {
					if (checkSelfPermission(permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
						ActivityCompat.requestPermissions(ScannerActivity.this,
						        new String[]{permission.CAMERA},
						        MY_PERMISSIONS_REQUEST_CAMERA);
					} else {
						try {
							mCameraSource.start(holder);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
			
			}
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				mCameraSource.stop();
			}
		});
		
		mBarcodeDetector.setProcessor(new Processor<Barcode>() {
			@Override
			public void release() {
			
			}
			
			@Override
			public void receiveDetections(Detections<Barcode> detections) {
			
//				final SparseArray<Barcode> qrData = detections.getDetectedItems();
//
//				if(qrData.size() != 0){
//					mGetData.post(new Runnable() {
//						@Override
//						public void run() {
//							//mCameraSource.stop();
//							Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(
//							        Context.VIBRATOR_SERVICE);
//							vibrator.vibrate(100);
//							Log.d(TAG, "run: QR Value: "+qrData.valueAt(0).displayValue);
//							mGetData.setText(qrData.valueAt(0).displayValue );
//							show(qrData.valueAt(0).displayValue);
//						}
//					});
//				}
			
			}
		});
		
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
	        @NonNull int[] grantResults) {
		switch (requestCode) {
			case MY_PERMISSIONS_REQUEST_CAMERA: {
				// If request is cancelled, the result arrays are empty.
				if (grantResults.length > 0
				        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					// permission was granted, yay! Do the
					// contacts-related task you need to do.
					Intent i = new Intent(this, ScannerActivity.class);
					startActivity(i);
					finish();
				} else {
					// permission denied, boo! Disable the
					// functionality that depends on this permission.
				}
				return;
			}
		}
	}
	
}
