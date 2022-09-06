package com.faouzi.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faouzi.webapp.model.Employee;
import com.faouzi.webapp.repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeProxy employeeProxy;
    
    //Recuperer un employee
    public Employee getEmployee(final int id) {
        return employeeProxy.getEmployee(id);
    }
    
    //Recuperer tous les employees
    public Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }
    
    //Supprimer un employee
    public void deleteEmployee(final int id) {
        employeeProxy.deleteEmployee(id);;
    }
    
    //Enregistrer un employee
    public Employee saveEmployee(Employee employee) {
    	Employee savedEmployee;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        employee.setLastName(employee.getLastName().toUpperCase());

        if(employee.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedEmployee = employeeProxy.createEmployee(employee);
        } else {
            savedEmployee = employeeProxy.updateEmployee(employee);
        }
    
        return savedEmployee;
    }

}