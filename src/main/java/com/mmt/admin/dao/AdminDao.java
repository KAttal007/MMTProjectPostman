package com.mmt.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.admin.model.Admin;

public interface AdminDao extends JpaRepository<Admin, String> {

	Admin findByAdminIdAndAdminPassword(String adminId, String adminPassword);

}
