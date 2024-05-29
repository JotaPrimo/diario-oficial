package com.jotasantos.app.diariooficial.web.controllers;

import com.jotasantos.app.diariooficial.config.ApiPath;
import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import com.jotasantos.app.diariooficial.entities.Role;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import com.jotasantos.app.diariooficial.services.interfaces.IClienteService;
import com.jotasantos.app.diariooficial.services.interfaces.IOrgaoGovernamentalService;
import com.jotasantos.app.diariooficial.services.interfaces.IRoleService;
import com.jotasantos.app.diariooficial.services.interfaces.IUsuarioService;
import com.jotasantos.app.diariooficial.web.dtos.implementations.cliente.ClienteCreateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(ApiPath.CLIENTE)
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @Qualifier("roleServiceImpl")
    @Autowired
    private IRoleService roleService;

    @Qualifier("usuarioServiceImpl")
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IOrgaoGovernamentalService orgaoGovernamentalService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("status", EnumStatusUsuario.getAllEnumStatus());
        model.addAttribute("clientes", clienteService.findAllSortedById());
        return "private/clientes/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("cliente_create_dto", ClienteCreateDTO.getNewInstance());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("orgaos_gov", orgaoGovernamentalService.findAll());
        return "private/clientes/create";
    }

    @GetMapping("/{id}/show")
    public String show(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
        try {
            model.addAttribute("cliente", clienteService.findOrFail(id));
            return "private/clientes/show";
        }catch (Exception exception) {
            redirectAttributes.addFlashAttribute("msgDanger", "Cliente não encontrado");
            return "redirect:/diario-oficial/clientes/index";
        }
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("clienteCreateDTO") @Valid ClienteCreateDTO clienteCreateDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("msgDanger", "Ocorreu um erro");

                return "redirect:/diario-oficial/clientes/create";
            }

            OrgaoGovernamental orgaoGovernamental = orgaoGovernamentalService.findById(Long.parseLong(clienteCreateDTO.id_orgao_gov()));
            Role role = roleService.findById(Long.parseLong(clienteCreateDTO.role()));

            clienteService.createClienteUser(ClienteCreateDTO.toEntity(clienteCreateDTO, role, orgaoGovernamental));

            redirectAttributes.addFlashAttribute("msgSuccess", "Cliente criado com sucesso ");

            return "redirect:/diario-oficial/clientes";
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgDanger", e.getMessage());
            return "redirect:/diario-oficial/clientes";
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
