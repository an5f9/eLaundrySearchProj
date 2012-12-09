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

public class CustEditDetails extends Activity {
	private static final String NAMESPACE = "http://tempuri.org/";
	private static String URL;
	private static String METHOD_NAME;
	
	private String name;
	private String email;
	private String mobilenumber;
	private String apartment;
	private String street;
	private String city;
	private String state;
	private String country;
	private int  zipcode;
	private Button edit;
	public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.cust_edit_details);
    	
    	edit = (Button) findViewById(R.id.btnEdit);
        edit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				updatecustomerdetails();
				
				
			}
			});
	}
        public String updatecustomerdetails() {
        	
    		// ***The URL of webservice, 10.0.2.2 is the alias name of pc in android
    		// phone, so please replace this with "localhost", and the rest remain
    		// the same***//
    		CustEditDetails.URL = "http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx";
    		//"http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx"
    		//http://localhost/aspnet_client/eLaundryWebServices/LoginService.asmx/validateCustomerLogin
    		CustEditDetails.METHOD_NAME = "UpdateCustomerDetails"; // This is the name
    															// forupload
    															// function defined
    															// in webservice

    		name = ((EditText)findViewById(R.id.name)).getText().toString();
    		email= ((EditText)findViewById(R.id.email)).getText().toString();
    		mobilenumber= ((EditText)findViewById(R.id.mobilenumber)).getText().toString();
    	    apartment = ((EditText)findViewById(R.id.apartment)).getText().toString();
    		street = ((EditText)findViewById(R.id.street)).getText().toString();
    		city = ((EditText)findViewById(R.id.city)).getText().toString();
    		state = ((EditText)findViewById(R.id.state)).getText().toString();
    		country = ((EditText)findViewById(R.id.country)).getText().toString();
    		zipcode=Integer.parseInt(((EditText)findViewById(R.id.zipcode)).getText().toString());
    		
    		
    		
    		// ***** transport
    		
    		HttpTransportSE transport = new HttpTransportSE(URL);
    		transport.debug = true;

    		// *********** soapobject
    		SoapObject soapObject = new SoapObject(CustEditDetails.NAMESPACE,
    				CustEditDetails.METHOD_NAME);
    		
    		//soapObject.addProperty("Name", );
    		soapObject.addProperty("Email","email");
    		soapObject.addProperty("Mobilenumber","mobilenumber");
    		soapObject.addProperty("Apartment", "apartment");
    		soapObject.addProperty("Street", "street");
    		soapObject.addProperty("City", "city");
    		soapObject.addProperty("State", "state");
    		soapObject.addProperty("Country", "country");
    		soapObject.addProperty("Zipcode", "zipcode");
    		
    		
    		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
    				SoapEnvelope.VER11);
    		envelope.dotNet = true;

    		envelope.bodyOut = soapObject;// transport;
    		String response = null;

    		try {

    			transport.call("http://tempuri.org/UpdateCustomerDetails", envelope);
    			
    			response = envelope.getResponse().toString();
    			
    					
    		} catch (Exception ex) {
    			ex.printStackTrace();
    			
    		}
    	return null;	
    	}

    	@Override
    	public boolean onCreateOptionsMenu(Menu menu) {
//    		getMenuInflater().inflate(R.menu.activity_main, menu);
    		return true;
    	}

    	private void showDialog(String mess)

    	{

    		new AlertDialog.Builder(CustEditDetails.this).setTitle("Message")

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


