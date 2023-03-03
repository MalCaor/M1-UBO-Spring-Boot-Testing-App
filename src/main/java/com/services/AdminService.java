package com.services;

import com.dtos.AdminDto;

import java.util.List;

public interface AdminService {
    /**
     * Sauve a Admin
     */
    AdminDto saveAdmin(AdminDto adminDto);

    /**
     * Get a Admin by it's id
     */
    AdminDto getAdminById(Long adminId);

    /**
     * Delete a Admin by it's id
     */
    boolean deleteAdmin(Long adminId);

    /**
     * Get all the Admins
     */
    List<AdminDto> getAllAdmins();

    /**
     * Verify login info
     */
    String login(AdminDto adminDto);
}
