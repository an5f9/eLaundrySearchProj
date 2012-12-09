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

public class ChangePassword extends Activity {
	private static final String NAMESPACE = "http://tempuri.org/";
	private static String URL;
	private static String METHOD_NAME;
	
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	
	private Button submit;
	public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.change_password);
    	
    	submit = (Button) findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				 changePassword();
				
				
			}
				
        });

	}
public String changePassword() {
    	
		// ***The URL of webservice, 10.0.2.2 is the alias name of pc in android
		// phone, so please replace this with "localhost", and the rest remain
		// the same***//
		ChangePassword.URL = "http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx";
		//"http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx"
		//http://localhost/aspnet_client/eLaundryWebServices/LoginService.asmx/validateCustomerLogin
		ChangePassword.METHOD_NAME = "changePassword"; // This is the name
															// forupload
															// function defined
															// in webservice

		oldPassword = ((EditText)findViewById(R.id.oldpwd)).getText().toString();
		newPassword = ((EditText)findViewById(R.id.newpwd)).getText().toString();
		confirmPassword= ((EditText)findViewById(R.id.reenterpwd)).getText().toString();
		if(!newPassword.equals(confirmPassword))
		{
			showDialog("Both passwords do not match");
		}
		
	
		
		// ***** transport
		
		HttpTransportSE transport = new HttpTransportSE(URL);
		transport.debug = true;

		// *********** soapobject
		SoapObject soapObject = new SoapObject(ChangePassword.NAMESPACE,
				ChangePassword.METHOD_NAME);
		
		soapObject.addProperty("username", "test5");
		soapObject.addProperty("password",newPassword);
		soapObject.addProperty("oldPassword",oldPassword);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.bodyOut = soapObject;// transport;
		String response = null;

		try {

			transport.call("http://tempuri.org/changePassword", envelope);
			
			response = envelope.getResponse().toString();
			
					
		} catch (Exception ex) {
			ex.printStackTrace();
			showDialog("Change Failed");
		}
		if(response==null || response.equals("-1")){
			showDialog("Change Fail ");
		}
		else{
			showDialog("Password change successful. ");
		}
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void showDialog(String mess)

	{

		new AlertDialog.Builder(ChangePassword.this).setTitle("Message")

		.setMessage(mess)

		.setNegativeButton("OK", new DialogInterface.OnClickListener()

		{

			public void onClick(DialogInterface dialog, int which)

			{

			}

		})

		.show();
	}

}



