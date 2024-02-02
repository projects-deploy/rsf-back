package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.aledguedes.shop.eccomerce.dtoRequest.InCollectionRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCollectionResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.ColecoesNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.InCollectionMapper;
import com.aledguedes.shop.eccomerce.model.InCollection;
import com.aledguedes.shop.eccomerce.repository.InCollectionRepository;
import com.aledguedes.shop.eccomerce.service.InCollectionService;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class InCollectionServiceImpl implements InCollectionService {

    private final InCollectionMapper inCollectionMapper;
    private final InCollectionRepository inCollectionRepository;

    @Override
    public List<InCollectionResponse> listAll() {
        return inCollectionRepository.findAll()
                .stream()
                .map(inCollectionMapper::toInCollectionResponse)
                .toList();
    }

    @Override
    public InCollectionResponse inCollectionById(Long inCollection_id) {
        return inCollectionRepository.findById(inCollection_id)
                .map(inCollectionMapper::toInCollectionResponse)
                .orElseThrow(ColecoesNotFoundException::new);
    }

    @Override
    public InCollectionResponse createInCollection(InCollectionRequest inCollection) {
        try {
            var newInCollection = inCollectionMapper.toInCollection(inCollection);
            var createdInCollection = inCollectionRepository.save(newInCollection);
            return inCollectionMapper.toInCollectionResponse(createdInCollection);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
        }
        return null;
    }

    @Override
    public InCollectionResponse updateInCollection(InCollectionRequest inCollection, Long inCollection_id) {
        try {
            var newInCollection = inCollectionRepository.findById(inCollection_id)
                    .orElseThrow(ColecoesNotFoundException::new);
            BeanUtils.copyProperties(inCollection, inCollection, "id", "createdAt", "updatedAt");
            var inCollectionAtualizado = inCollectionRepository.save(newInCollection);
            return inCollectionMapper.toInCollectionResponse(inCollectionAtualizado);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<InCollectionResponse> saveInCollectionList(List<InCollectionRequest> inCollectionRequestList) {
        try {
            List<InCollection> inCollectionList = new ArrayList<>();

            for (InCollectionRequest request : inCollectionRequestList) {
                InCollection inCollection = inCollectionMapper.toInCollection(request);
                inCollectionList.add(inCollection);
            }

            var savedInCollection = inCollectionRepository.saveAll(inCollectionList);
            return savedInCollection.stream()
                    .map(inCollectionMapper::toInCollectionResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

}
