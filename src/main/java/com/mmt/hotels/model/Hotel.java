package com.mmt.hotels.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "hoteldetails")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotels_seq")
	@GenericGenerator(name = "hotels_seq", strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Hotel_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String hotelId;
	@NotEmpty(message = "Hotel Name should not be empty")
	private String hotelName;
	@NotEmpty(message = "Hotel Brand should not be empty")
	private String hotelBrand;
	
	@Max(value = 210000)
	@Min(value = 0)
	@NotNull(message = "Price Of AC rooms should not be empty max val = 210000, min val = 2500")
	private float priceAcRoom;
	
	@Max(value = 2100)
	@Min(value = 0)
	@NotNull(message = "Price Of NON-AC rooms should not be empty max val = 2100, min val = 250")
	private float priceNonAcRoom;
	@NotEmpty(message = "Hotel City should not be empty")
	private String hotelCity;
	
	@Max(value = 420)
	@Min(value = 0)
	@NotNull(message = "No. Of AC rooms should not be empty")
	private int noOfAcRooms;
	
	@Max(value = 210)
	@Min(value = 0)
	@NotNull(message = "No. Of NON-AC rooms should not be empty")
	private int noOfNonAcRooms;

	private int noOfAvilableAcRoom;

	private int noOfAvilableNonAcRoom;
	
	private Boolean isAc;
	
	public Boolean getIsAc() {
		return isAc;
	}

	public void setIsAc(Boolean isAc) {
		this.isAc = isAc;
	}
	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelBrand() {
		return hotelBrand;
	}

	public void setHotelBrand(String hotelBrand) {
		this.hotelBrand = hotelBrand;
	}

	public int getNoOfAvilableAcRoom() {
		return noOfAvilableAcRoom;
	}

	public void setNoOfAvilableAcRoom(int noOfAvilableAcRoom) {
		this.noOfAvilableAcRoom = noOfAvilableAcRoom;
	}

	public int getNoOfAvilableNonAcRoom() {
		return noOfAvilableNonAcRoom;
	}

	public void setNoOfAvilableNonAcRoom(int noOfAvilableNonAcRoom) {
		this.noOfAvilableNonAcRoom = noOfAvilableNonAcRoom;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public float getPriceAcRoom() {
		return priceAcRoom;
	}

	public void setPriceAcRoom(float priceAcRoom) {
		this.priceAcRoom = priceAcRoom;
	}

	public float getPriceNonAcRoom() {
		return priceNonAcRoom;
	}

	public void setPriceNonAcRoom(float priceNonAcRoom) {
		this.priceNonAcRoom = priceNonAcRoom;
	}

	public int getNoOfAcRooms() {
		return noOfAcRooms;
	}

	public void setNoOfAcRooms(int noOfAcRooms) {
		this.noOfAcRooms = noOfAcRooms;
	}

	public int getNoOfNonAcRooms() {
		return noOfNonAcRooms;
	}

	public void setNoOfNonAcRooms(int noOfNonAcRooms) {
		this.noOfNonAcRooms = noOfNonAcRooms;
	}
}