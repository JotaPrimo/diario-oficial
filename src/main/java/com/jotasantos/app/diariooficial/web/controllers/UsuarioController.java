package com.jotasantos.app.diariooficial.web.controllers;

import com.jotasantos.app.diariooficial.config.ApiPath;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/store")
    public String store(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msgDanger", "Ocorreu um erro");

            return "redirect:/" . concat(ApiPath.USUARIOS);
        }

        redirectAttributes.addFlashAttribute("msgSuccess", "Usuário criado com sucesso ");
        usuarioService.save(usuario);

        return "redirect:/users";
    }

    @GetMapping("/{id}/show")
    public String show(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
       try {
           model.addAttribute("usuario", usuarioService.findOrFail(id));
           return "usuarios/show";
       }catch (EntityNotFoundException e) {
           redirectAttributes.addFlashAttribute("msgDanger", e.getMessage());
           return "redirect:/" . concat(ApiPath.USUARIOS);
       }
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("usuario", usuarioService.findOrFail(id));
            return "usuarios/edit";
        }catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("msgDanger", e.getMessage());
            return "redirect:/" . concat(ApiPath.USUARIOS);
        }
    }

    @GetMapping("/{id}/update")
    public String update(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("usuario", usuarioService.findOrFail(id));
            return "usuarios/edit";
        }catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("msgDanger", e.getMessage());
            return "redirect:/" . concat(ApiPath.USUARIOS);
        }
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
           usuarioService.inativarUsuario(id);
            return "usuarios/edit";
        }catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("msgDanger", e.getMessage());
            return "redirect:/" . concat(ApiPath.USUARIOS);
        }
    }


    public String ativarUsuario() {
        return "redirect:" .concat(ApiPath.USUARIOS);
    }

    public String inativarUsuario() {
        return "redirect:" .concat(ApiPath.USUARIOS);
    }

}
