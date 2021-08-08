package com.consumerback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumerback.api.entities.UserRole;

@Repository
public interface UserRoleDao extends JpaRepository<UserRole, Integer> {

}
