package com.mmt.bookedFlight.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.flights.model.Flight;
import com.mmt.user.model.User;

public interface BookedFlightDao extends JpaRepository<BookedFlight, String> {

	List<BookedFlight> findByUser(User user);
	List<Flight> findByFlight(Flight flight);
}
