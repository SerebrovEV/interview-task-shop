package com.task.shop.product.service;
import com.task.shop.product.dto.TagsDto;

public interface TagService {
    TagsDto addTag(Long tagId, TagsDto tagsDto);
    TagsDto getTag(Long tagId);
    TagsDto updateTag(Long tagId, TagsDto tagsDto);
    void deleteTag(Long tagId);
}
