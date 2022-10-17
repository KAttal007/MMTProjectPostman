package com.mmt.hotels.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.hotels.model.Hotel;

public interface HotelDao extends JpaRepository<Hotel, String> {
	List<Hotel> findByHotelCity(String city);
	List<Hotel> findByHotelCityAndIsAcTrue(String city);
	List<Hotel> findByHotelCityAndIsAcFalse(String city);
	List<Hotel> findByHotelCityOrderByPriceAcRoom(String city);
	List<Hotel> findByHotelCityOrderByPriceNonAcRoom(String city);
}
