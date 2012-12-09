package com.elaundrysearch.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LaundrySearchResults  extends ListActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayList<LaundryProvider> laundryProvidersList = getIntent().getParcelableArrayListExtra("searchResultList");
		setListAdapter(new LaundryProviderArrAdaptor(this, laundryProvidersList));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		//get selected items
		LaundryProvider selectedValue = (LaundryProvider) getListAdapter().getItem(position);
		//Toast.makeText(this, selectedValue.getProviderName(), Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(LaundrySearchResults.this,
				ViewLaundryDetails.class);
		intent.putExtra("searchResultList", selectedValue);
		startActivity(intent);
	}

}
