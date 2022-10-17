package com.mmt.bookedHotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mmt.hotels.model.Hotel;
import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;
import com.mmt.user.model.User;

@Entity
@Table(name = "bookedhotels")
public class BookedHotel {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "bookedHotel_seq")
	@GenericGenerator(name="bookedHotel_seq",strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator",
	            parameters = {
	                    @Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
	                    @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="bookedHotel_"),
	                    @Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")})
	private String bookedHotelId;
	private int noOfRooms;
	private boolean isAc;
	private float price;
	private String type;
	@OneToOne(orphanRemoval = true)
	private Hotel hotel;
	@JsonBackReference
	@ManyToOne
	private User user;
	public String getBookedHotelId() {
		return bookedHotelId;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public boolean isAc() {
		return isAc;
	}
	public void setAc(boolean isAc) {
		this.isAc = isAc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setBookedHotelId(String bookedHotelId) {
		this.bookedHotelId = bookedHotelId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
}