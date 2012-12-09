package com.elaundrysearch.ui;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CustMyAccount extends Activity {
	private Button change;
	private static final String NAMESPACE = "http://tempuri.org/";
	private static String URL;
	private static String METHOD_NAME;
	private static String oldPassword;
	private static String newPassword;
	private static String confirmNewPassword;
	private static String user;
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_account);
		change = (Button) findViewById(R.id.changepwd);
		change.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
					Intent intent = new Intent(CustMyAccount.this,
							ChangePassword.class);
					intent.putExtra("name", "Abhishek");
					startActivity(intent);
			}

		});
        
    }

    }
