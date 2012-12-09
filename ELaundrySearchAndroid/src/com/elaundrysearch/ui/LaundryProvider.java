package com.elaundrysearch.ui;

import android.os.Parcel;
import android.os.Parcelable;

public class LaundryProvider implements Parcelable{
	
	private String providerId;
	private String providerName;
	private String street;
	private String city;
	private String distance;
	private String email;
	
	private String mobilenumber;
	
	private String priceRegular;
	private String priceDry;
	private String priceWoolen;
	
	
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPriceRegular() {
		return priceRegular;
	}
	public void setPriceRegular(String priceRegular) {
		this.priceRegular = priceRegular;
	}
	public String getPriceDry() {
		return priceDry;
	}
	public void setPriceDry(String priceDry) {
		this.priceDry = priceDry;
	}
	public String getPriceWoolen() {
		return priceWoolen;
	}
	public void setPriceWoolen(String priceWoolen) {
		this.priceWoolen = priceWoolen;
	}
	//	@Override
	 public int describeContents() {

	  return hashCode();

	 }

	 

//	 @Override
	 public void writeToParcel(Parcel dest, int flags) {

	  dest.writeString(providerId);

	  dest.writeString(providerName);

	  dest.writeString(street);

	  dest.writeString(distance);
	  dest.writeString(mobilenumber);
	  dest.writeString(email);

	 }

	 

	 // We reconstruct the object reading from the Parcel data

	 public LaundryProvider(Parcel p) {

	  providerId = p.readString();

	  providerName = p.readString();

	  street = p.readString();

	  distance = p.readString();
	  mobilenumber = p.readString();
	  email=p.readString();
	 }

	 

	 public LaundryProvider() {}

	 

	 // We need to add a Creator

	 public static final Parcelable.Creator<LaundryProvider> CREATOR = new Parcelable.Creator<LaundryProvider>() {




	  public LaundryProvider createFromParcel(Parcel parcel) {   

	   return new LaundryProvider(parcel);

	  }




	  public LaundryProvider[] newArray(int size) {   

	   return new LaundryProvider[size];

	  }

	  
}
;
}
