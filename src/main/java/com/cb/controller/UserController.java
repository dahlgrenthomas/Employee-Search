package com.cb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.employee.EmployeeRepo;
import com.cb.employee.EmployeeServiceImpl;
import com.cb.model.User;
import com.cb.model.UserEmpList;
import com.cb.repository.UserEmpListRepository;
import com.cb.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEmpListRepository userEmpListRepository;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("")
    public String registrationForm(Model model, @CurrentSecurityContext(expression = "authentication?.name") String username) {
        
        User user = userRepository.findByEmail(username);
        List<UserEmpList> list = userEmpListRepository.findByUserId(user.getId());

        List<Long> ids = list.stream()
                         .map(UserEmpList::getEmployeeId).collect(Collectors.toList());

        model.addAttribute("allemplist", employeeRepo.findAllById(ids));
        
        return "user";
    }

    @GetMapping("/addEmployeeToList/{id}")
    public String addToEmployeeList(@PathVariable(value = "id") Long id, @CurrentSecurityContext(expression = "authentication?.name") String username) {
        User user = userRepository.findByEmail(username);
        UserEmpList userList = new UserEmpList();
        userList.setUserId(user.getId());
        userList.setEmployeeId(id);
        userEmpListRepository.save(userList);
        
        
        return "redirect:/";

    }
    // @GetMapping("/test")
    // public Object registration(@CurrentSecurityContext(expression = "authentication?.name") String username) {
        
    //     return username;

    // }
}
        