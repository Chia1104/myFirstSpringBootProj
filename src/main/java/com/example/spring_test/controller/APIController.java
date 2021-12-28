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
@RequestMapping(value = "hw3api", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIController {
    @Autowired
    private HW3DataService data3Service;

    @GetMapping("/{empno}")
    public ResponseEntity<hw3_data> getEmployee(@PathVariable("empno") String empno) {
        hw3_data data3 = data3Service.getEmployee(empno);
        return ResponseEntity.ok(data3);
    }

    @GetMapping
    public ResponseEntity<List<hw3_data>> getEmployee(@ModelAttribute HW3DataQueryParameter param) {
        List<hw3_data> data3 = data3Service.getEmployee(param);
        return ResponseEntity.ok(data3);
    }

    @PostMapping
    public ResponseEntity<hw3_data> createProduct(@RequestBody hw3_data request) {
        hw3_data data3 = data3Service.createEmployee(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{empno}")
                .buildAndExpand(data3.getEmpno())
                .toUri();

        return ResponseEntity.created(location).body(data3);
    }

    @PutMapping("/{empno}")
    public ResponseEntity<hw3_data> replaceProduct(
            @PathVariable("empno") String empno, @RequestBody hw3_data request) {
        hw3_data data3 = data3Service.replaceEmployee(empno, request);
        return ResponseEntity.ok(data3);
    }

    @DeleteMapping("/{empno}")
    public ResponseEntity deleteProduct(@PathVariable("empno") String empno) {
        data3Service.deleteEmployee(empno);
        return ResponseEntity.noContent().build();
    }
}
