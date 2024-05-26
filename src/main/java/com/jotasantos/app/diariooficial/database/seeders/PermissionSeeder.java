package com.jotasantos.app.diariooficial.database.seeders;

import com.jotasantos.app.diariooficial.database.repositories.IPermissionRepository;
import com.jotasantos.app.diariooficial.entities.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermissionSeeder {

    @Autowired
    private IPermissionRepository permissionRepository;

    public void populatePermissions() {
       createPermissionsOfUsuario();
       createPermissionsOfArquivo();
       createPermissionsOfDiario();
       createPermissionsOfOrgaoGovernamental();
       createPermissionsOfCliente();
       createPermissionsOfEnderecos();
    }

    public void createPermissionsOfUsuario() {
        List<Permission> permissions = new ArrayList<>();
        Permission create_usuario = new Permission();
        create_usuario.setName("create_usuario");
        permissions.add(create_usuario);


        Permission edit_usuario = new Permission();
        edit_usuario.setName("edit_usuario");
        permissions.add(edit_usuario);

        Permission show_usuario = new Permission();
        show_usuario.setName("show_usuario");
        permissions.add(show_usuario);

        Permission inativar_usuario = new Permission();
        inativar_usuario.setName("inativar_usuario");
        permissions.add(inativar_usuario);

        Permission ativar_usuario = new Permission();
        ativar_usuario.setName("ativar_usuario");
        permissions.add(ativar_usuario);


        permissionRepository.saveAll(permissions);
    }

    public void createPermissionsOfArquivo() {
        List<Permission> permissions = new ArrayList<>();
        Permission create_arquivo = new Permission();
        create_arquivo.setName("create_arquivo");
        permissions.add(create_arquivo);

        Permission edit_arquivo = new Permission();
        edit_arquivo.setName("edit_arquivo");
        permissions.add(edit_arquivo);

        Permission show_arquivo = new Permission();
        show_arquivo.setName("show_arquivo");
        permissions.add(show_arquivo);

        Permission delete_arquivo = new Permission();
        delete_arquivo.setName("delete_arquivo");
        permissions.add(delete_arquivo);

        permissionRepository.saveAll(permissions);
    }

    public void createPermissionsOfDiario() {
        List<Permission> permissions = new ArrayList<>();
        Permission create_diario = new Permission();
        create_diario.setName("create_diario");
        permissions.add(create_diario);


        Permission edit_diario = new Permission();
        edit_diario.setName("edit_diario");
        permissions.add(edit_diario);

        Permission show_diario = new Permission();
        show_diario.setName("show_diario");
        permissions.add(show_diario);

        Permission delete_diario = new Permission();
        delete_diario.setName("delete_diario");
        permissions.add(delete_diario);

        permissionRepository.saveAll(permissions);
    }

    public void createPermissionsOfCliente() {
        List<Permission> permissions = new ArrayList<>();
        Permission create_cliente = new Permission();
        create_cliente.setName("create_cliente");
        permissions.add(create_cliente);

        Permission edit_cliente = new Permission();
        edit_cliente.setName("edit_cliente");
        permissions.add(edit_cliente);

        Permission show_cliente = new Permission();
        show_cliente.setName("show_cliente");
        permissions.add(show_cliente);

        Permission delete_cliente = new Permission();
        delete_cliente.setName("delete_cliente");
        permissions.add(delete_cliente);

        permissionRepository.saveAll(permissions);
    }

    public void createPermissionsOfOrgaoGovernamental() {
        List<Permission> permissions = new ArrayList<>();
        Permission create_orgao_governamental = new Permission();
        create_orgao_governamental.setName("create_orgao_governamental");
        permissions.add(create_orgao_governamental);

        Permission edit_orgao_governamental = new Permission();
        edit_orgao_governamental.setName("edit_orgao_governamental");
        permissions.add(edit_orgao_governamental);

        Permission show_orgao_governamental = new Permission();
        show_orgao_governamental.setName("show_orgao_governamental");
        permissions.add(show_orgao_governamental);

        Permission delete_orgao_governamental = new Permission();
        delete_orgao_governamental.setName("delete_orgao_governamental");
        permissions.add(delete_orgao_governamental);

        permissionRepository.saveAll(permissions);
    }

    public void createPermissionsOfEnderecos() {
        List<Permission> permissions = new ArrayList<>();
        Permission create_endereco = new Permission();
        create_endereco.setName("create_endereco");
        permissions.add(create_endereco);

        Permission edit_endereco = new Permission();
        edit_endereco.setName("edit_endereco");
        permissions.add(edit_endereco);

        Permission show_endereco = new Permission();
        show_endereco.setName("show_endereco");
        permissions.add(show_endereco);

        Permission delete_endereco = new Permission();
        delete_endereco.setName("delete_endereco");
        permissions.add(delete_endereco);

        permissionRepository.saveAll(permissions);
    }

}
