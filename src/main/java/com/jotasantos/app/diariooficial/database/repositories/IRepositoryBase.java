package com.jotasantos.app.diariooficial.database.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface IRepositoryBase<T, ID> extends JpaRepository<T, ID> {
    @Query("SELECT u FROM #{#entityName} u ORDER BY u.id")
    List<T> findAllOrderById();

    @Cacheable(unless = "#result == null or #result.isEmpty()", cacheNames = {"idsCache"})
    @Query("SELECT u.id FROM #{#entityName} u")
    List<Long> findAllIds();

}
