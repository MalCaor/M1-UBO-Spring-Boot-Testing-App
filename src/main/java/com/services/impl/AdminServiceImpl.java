package com.services.impl;

import com.repositories.AdminRepository;
import com.services.AdminService;
import com.dtos.AdminDto;
import com.entities.Admin;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private final AdminRepository AdminRepository;

    public AdminServiceImpl(com.repositories.AdminRepository AdminRepository){
        this.AdminRepository = AdminRepository;
    }

    @Override
    public AdminDto saveAdmin(AdminDto AdminDto) {
        // Converts the dto to the Admin entity
        Admin Admin = AdminDtoToEntity(AdminDto);
        // Save the Admin entity
        Admin = AdminRepository.save(Admin);
        // Return the new dto
        return AdminEntityToDto(Admin);
    }

    @Override
    public AdminDto getAdminById(Long AdminId) {
        Admin Admin = AdminRepository.findById(AdminId).orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        return AdminEntityToDto(Admin);
    }

    @Override
    public boolean deleteAdmin(Long AdminId) {
        AdminRepository.deleteById(AdminId);
        return true;
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<AdminDto> AdminDtos = new ArrayList<>();
        List<Admin> Admins = AdminRepository.findAll();
        Admins.forEach(Admin -> {
            AdminDtos.add(AdminEntityToDto(Admin));
        });
        return AdminDtos;
    }

    /**
     * Map Admin dto to Admin entity
     */
    private AdminDto AdminEntityToDto(Admin Admin){
        AdminDto AdminDto = new AdminDto();
        // TODO : Set
        return AdminDto;
    }

    /**
     * Map Admin entity to Admin dto
     */
    private Admin AdminDtoToEntity(AdminDto AdminDto){
        Admin Admin = new Admin();
        // TODO : Set
        return Admin;
    }
}
