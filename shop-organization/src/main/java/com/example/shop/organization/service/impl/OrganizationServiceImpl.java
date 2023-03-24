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

    private OrganizationEntity findOrganizationEntity(Long orgId) {
        return organizationRepository.findById(orgId).get();
    }


    @Override
    public OrganizationDto addOrganization(Long userId, OrganizationDto organizationDto) {
        OrganizationEntity newOrganization = mapper.dtoToEntity(organizationDto);
        newOrganization.setActiveStatus(false);
        newOrganization.setCreateAt(LocalDate.now());
        newOrganization.setUserId(userId);
        newOrganization = organizationRepository.save(newOrganization);
        return mapper.entityToDto(newOrganization);
    }

    @Override
    public OrganizationDto updateOrganization(Long orgId, OrganizationDto organizationDto) {
        OrganizationEntity findOrganization = findOrganizationEntity(orgId);
        findOrganization.setName(organizationDto.getName());
        findOrganization.setDescription(organizationDto.getDescription());
        organizationRepository.save(findOrganization);
        return mapper.entityToDto(findOrganization);
    }

    @Override
    public OrganizationDto getOrganization(Long id) {
        return mapper.entityToDto(findOrganizationEntity(id));
    }

    @Override
    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }

    @Override
    public OrganizationDto changeStatus(Long orgId, OrganizationDto organizationDto) {
        OrganizationEntity findOrganization = findOrganizationEntity(orgId);
        findOrganization.setActiveStatus(organizationDto.getActiveStatus());
        return mapper.entityToDto(organizationRepository.save(findOrganization));
    }
}
