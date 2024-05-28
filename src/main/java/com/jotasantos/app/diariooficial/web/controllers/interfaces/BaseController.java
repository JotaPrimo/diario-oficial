package com.jotasantos.app.diariooficial.web.controllers.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class BaseController {

    protected String redirectBackWithMessage(HttpServletRequest request, RedirectAttributes redirectAttributes, String typeMessage,String message) {

        redirectAttributes.addFlashAttribute(typeMessage, message);

        String referer = request.getHeader("Referer");

        return "redirect:" + referer;
    }

    protected String redirectBackWithOutMessage(HttpServletRequest request) {
        return "redirect:" + request.getHeader("Referer");
    }

}
