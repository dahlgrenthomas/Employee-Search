package com.cb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(UserEmpId.class)
public class UserEmpList {
    @Id
    private Long userId;

    @Id
    private Long employeeId;

    public long getUserId() {       
        return userId;
    }
    public void setUserId(Long id) {
        this.userId = id;
    }
    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long id) {
        this.employeeId = id;
    }

}

