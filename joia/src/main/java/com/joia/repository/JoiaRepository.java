package com.joia.repository;

import com.joia.entity.JoiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoiaRepository extends JpaRepository<JoiaEntity, Long> {

    List<JoiaEntity> findByNomeIgnoreCaseContaining(String nome);
}
