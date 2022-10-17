package com.mmt.bookedHotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.user.model.User;

public interface BookedHotelDao extends JpaRepository<BookedHotel, String> {

	List<BookedHotel> findByUser(User user);

}
