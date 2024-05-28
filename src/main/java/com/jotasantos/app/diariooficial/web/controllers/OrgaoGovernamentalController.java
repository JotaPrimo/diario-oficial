package com.jotasantos.app.diariooficial.web.controllers;

import com.jotasantos.app.diariooficial.config.ApiPath;
import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import com.jotasantos.app.diariooficial.exceptions.handler.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IOrgaoGovernamentalService;
import com.jotasantos.app.diariooficial.web.dtos.orgao_governamentals.OrgaoCreateDTO;
import com.jotasantos.app.diariooficial.web.dtos.orgao_governamentals.OrgaoSearchDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(ApiPath.ORGAOS_GOVERNAMENTAIS)
public class OrgaoGovernamentalController {

    @Autowired
    private IOrgaoGovernamentalService orgaoGovernamentalService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("orgaos", orgaoGovernamentalService.findAll());
        model.addAttribute("orgaoSearchDTO", OrgaoSearchDTO.getNewInstance());
        return "private/orgaos-gov/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("orgaos", orgaoGovernamentalService.findAll());
        model.addAttribute("orgaoCreateDTO", OrgaoCreateDTO.getNewInstance());
        return "private/orgaos-gov/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("orgaoCreateDTO") @Valid OrgaoCreateDTO orgaoCreateDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()) {
                redirectAttributes.addAttribute("msgDanger", "Ocorreu um erro ao cadastrar o cliente");
                return "private/orgaos-gov/create";
            }

            OrgaoGovernamental orgaoGovernamental = OrgaoCreateDTO.toEntity(orgaoCreateDTO);
            orgaoGovernamental.setNome(orgaoGovernamentalService.definirNome(orgaoCreateDTO));
            orgaoGovernamentalService.saveWithEndereco(orgaoGovernamental);

            redirectAttributes.addFlashAttribute("msgSuccess", "Orgão cadastrado com sucesso");
            return "redirect:/diario-oficial/orgaos-governamentais";
        }catch (Exception e) {
            redirectAttributes.addAttribute("msgDanger", "Ocorreu um erro ao cadastrar o cliente");
            return "private/orgaos-gov/create";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("orgao", orgaoGovernamentalService.findOrFail(id));
            return "private/usuarios/edit";
        }catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("msgDanger", e.getMessage());
            return "redirect:/orgaos-gov/index";
        }
    }

    @PutMapping("/{id}/update")
    public String update(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            OrgaoGovernamental orgaoGovernamental = orgaoGovernamentalService.findOrFail(id);
            orgaoGovernamentalService.save(orgaoGovernamental);

            redirectAttributes.addFlashAttribute("msgSuccess", "Orgão governamental atualizado com sucesso");
            return "private/orgaos-gov/index";
        }catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("msgDanger", e.getMessage());
            return "redirect:/orgaos-gov/index";
        }
    }

}
