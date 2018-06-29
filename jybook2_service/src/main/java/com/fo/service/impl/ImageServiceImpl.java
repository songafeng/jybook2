package com.fo.service.impl;

import com.fo.entity.image;
import com.fo.repository.BooktypeRepository;
import com.fo.repository.ImageRepository;
import com.fo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
@Service("ImageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public image get(Integer id) {
        return null;
    }

    public image findSingleByPlace(String place) {
        return imageRepository.findSingleByPlace(place);
    }

    public List<image> findByPlace(String place) {
        return imageRepository.findByPlace(place);
    }
}
