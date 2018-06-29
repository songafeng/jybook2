package com.fo.service.impl;

import com.fo.entity.version;
import com.fo.repository.BookRepository;
import com.fo.repository.VersionRepository;
import com.fo.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jdd on 2018/6/28.
 */
@Service("VersionService")
public class VersionServiceImpl  implements VersionService {

    @Autowired
    private VersionRepository versionRepository;

    public version get(Integer id) {
        return versionRepository.get(id);
    }

    public version findByClienttype(Integer client_type) {
        return versionRepository.findByClienttype(client_type);
    }
}
