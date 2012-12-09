package com.elaundrysearch.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Hex;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LaundryProviderArrAdaptorOld extends ArrayAdapter<LaundryProvider> {

	private final Context context;
	private final ArrayList<LaundryProvider> values;
	private static final String NAMESPACE = "http://tempuri.org/";
	private static String URL;
	private static String METHOD_NAME;
	int greenColor = android.graphics.Color.parseColor("#F2F1FC");
	int silverColor = android.graphics.Color.parseColor("#DEE0CA");
	private int[] colors = new int[] { greenColor, silverColor };
	public LaundryProviderArrAdaptorOld(Context context,
			ArrayList<LaundryProvider> values) {
		super(context, R.layout.laundry_search_results, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.laundry_search_results,
				parent, false);
		TextView name = (TextView) rowView.findViewById(R.id.label);
		TextView street = (TextView) rowView.findViewById(R.id.street);
		int colorPos = position % colors.length;
		rowView.setBackgroundColor(colors[colorPos]);
		name.setText(values.get(position).getProviderName());
		street.setText(values.get(position).getStreet());
		final ImageView imgViewer = (ImageView) rowView.findViewById(R.id.laundryImage);
		new callWSForSearch(){

			@Override
			protected void onPostExecute(Bitmap result) {
				imgViewer.setImageBitmap(result);
			}
		}.execute(position,rowView);

		return rowView;
	}
	
	protected byte[] fileToByteArr(){
		File f = new File("F:\\Snaps\\mike.jpg");
	    FileInputStream fin = null;
	    FileChannel ch = null;
	    byte[] bytes = null;
	    try {
	        fin = new FileInputStream(f);
	        ch = fin.getChannel();
	        int size = (int) ch.size();
	        MappedByteBuffer buf = ch.map(MapMode.READ_ONLY, 0, size);
	        bytes = new byte[size];
	        buf.get(bytes);

	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        try {
	            if (fin != null) {
	                fin.close();
	            }
	            if (ch != null) {
	                ch.close();
	            }
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	    return bytes;
	}

	class callWSForSearch extends AsyncTask<Object, String,Bitmap> {

		private ProgressDialog dialog;
		private Context context;
		private Boolean result = false;

		@Override
		protected void onProgressUpdate(String... progress) {
			
		}

		@Override
		protected Bitmap doInBackground(Object... arg0) {


				LaundryProviderArrAdaptorOld.URL = "http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx";

				// "http://170.224.167.239/aspnet_client/eLaundryWebServices/CustomerWebServices.asmx"
				// http://localhost/aspnet_client/eLaundryWebServices/LoginService.asmx/validateCustomerLogin
				LaundryProviderArrAdaptorOld.METHOD_NAME = "readImageFromDB"; // This is
																			// the name
				// forupload
				// function defined
				// in webservice
				HttpTransportSE transport = new HttpTransportSE(URL);
				transport.debug = true;

				// *********** soapobject
				SoapObject soapObject = new SoapObject(
						LaundryProviderArrAdaptorOld.NAMESPACE,
						LaundryProviderArrAdaptorOld.METHOD_NAME);
				// ***** transport

				soapObject.addProperty("providerId", values.get(Integer.parseInt(arg0[0].toString())).getProviderId());

				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
						SoapEnvelope.VER11);
				envelope.dotNet = true;

				envelope.bodyOut = soapObject;// transport;
				byte[] imgData = null;
				String rsp = null;
				try{
				transport.call("http://tempuri.org/readImageFromDB", envelope);
				rsp = envelope.getResponse().toString();
				}catch(Exception ex){}
				imgData = rsp.getBytes();
				/*if(imgData==null){
					imgData = Hex.decodeHex(rsp.toCharArray());
				}*/
				// byte[] chartData
				//View rowView = (View)arg0[1];
				
				
				imgData = Base64.decode(imgData, Base64.DEFAULT);
				Bitmap bmp = BitmapFactory.decodeByteArray(imgData, 0, imgData.length);
				return bmp;
				
	}

}

}
