package com.example.spring_test.repository;

import com.example.spring_test.model.entity.hw3_data;
import com.example.spring_test.parameter.HW3DataQueryParameter;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class HW3DataDAO {
    private final List<hw3_data> data3DB = new ArrayList<>();

    @PostConstruct
    private void initDB() {
        data3DB.add(new hw3_data("7369", "smith", "clerk", "7902", "800", "20"));
        data3DB.add(new hw3_data("7499", "allen", "salesman", "7698", "1600", "30"));
        data3DB.add(new hw3_data("7521", "ward", "salesman", "7698", "1250", "30"));
        data3DB.add(new hw3_data("7566", "jones", "manager", "7839", "2975", "20"));
        data3DB.add(new hw3_data("7902", "ford", "analyst", "7566", "3000", "20"));
        data3DB.add(new hw3_data("7698", "blake", "manager", "7839", "2850", "30"));
        data3DB.add(new hw3_data("7839", "king", "president", "7689", "5000", "10"));
    }

    public hw3_data insert(hw3_data data3) {
        data3DB.add(data3);
        return data3;
    }

    public hw3_data replace(String empno, hw3_data data3) {
        Optional<hw3_data> hw3_dataOp = find(empno);
        hw3_dataOp.ifPresent(p -> {
            p.setEname(data3.getEname());
            p.setJob(data3.getJob());
            p.setMgr(data3.getMgr());
            p.setSalary(data3.getSalary());
            p.setDeptno(data3.getDeptno());
        });

        return data3;
    }

    public void delete(String empno) {
        data3DB.removeIf(p -> p.getEmpno().equals(empno));
    }

    public Optional<hw3_data> find(String empno) {
        return data3DB.stream()
                .filter(p -> p.getEmpno().equals(empno))
                .findFirst();
    }

    public List<hw3_data> find(HW3DataQueryParameter param) {
        String keyword = Optional.ofNullable(param.getKeyword()).orElse("");
        String orderBy = param.getOrderBy();
        String sortRule = param.getSortRule();
        Comparator<hw3_data> comparator = genSortComparator(orderBy, sortRule);

        return data3DB.stream()
                .filter(p -> p.getEname().contains(keyword))
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private Comparator<hw3_data> genSortComparator(String orderBy, String sortRule) {
        Comparator<hw3_data> comparator = (p1, p2) -> 0;
        if (Objects.isNull(orderBy) || Objects.isNull(sortRule)) {
            return comparator;
        }

        if (orderBy.equalsIgnoreCase("ename")) {
            comparator = Comparator.comparing(hw3_data::getEname);
        } else if (orderBy.equalsIgnoreCase("job")) {
            comparator = Comparator.comparing(hw3_data::getJob);
        } else if (orderBy.equalsIgnoreCase("mgr")) {
            comparator = Comparator.comparing(hw3_data::getMgr);
        } else if (orderBy.equalsIgnoreCase("salary")) {
            comparator = Comparator.comparing(hw3_data::getSalary);
        } else if (orderBy.equalsIgnoreCase("deptno")) {
            comparator = Comparator.comparing(hw3_data::getDeptno);
        }

        return sortRule.equalsIgnoreCase("desc")
                ? comparator.reversed()
                : comparator;
    }
}
