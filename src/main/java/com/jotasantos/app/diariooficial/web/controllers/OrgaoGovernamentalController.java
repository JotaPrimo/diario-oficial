package com.jotasantos.app.diariooficial.web.controllers;

import com.jotasantos.app.diariooficial.config.ApiPath;
import com.jotasantos.app.diariooficial.services.interfaces.IOrgaoGovernamentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ApiPath.ORGAOS_GOVERNAMENTAIS)
public class OrgaoGovernamentalController {

    @Autowired
    private IOrgaoGovernamentalService orgaoGovernamentalService;


}
