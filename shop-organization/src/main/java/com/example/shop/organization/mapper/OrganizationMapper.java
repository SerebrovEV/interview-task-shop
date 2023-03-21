package com.example.shop.organization.mapper;

import com.example.shop.organization.dto.OrganizationDto;
import com.example.shop.organization.entity.OrganizationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationDto entityToDto(OrganizationEntity organizationEntity);
    OrganizationEntity dtoToEntity (OrganizationDto organizationDto);
}
