package com.mmt.admin.service;

import com.mmt.admin.model.Admin;
import com.mmt.flights.model.Flight;
import com.mmt.hotels.model.Hotel;

public interface AdminServiceInterface {
	public Admin login(Admin admin);
	public boolean logout();// to be implemented
	public Hotel addHotel(Hotel hotel);
	public boolean removeHotel(String hotelId);
	public Hotel updateHotel(Hotel hotel);
	public Flight addFlight(Flight flight);
	public boolean removeFlight(String flightId);
	public Flight updateFlight(Flight flight);
	public Admin createAdmin(Admin admin);
}
