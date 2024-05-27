package com.jotasantos.app.diariooficial.web.controllers;

import com.jotasantos.app.diariooficial.config.ApiPath;
import com.jotasantos.app.diariooficial.entities.Role;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IRoleService;
import com.jotasantos.app.diariooficial.services.interfaces.IUsuarioService;
import com.jotasantos.app.diariooficial.web.dtos.usuario.UsuarioCreateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(ApiPath.USUARIOS)
public class UsuarioController {

    @Qualifier("usuarioServiceImpl")
    @Autowired
    private IUsuarioService usuarioService;

    @Qualifier("roleServiceImpl")
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAllSortedById());
        return "private/usuarios/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("usuarioCreateDTO", UsuarioCreateDTO.getNewInstance());
        model.addAttribute("roles", roleService.findAll());
        return "private/usuarios/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("usuarioCreateDTO") @Valid UsuarioCreateDTO usuarioCreateDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msgDanger", "Ocorreu um erro");

            return "redirect:/diario-oficial/usuarios/create";
        }

        Role role1 = roleService.findById(Long.parseLong(usuarioCreateDTO.role()));
        usuarioService.save(UsuarioCreateDTO.toEntity(usuarioCreateDTO, role1));
        redirectAttributes.addFlashAttribute("msgSuccess", "Usuário criado com sucesso ");

        return "redirect:/diario-oficial/usuarios";
    }

    @GetMapping("/{id}/show")
    public String show(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
       try {
           model.addAttribute("usuario", usuarioService.findOrFail(id));
           return "/private/usuarios/show";
       }catch (EntityNotFoundException e) {
           redirectAttributes.addFlashAttribute("msgDanger", e.getMessage());
           return "redirect:/" . concat(ApiPath.USUARIOS);
       }
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("usuario", usuarioService.findOrFail(id));
            return "private/usuarios/edit";
        }catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("msgDanger", e.getMessage());
            return "redirect:/" . concat(ApiPath.USUARIOS);
        }
    }

    @PutMapping("/{id}/update")
    public String update(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("usuario", usuarioService.findOrFail(id));
            usuarioService.save(usuarioService.findOrFail(id));
            return "usuarios/edit/" + id;
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
             return "redirect:/diario-oficial/usuarios";
        }
    }


    @PostMapping("/{id}/ativar")
    public String ativarUsuario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.ativarUsuario(id);
            redirectAttributes.addFlashAttribute("msgSuccess", "Usuario inativo com sucesso");
        }catch (Exception exception) {
            redirectAttributes.addFlashAttribute("msgSuccess", "Usuario inativo com sucesso");
        }
        return "redirect:/diario-oficial/usuarios";
    }

    @PostMapping("/{id}/inativar")
    public String inativarUsuario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.inativarUsuario(id);
            redirectAttributes.addFlashAttribute("msgSuccess", "Usuario inativo com sucesso");
        }catch (Exception exception) {
            redirectAttributes.addFlashAttribute("msgDanger", "Ocorreu um erro");
        }
         return "redirect:/diario-oficial/usuarios";
    }

}
