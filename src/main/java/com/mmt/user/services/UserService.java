package com.mmt.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mmt.bookedFlight.dao.BookedFlightDao;
import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.bookedHotel.dao.BookedHotelDao;
import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.user.dao.UserDao;
import com.mmt.user.model.User;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserDao ud;

	@Autowired
	private BookedFlightDao bfd;

	@Autowired
	private BookedHotelDao bhd;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public List<User> allUsers() {
		return ud.findAll();
	}

	@Override
	public User createuser(User user) {
		String email = user.getMailID();
		if (ud.existsByMailID(email))
			return null;
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return ud.save(user);
	}

	@Override
	public User userLogin(User user) {
		User existUser = ud.findByMailIDAndPassword(user.getMailID(), user.getPassword());
		if (existUser == null)
			return null;
		return existUser;
	}

	@Override
	public boolean userLogout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String userId) {
		User existUser = ud.findById(userId).get();
		if (existUser == null)
			return false;
		ud.deleteById(userId);
		return true;
	}

	@Override
	public User updateUser(User user, String userId) {

		User existUser = ud.findById(userId).get();
		if (user.getFirstName().isBlank()) {
			user.setFirstName(existUser.getFirstName());
		}
		if (user.getMiddleName().isBlank()) {
			user.setMiddleName(existUser.getMiddleName());
		}
		if (user.getMobileNumber().isBlank()) {
			user.setMobileNumber(existUser.getMobileNumber());
		}
		if (user.getLastName().isBlank()) {
			user.setLastName(existUser.getLastName());
		}
		if (user.getMailID().isBlank()) {
			user.setMailID(existUser.getMailID());
		}
		if (user.getPassword().isBlank()) {
			user.setPassword(existUser.getPassword());
		}
		user.setUserId(userId);
		return ud.save(user);
		
	}

	@Override
	public List<User> userByNoOfBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User viewUser(String userId) {

		return ud.findById(userId).get();
	}

	@Override
	public BookedFlight viewLastFlightBooking(String bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookedHotel viewLastHotelBooking(String bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBookingFlight(BookedFlight booking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BookedHotel> allBookedHotels(String userId) {

		User user = ud.findById(userId).get();
		return bhd.findByUser(user);
	}

	@Override
	public List<BookedFlight> allBookedFlight(String userId) {
		User user = ud.findById(userId).get();
		return bfd.findByUser(user);
	}

	@Override
	public String userName(String email, String password) {
		User user = ud.findByMailIDAndPassword(email, password);
		return user.getUserId();
	}

}