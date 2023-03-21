package com.task.shop.product.service.impl;

import com.task.shop.product.dto.TagsDto;
import com.task.shop.product.mapper.TagMapper;
import com.task.shop.product.repository.TagsRepository;
import com.task.shop.product.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagsRepository tagsRepository;
    private final TagMapper tagMapper;

    @Override
    public TagsDto addTag(Long tagId, TagsDto tagsDto) {
        return null;
    }

    @Override
    public TagsDto getTag(Long tagId) {
        return null;
    }

    @Override
    public TagsDto updateTag(Long tagId, TagsDto tagsDto) {
        return null;
    }

    @Override
    public void deleteTag(Long tagId) {

    }
}
