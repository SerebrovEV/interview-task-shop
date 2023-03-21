package com.task.shop.api.client;


import com.task.shop.api.dto.OrganizationDto;
import com.task.shop.api.dto.ProductDto;
import com.task.shop.api.dto.UserDto;
import com.thoughtworks.xstream.security.ForbiddenClassException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class OrganizationClient {

    @Value("${url.organization}")
    private URI uriOrganization;

    private final RestTemplate restTemplate;
    private final UserClient userClient;

    public ResponseEntity<OrganizationDto> addOrganization(Long userId, OrganizationDto organizationDto) {
        return restTemplate.postForEntity(uriOrganization + "user/" + userId, organizationDto, OrganizationDto.class);
    }


    public OrganizationDto getOrganization(Long userId, Long orgId, String userName) {
        UserDto user = userClient.getUserByName(userName);
        OrganizationDto findOrg = restTemplate.getForObject(uriOrganization + orgId.toString(), OrganizationDto.class);
        if (user.getId().equals(findOrg.getUserId())) {
            return findOrg;
        } else {
            throw new RuntimeException();
        }
    }

    //in work
    public OrganizationDto updateOrganization(Long userId, Long orgId, OrganizationDto organizationDto) {
        return restTemplate.patchForObject(uriOrganization, organizationDto, OrganizationDto.class);
    }


    public void deleteOrganization(Long id) {
        restTemplate.delete((uriOrganization.toString() + id.toString()));
    }


    public ResponseEntity<ProductDto> addOrganizationProduct(Long orgId, ProductDto productDto) {
        return restTemplate.postForEntity(uriOrganization.toString() + orgId.toString() + "/product", productDto, ProductDto.class);
    }
}
