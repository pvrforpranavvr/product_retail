package com.product.productretail.service.impl;

import com.product.productretail.model.entity.ImageEntity;
import com.product.productretail.repository.ImageRepository;
import com.product.productretail.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void create(ImageEntity imageEntity) {

        imageRepository.save(imageEntity);
    }

    @Override
    public List<ImageEntity> createAll(List<ImageEntity> imageEntities) {

        return imageRepository.saveAll(imageEntities);

    }
}
