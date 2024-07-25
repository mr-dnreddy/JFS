package com.dn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dn.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
