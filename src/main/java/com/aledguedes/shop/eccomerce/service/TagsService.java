package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.TagsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.TagsResponse;

public interface TagsService {

    List<TagsResponse> listAll();
    TagsResponse tagsById(Long tags_id);
    TagsResponse createTags(TagsRequest tags);
    TagsResponse updateTags(TagsRequest tags, Long tags_id);
}
