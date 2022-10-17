package com.mmt.hotels.services;

import java.util.List;

import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.hotels.model.Hotel;

public interface HotelServiceInterface {
	public List<Hotel> allHotels();
	public List<Hotel> hotelAtDestinationCity(String city);
	public List<Hotel>hotelAtDestinationCityAc(String city);
	public BookedHotel bookHotel(String hotelId ,String userId, int noOfRooms , boolean isAc);
	public boolean cancelHotelBooking(String bookingId); 
	public Hotel viewHotel(String hotelId);
	public int noOfRoomsAvilable(String hotelId , boolean isAc);
	public List<Hotel> hotelAtDestinationCityNonAc(String city);
	public Hotel isRoomAvilable(String hotelId , int noOfRooms ,boolean isAc );
}
