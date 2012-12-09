package com.elaundrysearch.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewLaundryDetails extends Activity {
	private static final String NAMESPACE = "http://tempuri.org/";
	private static String URL;
	private static String METHOD_NAME;
	private Button loginButton;
	private EditText passText;
	private TextView textview;
	private EditText userIdText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.view_laundry_details);
		
		Button placeOrderButton = (Button)findViewById(R.id.placeOrder);
		Button viewMapButton = (Button)findViewById(R.id.viewMapButton);
		TextView laundryName = (TextView) findViewById(R.id.laundryName);
		
		LaundryProvider pr= (LaundryProvider) getIntent().getExtras().get("searchResultList");
		if(pr!=null){
			laundryName.setText(pr.getProviderName());
			if(pr.getEmail()!=null || pr.getEmail()!="")	((TextView) findViewById(R.id.contact_email)).setText(pr.getEmail());
		if(pr.getMobilenumber()!=null || pr.getMobilenumber()!="")	((TextView) findViewById(R.id.contact_phone)).setText(pr.getMobilenumber());
			((TextView) findViewById(R.id.address_street)).setText(pr.getStreet());
		}
		placeOrderButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ViewLaundryDetails.this,
						PlaceOrder.class);
				intent.putExtra("name", "Abhishek");
				startActivity(intent);
			}

		});
		Button viewMap = (Button)findViewById(R.id.viewMapButton);
		viewMap.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String url = "http://maps.google.com/maps?saddr=Harrison+Street&daddr=Rockhillroad";
						Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
						startActivity(intent);
			}
		});
    }
    

}
