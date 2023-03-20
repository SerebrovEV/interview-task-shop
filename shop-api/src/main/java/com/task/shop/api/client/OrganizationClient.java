package com.task.shop.api.client;


import com.task.shop.api.dto.OrganizationDto;
import com.task.shop.api.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class OrganizationClient {

    @Value("${url.organization}")
    private URI uriOrganization;

    private final RestTemplate restTemplate;
    private final UserClient userClient;

    public ResponseEntity<OrganizationDto> addOrganization(OrganizationDto organizationDto) {
        return restTemplate.postForEntity(uriOrganization, organizationDto, OrganizationDto.class);
    }


    public OrganizationDto getOrganization(String userName, Long orgId) {
        UserDto user = userClient.getUserByName(userName);
        OrganizationDto findOrg = restTemplate.getForObject(uriOrganization + orgId.toString(), OrganizationDto.class);
        if (user.getId().equals(findOrg.getUserId())){
            return findOrg;
        }else {
            return null;
        }
    }


    public OrganizationDto updateOrganization(Long id, OrganizationDto organizationDto) {
        return restTemplate.patchForObject(uriOrganization.toString() + id.toString(), organizationDto, OrganizationDto.class);
    }


    public void deleteOrganization(Long id) {
        restTemplate.delete((uriOrganization.toString() + id.toString()));
    }
}
