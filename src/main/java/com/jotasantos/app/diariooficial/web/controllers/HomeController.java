package com.jotasantos.app.diariooficial.web.controllers;

import com.jotasantos.app.diariooficial.config.ApiPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping
    private String index() {
        return "redirect:".concat(ApiPath.USUARIOS);
    }
}
