package com.durgesh.ecommerce.repo;

import com.durgesh.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String email);
    User findFirstByEmailAndPassword(String email,String password);
}
