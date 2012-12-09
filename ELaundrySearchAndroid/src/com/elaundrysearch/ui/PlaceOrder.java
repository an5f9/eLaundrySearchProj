package com.elaundrysearch.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class PlaceOrder extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.order_form);
		
		Button placeOrderSbmtButton = (Button)findViewById(R.id.orderFrmSubmitButton);
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.mArrayList,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		placeOrderSbmtButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Intent intent = new Intent(PlaceOrder.this,
					//	OrderSuccess.class);
			//	intent.putExtra("name", "Abhishek");
				//startActivity(intent);
				showDialog("Order Placed. You will receive email confirmation shortly.");
				
			}

		});
		
		
    }
    private void showDialog(String mess)
	{
    	AlertDialog.Builder builder = new AlertDialog.Builder(PlaceOrder.this);
    	builder.setMessage("Confirm Order")
        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	Intent intent = new Intent(PlaceOrder.this,
						CustomerHome.class);
				intent.putExtra("name", "Abhishek");
				showDialogConfrm("");
				startActivity(intent);
            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
    	builder.show();
    	/*
    	new AlertDialog.Builder(PlaceOrder.this).setTitle("Message")
		.setMessage(mess)
		.setNegativeButton("OK", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which)
			{

			}

		})
		.show();*/
	}
    private void showDialogConfrm(String mess)
	{
    	
    	
    	new AlertDialog.Builder(PlaceOrder.this).setTitle("Message")
		.setMessage("Order Placed Succesfully. You will receive email confirmation shortly")
		.setNegativeButton("OK", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which)
			{

			}

		})
		.show();
	}

}
