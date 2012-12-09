package com.elaundrysearch.ui;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String NAMESPACE = "http://tempuri.org/";
	private static String URL;
	private static String METHOD_NAME;
	private Button loginButton;
	private EditText passText;
	private TextView textview;
	private EditText userIdText;

	// Your Facebook APP ID
    private static String APP_ID = "130693343753389"; // Replace your App ID here
 
    // Instance of Facebook Class
    private Facebook facebook;
    private AsyncFacebookRunner mAsyncRunner;
    String FILENAME = "AndroidSSO_data";
    private SharedPreferences mPrefs;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
		/*StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 		
*/		setContentView(R.layout.activity_main);
	facebook = new Facebook(APP_ID);
	mAsyncRunner = new AsyncFacebookRunner(facebook);
		loginButton = (Button) findViewById(R.id.button01);
		// downloadButton = (Button)findViewById(R.id.Button02);

		userIdText = (EditText) findViewById(R.id.loginEmail);
		passText = (EditText) findViewById(R.id.loginPassword);
		

		loginButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				String result = login();
				
			}

		});
		Button btnFbLogin = (Button) findViewById(R.id.fbLogin);
		btnFbLogin.setOnClickListener(new View.OnClickListener() {
		   // @Override
		    public void onClick(View v) {
		           // loginToFacebook();
		    	String url = "http://www.facebook.com";
		    			Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  
		    					Uri.parse(url));
		    	startActivity(intent);
		        }
		});
    }

    public void loginToFacebook() {
        mPrefs = getPreferences(MODE_PRIVATE);
        String access_token = mPrefs.getString("access_token", null);
        long expires = mPrefs.getLong("access_expires", 0);
     
        if (access_token != null) {
            facebook.setAccessToken(access_token);
        }
     
        if (expires != 0) {
            facebook.setAccessExpires(expires);
        }
     
        if (!facebook.isSessionValid()) {
            facebook.authorize(this,
                    new String[] { "email", "publish_stream" },
                    new DialogListener() {
     
                       //@Override
                        public void onComplete(Bundle values) {
                            // Function to handle complete event
                            // Edit Preferences and update facebook acess_token
                            SharedPreferences.Editor editor = mPrefs.edit();
                            editor.putString("access_token",
                                    facebook.getAccessToken());
                            editor.putLong("access_expires",
                                    facebook.getAccessExpires());
                            editor.commit();
                        }

						public void onFacebookError(FacebookError e) {
							// TODO Auto-generated method stub
							
						}

						public void onError(DialogError e) {
							// TODO Auto-generated method stub
							
						}

						public void onCancel() {
							// TODO Auto-generated method stub
							
						}
                    });
        }
    }

    public String login() {
    	String user = userIdText.getText().toString();
		String pass = passText.getText().toString();
		new callWS().execute(user,pass);
		return "";
	}	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void showDialog(String mess)
	{
		new AlertDialog.Builder(MainActivity.this).setTitle("Message")
		.setMessage(mess)
		.setNegativeButton("OK", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which)
			{

			}

		})
		.show();
	}
	class callWS extends AsyncTask<String, String, Boolean> {
		private ProgressDialog dialog;
		private Context context;
		private Boolean result =false;
		
		@Override
	    protected void onProgressUpdate(String... progress) {
	         //setProgressPercent(progress[0]);
	    	 dialog = new ProgressDialog(MainActivity.this);
				dialog.setMessage(progress[0]);
				dialog.show();	
	     }

	     
	    @Override
		protected void onPostExecute(Boolean result) {
	    	if(dialog!=null && dialog.isShowing()){
	    		dialog.dismiss();
	    	}
		    	 if(result){
						Intent intent = new Intent(MainActivity.this,
								CustomerHome.class);
						intent.putExtra("name", "John");
						startActivity(intent);
					}
		    	 else{
		    		 dialog=new ProgressDialog(MainActivity.this);
		    		 showDialog("Login Failed");
		    		 if(dialog!=null && dialog.isShowing()){
		 	    		dialog.dismiss();
		 	    	}
		    	 }
		}



		@Override
		protected Boolean doInBackground(String... arg0) {
			
			publishProgress("Connecting..");
			// ***The URL of webservice, 10.0.2.2 is the alias name of pc in android
			// phone, so please replace this with "localhost", and the rest remain
			// the same***//
			MainActivity.URL = "http://170.224.167.239/aspnet_client/eLaundryWebServices/LoginService.asmx";
			//"http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx"
			//http://localhost/aspnet_client/eLaundryWebServices/LoginService.asmx/validateCustomerLogin
			MainActivity.METHOD_NAME = "validateLogin"; // This is the name
																// forupload
																// function defined
																// in webservice

			
			// ***** transport
			
			HttpTransportSE transport = new HttpTransportSE(URL);
			transport.debug = true;

			// *********** soapobject
			SoapObject soapObject = new SoapObject(MainActivity.NAMESPACE,
					MainActivity.METHOD_NAME);
//			showDialog(arg0[0]+", "+arg0[1]);
			soapObject.addProperty("username", arg0[0]);
			soapObject.addProperty("password", arg0[1]);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;

			envelope.bodyOut = soapObject;// transport;
			String response = null;

			try {

				transport.call("http://tempuri.org/validateLogin", envelope);
				
				response = envelope.getResponse().toString();
				publishProgress("Validating Login...");	
				Thread.sleep(1000);
			} catch (Exception ex) {
				ex.printStackTrace();
				showDialog("Login Failed"+ex);
			}
			if(response!=null && response.equals("false")){
				//showDialog("Login Failed");
			}
			result = Boolean.valueOf(response);
			return result;
		}
	 }
}

