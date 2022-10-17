package com.mmt.user.services;

import java.util.List;

import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.bookedHotel.model.BookedHotel;

import com.mmt.user.model.User;

public interface UserServiceInterface {
	public String userName(String email, String password);

	public List<User> allUsers();

	public User createuser(User user);

	public User userLogin(User user);

	public boolean userLogout();

	public boolean deleteUser(String userId);

	public User updateUser(User user, String userId);

	public List<User> userByNoOfBookings();

	public User viewUser(String userId);

	public BookedFlight viewLastFlightBooking(String bookingId);

	public BookedHotel viewLastHotelBooking(String bookingId);

	public boolean updateBookingFlight(BookedFlight booking);

	public List<BookedHotel> allBookedHotels(String userId);

	public List<BookedFlight> allBookedFlight(String userId);
}
