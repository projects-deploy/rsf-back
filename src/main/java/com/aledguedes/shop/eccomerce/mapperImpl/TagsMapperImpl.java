package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.TagsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.TagsResponse;
import com.aledguedes.shop.eccomerce.mapper.TagsMapper;
import com.aledguedes.shop.eccomerce.model.Tags;

@Component
public class TagsMapperImpl implements TagsMapper {

    @Override
    public Tags toTags(TagsRequest tagsRequest) {
       if (tagsRequest == null) {
            return null;
        }

        return Tags.builder()
                .tags(tagsRequest.getTags())
                .build();
    }

    @Override
    public TagsResponse toTagsResponse(Tags tags) {
        if (tags == null) {
            return null;
        }

        return TagsResponse.builder()
                .id(tags.getId())
                .tabs(tags.getTags())
                .build();
    }
    
}
