package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Documents;

@Repository
public interface DocumentsRepository extends JpaRepository<Documents, Integer> {

}
