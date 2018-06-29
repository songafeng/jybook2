package com.fo.repository;

import com.fo.entity.version;

/**
 * Created by jdd on 2018/6/28.
 */
public interface VersionRepository extends DomainRepository<version,Integer>{

    public version findByClienttype(Integer client_type);
}
