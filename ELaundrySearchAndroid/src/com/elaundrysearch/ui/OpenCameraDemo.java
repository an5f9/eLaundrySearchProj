package com.elaundrysearch.ui;
 
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
 
public class OpenCameraDemo extends Activity {
 
    private static final int CAMERA_PIC_REQUEST = 2500;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_camera_demo);
 
        Button b = (Button)findViewById(R.id.Button01);
        b.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                 startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });
    }
 
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
              Bitmap image = (Bitmap) data.getExtras().get("data");
              ImageView imageview = (ImageView) findViewById(R.id.ImageView01);
              imageview.setImageBitmap(image);
              try{
            	  Thread.sleep(3000);}catch (Exception e) {
				// TODO: handle exception
			}
        
    }
        
        
}
}