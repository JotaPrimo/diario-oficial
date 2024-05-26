package com.jotasantos.app.diariooficial.database.seeders;

import org.springframework.boot.CommandLineRunner;


public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        (new RoleSeeder()).populateRoles();
        (new PermissionSeeder()).populatePermissions();
        (new UsuarioSeeder()).populateUsuarios();
    }

}
