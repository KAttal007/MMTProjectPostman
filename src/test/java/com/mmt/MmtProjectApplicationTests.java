package com.mmt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mmt.admin.dao.AdminDao;
import com.mmt.admin.model.Admin;
import com.mmt.admin.service.AdminService;
import com.mmt.bookedFlight.dao.BookedFlightDao;
import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.bookedHotel.dao.BookedHotelDao;
import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.flights.dao.FlightDao;
import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightService;
import com.mmt.hotels.dao.HotelDao;
import com.mmt.hotels.model.Hotel;
import com.mmt.hotels.services.HotelService;
import com.mmt.user.dao.UserDao;
import com.mmt.user.model.User;
import com.mmt.user.services.UserService;

@SpringBootTest
class MmtProjectApplicationTests {

	@Autowired
	private AdminDao ad;
	@Autowired
	private HotelDao hd;
	@Autowired
	private FlightDao fd;
	@Autowired
	private UserDao ud;
	@Autowired
	private BookedHotelDao bhd;
	@Autowired
	private BookedFlightDao bfd;

	User user = new User();
	Admin admin = new Admin();
	AdminService as = new AdminService();
	Hotel hotel = new Hotel();
	Flight flight = new Flight();
	UserService us = new UserService();
	HotelService hs = new HotelService();
	FlightService fs = new FlightService();
	BookedFlight bf = new BookedFlight();
	BookedHotel bh = new BookedHotel();
	
	/*
	 * @Test public void testAdminLogin() { Admin admin = new Admin();
	 * admin.setAdminId("Admin_00001"); admin.setAdminPassword("Admin@123");
	 * assertNotNull(as.login(admin)); }
	 * 
	 * @Test public void testViewAdmin() { admin = ad.findById("Admin_00001").get();
	 * assertEquals("Admin", admin.getFirstName()); }
	 * 
	 * @Test public void testAdminAddHotel() { hotel.setHotelName("Vivanta");
	 * hotel.setHotelBrand("Taj Group"); hotel.setHotelCity("Mumbai");
	 * hotel.setNoOfAcRooms(300); hotel.setNoOfAvilableAcRoom(300);
	 * hotel.setNoOfNonAcRooms(0); hotel.setNoOfAvilableNonAcRoom(0);
	 * hotel.setPriceAcRoom(22600); hotel.setPriceNonAcRoom(0); hotel.setIsAc(true);
	 * 
	 * hd.save(hotel); Hotel h = hd.findById("Hotel_00001").get();
	 * assertEquals("Vivanta", h.getHotelName()); }
	 * 
	 * @Test public void testAdminAddFlight() { flight.setAirlineName("Air India");
	 * flight.setFlightNumber("AI 182"); flight.setFlightSource("Delhi");
	 * flight.setFlightDestination("Kathmandu"); flight.setFlightDeparture("13:20");
	 * flight.setFlightArrival("14:55"); flight.setNoOfSeats(135);
	 * flight.setNoOfAvilableSeats(135); flight.setPricePerSeat(4500);
	 * 
	 * fd.save(flight); assertEquals("Kathmandu",
	 * fd.save(flight).getFlightDestination()); }
	 * 
	 * @Test public void testAdminUpdateFlight() { flight =
	 * fd.findByFlightNumber("AI 182"); flight.setFlightDestination("London");
	 * fd.save(flight); assertEquals("London",
	 * fd.save(flight).getFlightDestination()); }
	 * 
	 * @Test public void testAdminUpdateHotel() { hotel =
	 * hd.findById("Hotel_00001").get(); hotel.setHotelCity("Delhi");
	 * hd.save(hotel); assertEquals("Delhi",hd.save(hotel).getHotelCity()); }
	 * 
	 * @Test public void testUserAdd() { user.setFirstName("Allen");
	 * user.setLastName("Jack"); user.setMiddleName("Tony");
	 * user.setMailID("AllenJ@gmail.com"); user.setMobileNumber("9235231523");
	 * user.setPassword("Allen@2022"); ud.save(user);
	 * 
	 * }
	 * 
	 * @Test public void testUserViewDetail() { User u =
	 * ud.findById("User_00001").get(); assertEquals("Allen",u.getFirstName()); }
	 * 
	 * @Test public void testUserUpdateDetail() { User u =
	 * ud.findById("User_00001").get(); u.setFirstName("Ghost"); ud.save(u);
	 * assertEquals("Ghost",u.getFirstName()); }
	 * 
	 * @Test public void testUserBookingFlight() { user.setUserId("User_00001");
	 * flight.setFlightId("Flight_00001"); flight.setNoOfSeats(4);
	 * fs.bookFlight(user.getUserId(), flight.getFlightId(), flight.getNoOfSeats());
	 * bf = bfd.findById(flight.getFlightId()).get();
	 * assertEquals("Air India",bf.getFlight().getAirlineName()); }
	 * 
	 * @Test public void testUserBookingHotel() { user.setUserId("User_00001");
	 * hotel.setHotelId("Hotel_00001"); hotel.setNoOfAcRooms(3);
	 * hs.bookHotel(hotel.getHotelId(), user.getUserId(), hotel.getNoOfAcRooms(),
	 * true); bh = bhd.findById(hotel.getHotelId()).get();
	 * assertEquals("Vivanta",bh.getHotel().getHotelName()); }
	 */
}
