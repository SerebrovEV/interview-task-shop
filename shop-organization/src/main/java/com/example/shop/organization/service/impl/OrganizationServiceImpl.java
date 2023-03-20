package com.example.shop.organization.service.impl;

import com.example.shop.organization.dto.OrganizationDto;
import com.example.shop.organization.entity.OrganizationEntity;
import com.example.shop.organization.mapper.OrganizationMapper;
import com.example.shop.organization.repository.OrganizationRepository;
import com.example.shop.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper mapper;


    @Override
    public OrganizationDto addOrganization(OrganizationDto organizationDto) {
        OrganizationEntity newOrganization = mapper.dtoToEntity(organizationDto);
        newOrganization.setActiveStatus(false);
        newOrganization.setCreateAt(LocalDate.now());
        newOrganization = organizationRepository.save(newOrganization);
        return mapper.entityToDto(newOrganization);
    }

    @Override
    public OrganizationDto updateOrganization(Long orgId, OrganizationDto organizationDto) {
        OrganizationEntity findOrganization = organizationRepository.findById(orgId).get();
        return organizationDto;
    }

    @Override
    public OrganizationDto getOrganization(Long id) {
        OrganizationEntity findOrganization = organizationRepository.findById(id).get();
        return mapper.entityToDto(findOrganization);
    }

    @Override
    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}
