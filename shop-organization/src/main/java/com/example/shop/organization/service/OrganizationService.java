package com.example.shop.organization.service;

import com.example.shop.organization.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto addOrganization(OrganizationDto organizationDto);

    OrganizationDto updateOrganization(Long orgId, OrganizationDto organizationDto);

    OrganizationDto getOrganization(Long id);

    void deleteOrganization(Long id);
}
