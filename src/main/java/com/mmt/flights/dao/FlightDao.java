package com.mmt.flights.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.flights.model.Flight;

public interface FlightDao extends JpaRepository<Flight, String> {
	List<Flight> findByFlightSourceAndFlightDestination(String startCity , String endCity);
	Flight findByFlightNumber(String s);
	List<Flight> findByFlightSourceAndFlightDestinationOrderByPricePerSeat(String startCity , String endCity);
}
