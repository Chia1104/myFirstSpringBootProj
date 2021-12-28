package com.example.spring_test.model.service;

import com.example.spring_test.controller.exception.NotFoundException;
import com.example.spring_test.controller.exception.UnprocessableEntityException;
import com.example.spring_test.model.dao.HW3DataDAO;
import com.example.spring_test.model.entity.hw3_data;
import com.example.spring_test.model.parameter.HW3DataQueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HW3DataService {

    @Autowired
    private HW3DataDAO data3DAO;

    public hw3_data createEmployee(hw3_data request) {
        boolean isIdDuplicated = data3DAO.find(request.getEmpno()).isPresent();
        if (isIdDuplicated) {
            throw new UnprocessableEntityException("The id of the employee is duplicated.");
        }

        hw3_data data3 = new hw3_data();
        data3.setEmpno(request.getEmpno());
        data3.setEname(request.getEname());
        data3.setJob(request.getJob());
        data3.setMgr(request.getMgr());
        data3.setSalary(request.getSalary());
        data3.setDeptno(request.getDeptno());

        return data3DAO.insert(data3);
    }

    public hw3_data getEmployee(String empno) {
        return data3DAO.find(empno)
                .orElseThrow(() -> new NotFoundException("Can't find employee."));
    }

    public hw3_data replaceEmployee(String empno, hw3_data request) {
        hw3_data data3 = getEmployee(empno);
        return data3DAO.replace(data3.getEmpno(), request);
    }

    public void deleteEmployee(String empno) {
        hw3_data data3 = getEmployee(empno);
        data3DAO.delete(data3.getEmpno());
    }

    public List<hw3_data> getEmployee(HW3DataQueryParameter param) {
        return data3DAO.find(param);
    }
}
