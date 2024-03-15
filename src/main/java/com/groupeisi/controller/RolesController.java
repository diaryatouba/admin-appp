package com.groupeisi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.groupeisi.dto.RoleDto;
import com.groupeisi.services.RolesService;

import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RolesController {
    private RolesService rolesService;

    @GetMapping
    public List<RoleDto> getRoles() {
        return rolesService.getRoles();
    }

    @GetMapping("/{id}")
    public RoleDto getRoles(@PathVariable("id") int id) {
        return rolesService.getRole(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public RoleDto createAppRoles(@Valid @RequestBody RoleDto roleDto) {
        return rolesService.createRoles(roleDto);
    }

    @PutMapping("/{id}")
    public RoleDto updateRoles(@PathVariable("id") int id, @Valid @RequestBody RoleDto roleDto) {
        return rolesService.updateRoles(id, roleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRoles(@PathVariable("id") int id) {
        rolesService.deleteRoles(id);
    }
}
