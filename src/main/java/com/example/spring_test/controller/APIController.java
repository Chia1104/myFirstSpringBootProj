package com.example.spring_test.controller;

import com.example.spring_test.model.entity.hw3_data;
import com.example.spring_test.model.parameter.HW3DataQueryParameter;
import com.example.spring_test.model.service.HW3DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIController {
    private final HW3DataService data3Service;

    public APIController(HW3DataService data3Service) {
        this.data3Service = data3Service;
    }

    @GetMapping("hw3/{empno}")
    public ResponseEntity<hw3_data> getEmployee(@PathVariable("empno") String empno) {
        hw3_data data3 = data3Service.getEmployee(empno);
        return ResponseEntity.ok(data3);
    }

    @GetMapping("hw3")
    public ResponseEntity<List<hw3_data>> getEmployee(@ModelAttribute HW3DataQueryParameter param) {
        List<hw3_data> data3 = data3Service.getEmployee(param);
        return ResponseEntity.ok(data3);
    }

    @PostMapping("/hw3")
    public ResponseEntity<hw3_data> createEmployee(@RequestBody hw3_data request) {
        hw3_data data3 = data3Service.createEmployee(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{empno}")
                .buildAndExpand(data3.getEmpno())
                .toUri();

        return ResponseEntity.created(location).body(data3);
    }

    @PutMapping("/hw3/{empno}")
    public ResponseEntity<hw3_data> replaceEmployee(
            @PathVariable("empno") String empno, @RequestBody hw3_data request) {
        hw3_data data3 = data3Service.replaceEmployee(empno, request);
        return ResponseEntity.ok(data3);
    }

    @DeleteMapping("/hw3/{empno}")
    public ResponseEntity deleteEmployee(@PathVariable("empno") String empno) {
        data3Service.deleteEmployee(empno);
        return ResponseEntity.noContent().build();
    }
}
