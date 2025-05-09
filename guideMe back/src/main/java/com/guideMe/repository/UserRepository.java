//Contient les interfaces qui étendent JpaRepository ou CrudRepository. Elles servent à faire le lien avec la base de données
package com.guideMe.repository;

import com.guideMe.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(@Param("email") String email);
}
