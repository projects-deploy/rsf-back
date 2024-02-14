package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.InTabsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InTabsResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.TagProductsDTO;
import com.aledguedes.shop.eccomerce.exceptions.core.BrandNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.InTabsNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.InTabsMapper;
import com.aledguedes.shop.eccomerce.mapper.ProductMapper;
import com.aledguedes.shop.eccomerce.model.InTabs;
import com.aledguedes.shop.eccomerce.repository.InTabsRepository;
import com.aledguedes.shop.eccomerce.repository.ProductRepository;
import com.aledguedes.shop.eccomerce.service.InTabsService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class InTabsServiceImpl implements InTabsService {

	private final InTabsMapper inTabsMapper;
	private final ProductMapper productMapper;
	private final InTabsRepository inTabsRepository;
	private final ProductRepository productRepository;

	@Override
	public List<TagProductsDTO> getProductsByTag(Long inTabsId) {
		Optional<InTabs> inTabsOptional = inTabsRepository.findById(inTabsId);

		if (inTabsOptional.isPresent()) {
			InTabs inTabs = inTabsOptional.get();
			String tagsString = inTabs.getTabs();
			System.out.println("DEBUG TAGS __ 1: " + tagsString);

			List<TagProductsDTO> result = new ArrayList<>();

			// Remova os colchetes da string
//			String tagsCombined = tagsString.get(0).replaceAll("\\[|\\]", "");

			// Divida a string em tags individuais
			String[] tagsArray = tagsString.split(", ");

			for (String tag : tagsArray) {
				var products = productRepository.findByTagsContaining(tag).stream()
						.map(productMapper::toProductResponse).toList();
				System.out.println("DEBUG TAGS __2: " + tag);
				products = products.subList(0, Math.min(products.size(), 5));

				result.add(new TagProductsDTO(tag, products));
			}

			return result;
		} else {
			throw new EntityNotFoundException("InTabs not found with id: " + inTabsId);
		}
	}

	@Override
	public InTabsResponse create(InTabsRequest inTabsRequest) {
		try {
			var newTabs = inTabsMapper.toInTabs(inTabsRequest);
			var createdNewTab = inTabsRepository.save(newTabs);
			return inTabsMapper.toInTabsResponse(createdNewTab);
		} catch (Exception e) {
			System.out.println("DEBUG = " + e.getMessage());
		}
		return null;
	}

	@Override
	public InTabsResponse update(InTabsRequest inTabsRequest, Long tabs_id) {
		try {
			var tabsId = inTabsRepository.findById(tabs_id).orElseThrow(InTabsNotFoundException::new);
			BeanUtils.copyProperties(inTabsRequest, tabsId, "id");
			var tabsAtualizado = inTabsRepository.save(tabsId);
			return inTabsMapper.toInTabsResponse(tabsAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public InTabsResponse inTabsById(Long inTabs_id) {
		return inTabsRepository.findById(inTabs_id).map(inTabsMapper::toInTabsResponse)
				.orElseThrow(BrandNotFoundException::new);
	}
}
