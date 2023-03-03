package com.services.impl;

import com.repositories.AdminRepository;
import com.services.AdminService;
import com.dtos.AdminDto;
import com.entities.Admin;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("adminService")
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

    @Override
    public boolean login(AdminDto adminDto) {
        System.out.println(adminDto);
        List<AdminDto> listAllAdmin = this.getAllAdmins();
        AdminDto admin = null;
        for (AdminDto a: listAllAdmin) {
            if (a.getLogin().equals(adminDto.getLogin())) {
                admin = a;
                break;
            }
        }
        if (admin == null) return false;
        return admin.getPwd().equals(adminDto.getPwd());
    }

    /**
     * Map Admin dto to Admin entity
     */
    private AdminDto AdminEntityToDto(Admin admin){
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setLogin(admin.getLogin());
        adminDto.setPwd(admin.getPwd());
        return adminDto;
    }

    /**
     * Map Admin entity to Admin dto
     */
    private Admin AdminDtoToEntity(AdminDto adminDto){
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setLogin(adminDto.getLogin());
        admin.setPwd(adminDto.getPwd());
        return admin;
    }
}
