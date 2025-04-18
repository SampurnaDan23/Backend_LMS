package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Admin;
import com.example.entity.Employee;
import com.example.entity.LeaveRequest;
import com.example.service.LeaveManagementService;

@RestController
@RequestMapping("/api")
public class LeaveManagementController {

    @Autowired
    private LeaveManagementService leaveManagementService;

    // Admin Endpoints

    @GetMapping("/admins")
    public ResponseEntity<List<Admin>> getAdmins() {
        List<Admin> admins = leaveManagementService.getAllAdmins();
        return ResponseEntity.ok(admins);  // 200 OK
    }
    
    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Integer id) {
        return ResponseEntity.ok(leaveManagementService.getAdminById(id));
    }

    @PostMapping("/admins")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = leaveManagementService.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin); // 201 Created
    }

    @PutMapping("/admins/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id, @RequestBody Admin admin) {
        Admin updatedAdmin = leaveManagementService.updateAdmin(id, admin);
        return ResponseEntity.ok(updatedAdmin); // 200 OK
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer id) {
        leaveManagementService.deleteAdmin(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // Employee Endpoints

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = leaveManagementService.getAllEmployees();
        return ResponseEntity.ok(employees); // 200 OK
    }
    
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok(leaveManagementService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = leaveManagementService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee); // 201 Created
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee updatedEmployee = leaveManagementService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee); // 200 OK
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        leaveManagementService.deleteEmployee(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // Leave Request Endpoints

    @GetMapping("/leave-requests")
    public ResponseEntity<List<LeaveRequest>> getLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveManagementService.getAllLeaveRequests();
        return ResponseEntity.ok(leaveRequests); // 200 OK
    }
    
    @GetMapping("/leave-requests/{id}")
    public ResponseEntity<LeaveRequest> getLeaveRequestById(@PathVariable Integer id) {
        return ResponseEntity.ok(leaveManagementService.getLeaveRequestById(id));
    }

    @PostMapping("/leave-requests")
    public ResponseEntity<LeaveRequest> createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        LeaveRequest createdLeaveRequest = leaveManagementService.createLeaveRequest(leaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeaveRequest); // 201 Created
    }

    @PutMapping("/leave-requests/{id}")
    public ResponseEntity<LeaveRequest> updateLeaveRequest(@PathVariable Integer id, @RequestBody LeaveRequest leaveRequest) {
        LeaveRequest updatedLeaveRequest = leaveManagementService.updateLeaveRequest(id, leaveRequest);
        return ResponseEntity.ok(updatedLeaveRequest); // 200 OK
    }

    @DeleteMapping("/leave-requests/{id}")
    public ResponseEntity<Void> deleteLeaveRequest(@PathVariable Integer id) {
        leaveManagementService.deleteLeaveRequest(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
