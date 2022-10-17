package com.mmt.hotels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.bookedHotel.dao.BookedHotelDao;
import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.hotels.dao.HotelDao;
import com.mmt.hotels.model.Hotel;
import com.mmt.user.dao.UserDao;
import com.mmt.user.model.User;

@Service

public class HotelService implements HotelServiceInterface {

	@Autowired
	private HotelDao hd;

	@Autowired
	private BookedHotelDao bd;

	@Autowired
	private UserDao ud;

	@Override
	public List<Hotel> allHotels() {

		return hd.findAll();
	}

	@Override
	public List<Hotel> hotelAtDestinationCity(String city) {

		return hd.findByHotelCity(city);
	}

	@Override
	public List<Hotel> hotelAtDestinationCityAc(String city) {

		return hd.findByHotelCityAndIsAcTrue(city);
	}

	@Override
	public BookedHotel bookHotel(String hotelId, String userId, int noOfRooms, boolean isAc) {
		Hotel hotel = hd.findById(hotelId).get();
		User user = ud.findById(userId).get();
		float price = 0;
		BookedHotel book = new BookedHotel();
		if (isAc) {
			if (hotel.getNoOfAvilableAcRoom() < noOfRooms)
				return null;
			hotel.setNoOfAvilableAcRoom(hotel.getNoOfAcRooms() - noOfRooms);
			book.setAc(true);
			price = noOfRooms * hotel.getPriceAcRoom();
		} else if (!isAc) {
			if (hotel.getNoOfAvilableNonAcRoom() < noOfRooms)
				return null;
			hotel.setNoOfNonAcRooms(hotel.getNoOfAvilableNonAcRoom() - noOfRooms);
			book.setAc(false);
			price = noOfRooms * hotel.getPriceNonAcRoom();
		}
		book.setUser(user);
		book.setNoOfRooms(noOfRooms);
		book.setHotel(hotel);
		book.setPrice(price);
		book.setType("booked");
		bd.save(book);
		hd.save(hotel);
		List<BookedHotel> bookHotel = user.getHotelBooking();
		bookHotel.add(book);
		ud.save(user);
		return book;
	}

	@Override
	public boolean cancelHotelBooking(String bookingId) {

		BookedHotel book = new BookedHotel();
		BookedHotel bookHotel = bd.findById(bookingId).get();
		Hotel hotel = bookHotel.getHotel();
		User user = ud.findById(book.getUser().getUserId()).get();
		if (bookHotel.isAc()) {
			hotel.setNoOfAvilableAcRoom(hotel.getNoOfAcRooms() + bookHotel.getNoOfRooms());
		} else if (!bookHotel.isAc()) {
			hotel.setNoOfAvilableNonAcRoom(hotel.getNoOfNonAcRooms() + bookHotel.getNoOfRooms());
		}
		book.setHotel(hotel);
		// book.setPrice(price); if we add refund
		book.setType("canceled");
		bd.save(book);
		hd.save(hotel);
		List<BookedHotel> bookHotellist = user.getHotelBooking();
		bookHotellist.add(book);
		ud.save(user);
		return false;
	}

	@Override
	public Hotel viewHotel(String hotelId) {

		return hd.findById(hotelId).get();
	}

	@Override
	public int noOfRoomsAvilable(String hotelId, boolean isAc) {

		Hotel hotel = hd.findById(hotelId).get();
		if (isAc)
			return hotel.getNoOfAvilableAcRoom();

		return hotel.getNoOfAvilableNonAcRoom();
	}

	@Override
	public List<Hotel> hotelAtDestinationCityNonAc(String city) {
		return hd.findByHotelCityAndIsAcFalse(city);
	}

	@Override
	public Hotel isRoomAvilable(String hotelId, int noOfRooms, boolean isAc) {
		// TODO Auto-generated method stub
		Hotel hotel = hd.findById(hotelId).get();
		if (isAc) {
			if (hotel.getNoOfAvilableAcRoom() < noOfRooms)
				return null;
			return hotel;
		} else if (!isAc) {
			if (hotel.getNoOfNonAcRooms() < noOfRooms)
				return null;
			return hotel;
		}
		return null;
	}

}
