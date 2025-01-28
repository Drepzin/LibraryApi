package com.livraria.api.repositorys;

import com.livraria.api.entitys.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

    UserLogin findByUsername(String name);

    UserLogin findByEmail(String email);

}
