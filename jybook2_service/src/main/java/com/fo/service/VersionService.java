package com.fo.service;

import com.fo.entity.booktype;
import com.fo.entity.version;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
public interface VersionService {
    public version get(Integer id);
    public version findByClienttype(Integer client_type);
}
