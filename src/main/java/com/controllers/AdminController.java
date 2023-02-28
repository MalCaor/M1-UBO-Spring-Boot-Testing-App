package com.controllers;

import com.dtos.AdminDto;
import com.services.impl.AdminServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl AdminService;

    public AdminController(AdminServiceImpl AdminService) {
        this.AdminService = AdminService;
    }

    /**
     * <p>Get all Admins in the system</p>
     * @return List<AdminDto>
     */
    @GetMapping
    public List<AdminDto> getAdmins() {
        return AdminService.getAllAdmins();
    }

    /**
     * Method to get the Admin based on the ID
     */
    @GetMapping("/{id}")
    public AdminDto getAdmin(@PathVariable Long id){
        return AdminService.getAdminById(id);
    }

    /**
     * Create a new Admin in the system
     */
    @PostMapping
    public AdminDto saveAdmin(final @RequestBody AdminDto AdminDto){
        return AdminService.saveAdmin(AdminDto);
    }

    /**
     * Delete a Admin by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteAdmin(@PathVariable Long id){
        return AdminService.deleteAdmin(id);
    }

    /**
     * Verify login info
     */
    public Boolean login(@PathVariable String pseudo, @PathVariable String mdp)
    {
        return AdminService.login(pseudo, mdp);
    }
}
