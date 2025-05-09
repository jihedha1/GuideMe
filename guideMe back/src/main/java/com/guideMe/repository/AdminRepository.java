package com.guideMe.repository;

import com.guideMe.POJO.administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<administrator,Integer> {
    administrator findByEmail(@Param("email") String email);
}
