package com.jotasantos.app.diariooficial.loader;

import com.jotasantos.app.diariooficial.cache.OrgaoGovCache;
import com.jotasantos.app.diariooficial.services.implementation.OrgaoGovernamentalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private OrgaoGovCache orgaoGovCache;

    @Autowired
    private OrgaoGovernamentalServiceImpl orgaoGovernamentalService;

    @Override
    public void run(String... args) throws Exception {
        List<Long> listIdsValids = orgaoGovernamentalService.findAllIds();
        orgaoGovCache.loadValidIds(listIdsValids);
    }
}
