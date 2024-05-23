package com.jotasantos.app.diariooficial.web.controllers;

import com.jotasantos.app.diariooficial.config.ApiPath;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(ApiPath.USUARIOS)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("users", usuarioService.findAll());
        return "usuarios/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/create";
    }

    @GetMapping("/{id}/show")
    public String show(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        model.addAttribute("usuario", usuarioService.findById(id));
        return "usuarios/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/edit";
    }

    @GetMapping("/{id}/update")
    public String update(Model model) {
        return "";
    }

    @GetMapping("/{id}/delete")
    public String delete() {
        return "";
    }


    public String ativarUsuario() {
        return "";
    }

    public String inativarUsuario() {
        return "";
    }

}
