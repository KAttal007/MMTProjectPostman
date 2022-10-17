package com.mmt.user.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "userdetails")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@GenericGenerator(name = "users_seq", strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "User_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String userId;
	@NotEmpty(message = "First Name is mandatory")
	private String firstName;
	//@NotEmpty(message = "Middle Name is mandatory")
	private String middleName;
	@NotEmpty(message = "Last Name is mandatory")
	private String lastName;
	@Pattern(regexp="^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$")
	@NotEmpty(message = "Phone Number is Mandatory")
	private String mobileNumber;
	@Email(message = "Email is mandatory, and please enter a correctly formatted email.")
	@NotEmpty
	private String mailID;
	//@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	@NotEmpty(message = "Password must contain Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character")
	private String password;

	@JsonManagedReference
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL, orphanRemoval = true)
	private List<BookedHotel> hotelBooking = new ArrayList<>();
	@JsonManagedReference
	@OneToMany(mappedBy = "user",  cascade=CascadeType.ALL ,orphanRemoval = true)
	private List<BookedFlight> flightBooking = new ArrayList<>();
	
//	private String username;
//	private String jwtpassword;
//
//	public User() {
//		super();
//	}
//	public User(String username, String jwtpassword) {
//		super();
//		this.username = username;
//		this.jwtpassword = jwtpassword;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getJwtpassword() {
//		return jwtpassword;
//	}
//	public void setJwtpassword(String jwtpassword) {
//		this.jwtpassword = jwtpassword;
//	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<BookedHotel> getHotelBooking() {
		return hotelBooking;
	}
	public void setHotelBooking(List<BookedHotel> hotelBooking) {
		this.hotelBooking = hotelBooking;
	}
	public List<BookedFlight> getFlightBooking() {
		return flightBooking;
	}
	public void setFlightBooking(List<BookedFlight> flightBooking) {
		this.flightBooking = flightBooking;
	}

	

	
	
}
