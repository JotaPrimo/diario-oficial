package com.jotasantos.app.diariooficial.database.repositories;

import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface IOrgaoGovernamentalRepository extends IRepositoryBase<OrgaoGovernamental, Long> {

    @Cacheable(unless = "#result == null or #result.isEmpty()", cacheNames = {"userIdsCache"})
    List<Long> findAllIds();
}
