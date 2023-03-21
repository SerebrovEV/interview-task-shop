package com.example.shop.organization.controller;

import com.example.shop.organization.dto.OrganizationDto;
import com.example.shop.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<OrganizationDto> addOrganization(@PathVariable Long userId,
                                                           @RequestBody OrganizationDto organizationDto) {
        return ResponseEntity.ok(organizationService.addOrganization(userId, organizationDto));
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable Long orgId) {
        return ResponseEntity.ok(organizationService.getOrganization(orgId));
    }

    @DeleteMapping("/{orgId}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long orgId) {
        organizationService.deleteOrganization(orgId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{orgId}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable Long orgId,
                                                              @RequestBody OrganizationDto organizationDto) {
        return ResponseEntity.ok(organizationService.updateOrganization(orgId, organizationDto));
    }
}
