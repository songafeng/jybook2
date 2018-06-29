package com.fo.service;

import com.fo.entity.booktype;
import com.fo.entity.image;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
public interface ImageService {

    public image get(Integer id);

    public image findSingleByPlace(String place);

    public List<image> findByPlace(String place);
}
