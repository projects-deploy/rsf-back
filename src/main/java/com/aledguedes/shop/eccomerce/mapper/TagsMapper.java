package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.TagsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.TagsResponse;
import com.aledguedes.shop.eccomerce.model.Tags;

public interface TagsMapper {

    Tags toTags(TagsRequest tagsRequest);
    TagsResponse toTagsResponse(Tags tags);
}
