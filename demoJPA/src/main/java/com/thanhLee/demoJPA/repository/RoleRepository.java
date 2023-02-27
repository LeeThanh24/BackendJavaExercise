package com.thanhLee.demoJPA.repository;

import com.thanhLee.demoJPA.dto.RoleDTO;
import com.thanhLee.demoJPA.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RolesEntity,Integer> {
        List<RolesEntity> findByName(String name ) ;

}
