package com.cb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cb.model.UserEmpId;
import com.cb.model.UserEmpList;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserEmpListRepository extends CrudRepository<UserEmpList, UserEmpId> {
        //Code to run custom queries on MySQL
        // @Query(value="SELECT * FROM user WHERE name LIKE '%Thomas%'", nativeQuery=true)
        // public List<User> findAll2();

        // @Query(value="SELECT employeeId FROM user_emp_list WHERE userId=CONCAT('%',:num,'%')", nativeQuery=true)
        // public Iterable<UserEmpList> findAllEmp(@Param("long") Long num);

        List<UserEmpList> findByUserId(long userId);

        
}
