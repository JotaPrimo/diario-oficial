package com.jotasantos.app.diariooficial.web.controllers;

import com.jotasantos.app.diariooficial.config.ApiPath;
import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import com.jotasantos.app.diariooficial.entities.Role;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.services.interfaces.IClienteService;
import com.jotasantos.app.diariooficial.services.interfaces.IOrgaoGovernamentalService;
import com.jotasantos.app.diariooficial.services.interfaces.IRoleService;
import com.jotasantos.app.diariooficial.services.interfaces.IUsuarioService;
import com.jotasantos.app.diariooficial.web.dtos.cliente.ClienteCreateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
