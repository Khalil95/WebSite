package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ClientEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface CommandLineRepository  extends JpaRepository<CommandLineEntity, Integer> {

}
