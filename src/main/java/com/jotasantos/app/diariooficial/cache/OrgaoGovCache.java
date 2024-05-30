package com.jotasantos.app.diariooficial.cache;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrgaoGovCache {

    private List<Long> validIds = new ArrayList<>();

    public void loadValidIds(List<Long> ids) {
        validIds.addAll(ids);
    }

    public boolean isValid(Long id) {
        return validIds.contains(id);
    }

}
