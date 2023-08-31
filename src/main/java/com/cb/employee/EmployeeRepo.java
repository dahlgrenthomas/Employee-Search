package com.cb.employee;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
        //Code to run custom queries on MySQL
        // @Query(value="SELECT * FROM user WHERE name LIKE '%Thomas%'", nativeQuery=true)
        // public List<User> findAll2();
}