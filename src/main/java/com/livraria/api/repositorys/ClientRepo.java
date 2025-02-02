package com.livraria.api.repositorys;

import com.livraria.api.entitys.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {

    Client findByClientId(String id);
}
