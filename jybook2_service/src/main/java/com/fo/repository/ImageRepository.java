package com.fo.repository;

import com.fo.entity.image;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
public interface ImageRepository extends DomainRepository<image,Integer> {

    public image findSingleByPlace(String place);

    public List<image> findByPlace(String place);
}
