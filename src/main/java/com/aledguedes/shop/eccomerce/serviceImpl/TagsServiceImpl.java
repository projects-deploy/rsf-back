package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.TagsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.TagsResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.TagsNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.TagsMapper;
import com.aledguedes.shop.eccomerce.repository.TagsRepository;
import com.aledguedes.shop.eccomerce.service.TagsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class TagsServiceImpl implements TagsService {

    private final TagsMapper tagsMapper;
    private final TagsRepository tagsRepository;

    @Override
    public List<TagsResponse> listAll() {
        return tagsRepository.findAll()
                .stream()
                .map(tagsMapper::toTagsResponse)
                .toList();
    }

    @Override
    public TagsResponse tagsById(Long tags_id) {
        return tagsRepository.findById(tags_id)
                .map(tagsMapper::toTagsResponse)
                .orElseThrow(TagsNotFoundException::new);
    }

    @Override
    public TagsResponse createTags(TagsRequest tagsRequest) {
        try {
            var newTags = tagsMapper.toTags(tagsRequest);
            var createdTags = tagsRepository.save(newTags);
            return tagsMapper.toTagsResponse(createdTags);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
        }
        return null;
    }

    @Override
    public TagsResponse updateTags(TagsRequest tagsRequest, Long tags_id) {
        try {
			var tags = tagsRepository.findById(tags_id)
					.orElseThrow(TagsNotFoundException::new);
			BeanUtils.copyProperties(tagsRequest, tags, "id", "createdAt", "updatedAt");
			var tagsAtualizado = tagsRepository.save(tags);
			return tagsMapper.toTagsResponse(tagsAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
    }

}