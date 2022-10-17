package com.mmt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mmt.admin.dao.AdminDao;
import com.mmt.admin.model.Admin;
import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.flights.dao.FlightDao;
import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightServiceInterface;
import com.mmt.hotels.dao.HotelDao;
import com.mmt.hotels.model.Hotel;
import com.mmt.hotels.services.HotelServiceInterface;
import com.mmt.user.dao.UserDao;
import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@SpringBootTest
class MmtProjectPostmanApplicationTests {

	@Autowired
	private UserDao ud;

	@Autowired
	private AdminDao ad;

	@Autowired
	private FlightDao fd;

	@Autowired
	private HotelDao hd;
	
	@Autowired
	private HotelServiceInterface hotelService;
	
	@Autowired
	private FlightServiceInterface flightService;
	
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private AdminServiceInterface adminService;

	@Test
	public void testAdminLogin() {
		Admin admin = ad.findByAdminIdAndAdminPassword("ankury", "1234");
		String id = admin.getAdminId();
		String pass = admin.getAdminPassword();

		assertEquals("ankury", id);
		assertEquals("1234", pass);
	}

	@Test
	public void testUserLogin() {
		User user = ud.findByMailIDAndPassword("ankur@gmail.com", "Ankur@321");
		String id = user.getMailID();
		String pass = user.getPassword();

		assertEquals("ankur@gmail.com", id);
		assertEquals("Ankur@321", pass);
	}

	@Test
	public void testFlightPresent() {

		Flight flight = fd.findById("Flight_00001").get();
		String id = flight.getFlightId();
		assertEquals("Flight_00001", id);
	}

	@Test
	public void testHotelPresent() {
		Hotel hotel = hd.findById("hotel_00001").get();
		String id = hotel.getHotelId();
		assertEquals("hotel_00001", id);
	}
	
	@Test
	public void testFindHotelLogic() {
		Hotel hotel = hd.findById("hotel_00001").get();
		Hotel hotelTest = hotelService.viewHotel("hotel_00001");
		String name = hotel.getHotelName();
		String nameTest =hotelTest.getHotelName();
		assertEquals(name, nameTest);
	}
	
	@Test
	public void testFindFlightLogic() {
		Flight flight = fd.findById("Flight_00001").get();
		Flight flightTest = flightService.viewFlightDetails("Flight_00001");
		String flightName = flight.getAirlineName();
		String flightTestName = flightTest.getAirlineName();
		assertEquals(flightName, flightTestName);
	}
	
	@Test
	public void testUserLoginLogic() {
		User user = ud.findByMailIDAndPassword("ankur@gmail.com", "Ankur@321");
		User userTest =userService.userLogin(user);
		assertEquals(user.getFirstName(), userTest.getFirstName());
	}
	
	@Test
	public void testAdminLoginLogic() {
		Admin admin = ad.findByAdminIdAndAdminPassword("ankury", "1234");
		Admin adminTest = adminService.login(admin);
		assertEquals(admin.getAdminId(), adminTest.getAdminId());
	}

}
