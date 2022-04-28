package com.honchar.naturalid;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.honchar.hibernate.util.SessionUtil;

public class IdTestBase {
    protected SimpleNaturalIdEmployee createSimpleEmployee(
            String name, int badge
    ) {
        SimpleNaturalIdEmployee employee = new SimpleNaturalIdEmployee();
        employee.setName(name);
        employee.setBadge(badge);
        employee.setRoyalty(12.3456789);

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        }
        return employee;
    }

    protected Employee createEmployee(
            String name,
            int section,
            int department
    ) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);
        employee.setSection(section);
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        }
        return employee;
    }
}