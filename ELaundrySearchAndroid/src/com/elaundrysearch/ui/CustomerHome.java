package com.elaundrysearch.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomerHome extends Activity {

	private TextView welcomeText;
	private static final String NAMESPACE = "http://tempuri.org/";
	private static String URL;
	private static String METHOD_NAME;
	private Button quickSearchButton;
	private Button gpsSearchButton;
	private EditText streetTextBox;
	private TextView cityTextBox;
	private Button searchButton;
	private Button myAccountButton;
	private Button logOutButton;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/*
		 * StrictMode.ThreadPolicy policy = new
		 * StrictMode.ThreadPolicy.Builder().permitAll().build();
		 * 
		 * StrictMode.setThreadPolicy(policy);
		 */setContentView(R.layout.customer_home);
		String name = getIntent().getExtras().get("name").toString();

		welcomeText = (TextView) findViewById(R.id.welcomeName);
		welcomeText.setText("Welcome " + name);

		// Quick search action

		quickSearchButton = (Button) findViewById(R.id.list_item_button);
		gpsSearchButton = (Button) findViewById(R.id.gpsSearch);
		searchButton=(Button)findViewById(R.id.searchButton);
		myAccountButton=(Button)findViewById(R.id.accountButton);
		logOutButton = (Button)findViewById(R.id.logOutButton);
		logOutButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(CustomerHome.this,
						MainActivity.class);
				startActivity(intent);
			}
		});
		gpsSearchButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				GPSTracker gps = new GPSTracker(CustomerHome.this);
				double lat = 0.0;
				double longit = 0.0;
				if (gps.canGetLocation()) {
					lat = gps.getLatitude(); // returns latitude
					longit = gps.getLongitude(); // returns longitude
				} else {
					gps.showSettingsAlert();
				}
				if (lat == 0 && longit == 0) {
					return;
				}
				//showDialog(lat+"," +longit);
				new callWSForSearch().execute(lat,longit);

			}
		});
		myAccountButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(CustomerHome.this,
						CustMyAccount.class);
				intent.putExtra("name", "Prathyusha");
				startActivity(intent);

				
			}
		});
		quickSearchButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// "http://localhost/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx/searchLaundryProvidersbyAddr";

				try {
					CustomerHome.URL = "http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx";

					// "http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx"
					// http://localhost/aspnet_client/eLaundryWebServices/LoginService.asmx/validateCustomerLogin
					CustomerHome.METHOD_NAME = "searchLaundryProvidersbyAddr"; // This
																				// is
																				// the
																				// name
																				// forupload
																				// function
																				// defined
																				// in
																				// webservice
					String street = ((EditText) findViewById(R.id.street))
							.getText().toString();
					String city = ((EditText) findViewById(R.id.city))
							.getText().toString();
					HttpTransportSE transport = new HttpTransportSE(URL);
					transport.debug = true;

					// *********** soapobject
					SoapObject soapObject = new SoapObject(
							CustomerHome.NAMESPACE, CustomerHome.METHOD_NAME);
					// ***** transport

					transport = new HttpTransportSE(URL);
					transport.debug = true;

					// *********** soapobject
					soapObject = new SoapObject(CustomerHome.NAMESPACE,
							CustomerHome.METHOD_NAME);

					soapObject.addProperty("street", street);
					soapObject.addProperty("city", city);

					SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
							SoapEnvelope.VER11);
					envelope.dotNet = true;

					envelope.bodyOut = soapObject;// transport;
					String response = null;

					transport.call(
							"http://tempuri.org/searchLaundryProvidersbyAddr",
							envelope);

					SoapObject so_rsp = (SoapObject) envelope.getResponse();

					ArrayList<LaundryProvider> arr = mapSoapRespToLaundryProvider(so_rsp);
					Intent intent = new Intent(CustomerHome.this,
							LaundrySearchResults.class);
					/*
					 * intent.putExtra("ProviderId",
					 * ((SoapObject)so_rsp.getProperty
					 * (0)).getProperty("ProviderId").toString());
					 * intent.putExtra("Name",
					 * ((SoapObject)so_rsp.getProperty(0)
					 * ).getProperty("Name").toString());
					 * intent.putExtra("Address.Street",
					 * ((SoapObject)((SoapObject
					 * )so_rsp.getProperty(0)).getProperty
					 * ("Address")).getProperty("Street").toString());
					 * intent.putExtra("Address.City",
					 * ((SoapObject)((SoapObject)
					 * so_rsp.getProperty(0)).getProperty
					 * ("Address")).getProperty("City").toString());
					 */
					intent.putParcelableArrayListExtra("searchResultList", arr);
					
					if(arr.size() !=0){
						startActivity(intent);
						}else{
							showDialog("No Results For the search");
						}	
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

	}

	class callWSForSearch extends AsyncTask<Double, String,SoapObject> {

		private ProgressDialog dialog;
		private Context context;
		private Boolean result = false;

		@Override
		protected void onProgressUpdate(String... progress) {
			// setProgressPercent(progress[0]);
			dialog = new ProgressDialog(CustomerHome.this);
			dialog.setMessage(progress[0]);
			dialog.show();
		}

		@Override
		protected void onPostExecute(SoapObject result) {
			if (dialog != null && dialog.isShowing()) {
				dialog.dismiss();
			}
			
				Intent intent = new Intent(CustomerHome.this,
						LaundrySearchResults.class);
				/*
				 * intent.putExtra("ProviderId",
				 * ((SoapObject)so_rsp.getProperty(
				 * 0)).getProperty("ProviderId").toString());
				 * intent.putExtra("Name",
				 * ((SoapObject)so_rsp.getProperty(0)).getProperty
				 * ("Name").toString()); intent.putExtra("Address.Street",
				 * ((SoapObject
				 * )((SoapObject)so_rsp.getProperty(0)).getProperty("Address"
				 * )).getProperty("Street").toString());
				 * intent.putExtra("Address.City",
				 * ((SoapObject)((SoapObject)so_rsp
				 * .getProperty(0)).getProperty("Address"
				 * )).getProperty("City").toString());
				 */
				ArrayList<LaundryProvider> arr = mapSoapRespToLaundryProvider(result);
				intent.putParcelableArrayListExtra("searchResultList", arr);
				// intent.put
				if(arr.size() !=0){
					startActivity(intent);
					}else{
						showDialog("No Results For the search.");
					}	
				//startActivity(intent);
		}
			 /*else {
				dialog = new ProgressDialog(CustomerHome.this);
				showDialog("Login Failed");
				if (dialog != null && dialog.isShowing()) {
					dialog.dismiss();
				}*/
		

		@Override
		protected SoapObject doInBackground(Double... arg0) {

			

			try {
				CustomerHome.URL = "http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx";

				// "http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx"
				// http://localhost/aspnet_client/eLaundryWebServices/LoginService.asmx/validateCustomerLogin
				CustomerHome.METHOD_NAME = "SearchLaundryProviders"; 
				HttpTransportSE transport = new HttpTransportSE(URL);
				transport.debug = true;

				// *********** soapobject
				SoapObject soapObject = new SoapObject(CustomerHome.NAMESPACE,
						CustomerHome.METHOD_NAME);
				// ***** transport

				transport = new HttpTransportSE(URL);
				transport.debug = true;

				// *********** soapobject
				soapObject = new SoapObject(CustomerHome.NAMESPACE,
						CustomerHome.METHOD_NAME);

				soapObject.addProperty("latitude", arg0[0].toString());
				soapObject.addProperty("longitude", arg0[1].toString());

				String address = ConvertPointToLocation(arg0[0],arg0[1]);
				//showDialog("address: " + address);
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
						SoapEnvelope.VER11);
				envelope.dotNet = true;

				envelope.bodyOut = soapObject;// transport;
				String response = null;

				transport.call("http://tempuri.org/SearchLaundryProviders",
						envelope);

				SoapObject so_rsp = (SoapObject) envelope.getResponse();

				
				return so_rsp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}


	public String ConvertPointToLocation(double lat, double lng) {
		String address = "";
		Geocoder geoCoder = new Geocoder(getBaseContext(), Locale.getDefault());
		try {
			List<Address> addresses = geoCoder.getFromLocation(lat, lng, 1);

			if (addresses.size() > 0) {
				for (int index = 0; index < addresses.get(0)
						.getMaxAddressLineIndex(); index++)
					address += addresses.get(0).getAddressLine(index) + " ";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return address;
	}

	protected ArrayList<LaundryProvider> mapSoapRespToLaundryProvider(
			SoapObject soapObjParam) {
		if(soapObjParam==null){
			return null;
		}
		int resultCount = soapObjParam.getPropertyCount();

		ArrayList<LaundryProvider> laundryProviderArr = new ArrayList<LaundryProvider>();
		LaundryProvider eachLaundryProvider = null;
		for (int loopIndex = 0; loopIndex < resultCount; loopIndex++) {
			SoapObject eachSoapObj = (SoapObject) soapObjParam
					.getProperty(loopIndex);
			eachLaundryProvider = new LaundryProvider();
			eachLaundryProvider.setProviderId(eachSoapObj.getProperty(
					"ProviderId").toString());
			eachLaundryProvider.setProviderName(eachSoapObj.getProperty("Name")
					.toString());
			eachLaundryProvider.setStreet(((SoapObject) eachSoapObj
					.getProperty("Address")).getProperty("Street").toString());
			eachLaundryProvider.setDistance(
					eachSoapObj.getProperty("Distance")
					.toString());
			eachLaundryProvider.setEmail(
					eachSoapObj.getProperty("Email")
					.toString());
			eachLaundryProvider.setMobilenumber ( 
					eachSoapObj.getProperty("Mobilenumber")
					.toString());
			eachLaundryProvider.setPriceRegular( 
					eachSoapObj.getProperty("RegularPrice")
					.toString());
			eachLaundryProvider.setPriceDry(
					eachSoapObj.getProperty("DryCleanPrice")
					.toString());
			eachLaundryProvider.setPriceWoolen(
					eachSoapObj.getProperty("WoolenPrice")
					.toString());
			// TODO Add remaining properties and mapping
			laundryProviderArr.add(eachLaundryProvider);
		}

		return laundryProviderArr;
	}

	private void showDialog(String mess)

	{

		new AlertDialog.Builder(CustomerHome.this).setTitle("Message")

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
