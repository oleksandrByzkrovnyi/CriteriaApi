package com.example.education.criteria.criteriaCustom.criteriaCustomImpl;

import com.example.education.criteria.criteriaCustom.StaffRepositoryCustom;
import com.example.education.criteria.domain.Department;
import com.example.education.criteria.domain.Position;
import com.example.education.criteria.domain.Staff;
import com.example.education.criteria.domain.Staff_;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Transactional
@Service
public class StaffRepositoryCustomImpl implements StaffRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Staff findByfirstNameAndLastName(String firstName, String lastName) {
        // запрашиваем инстанс билдера запроса
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // создаем пустой запрос определенного типа в который будем всё пихать
        CriteriaQuery<Staff> criteriaQuery = criteriaBuilder.createQuery(Staff.class);

        //то что вернется
        Root<Staff> staffs = criteriaQuery.from(Staff.class);

        //сам запрос
        criteriaQuery.select(staffs).where(criteriaBuilder.equal(staffs.get("firstName"), firstName), criteriaBuilder.equal(staffs.get("lastName"), lastName));
        Query query = entityManager.createQuery(criteriaQuery);
        try {
            Object res = query.getSingleResult();
            System.out.println(res.toString());
            return (Staff) res;
        } catch (NoResultException ex) {
            System.out.println("Result is null");
            return null;
        }
    }

    @Override
    public Long getCountStaffInDept(Integer idDept) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Staff.class);
        Root<Staff> employee = criteriaQuery.from(Staff.class);
        criteriaQuery.select(criteriaBuilder.count(employee)).where(criteriaBuilder.equal(employee.get(Staff_.department), idDept)); //<------
        Query query = entityManager.createQuery(criteriaQuery);
        return (Long) query.getSingleResult();
    }

    @Override
    public List<Staff> findStaffOnPosition(Position position) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Staff> criteriaQuery = criteriaBuilder.createQuery(Staff.class);
        Root<Staff> staffRoot = criteriaQuery.from(Staff.class);
        criteriaQuery.select(staffRoot).where(criteriaBuilder.equal(staffRoot.get(Staff_.position), Position.JUNIOR));
        Query doingQuery = entityManager.createQuery(criteriaQuery);
        return doingQuery.getResultList();

    }

    @Override
    public List<Staff> findStaffWhereNameHas(String part) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Staff> criteriaQuery = criteriaBuilder.createQuery(Staff.class);
        Root<Staff> staffRoot = criteriaQuery.from(Staff.class);
        criteriaQuery.select(staffRoot).where(criteriaBuilder.like(staffRoot.get(Staff_.firstName), part));
        Query doingQuery = entityManager.createQuery(criteriaQuery);
        return (List<Staff>) doingQuery.getResultList();
    }

    @Override
    public List<Staff> findStaffInDept(Integer idDept) {
        return null;
    }

    @Override
    public List<Staff> findStaffWhereSalaryBetween(Integer avg) {
        return null;
    }

    @Override
    public boolean deleteStaffById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteStaffByFirstNameAndLastName(String firstName, String lastName) {
        return false;
    }

    @Override
    public boolean updateNameStaff(String name, Integer id) {
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaUpdate<Staff> criteriaQuery = criteriaBuilder.createCriteriaUpdate(Staff.class);
       Root<Staff> rootStaff = criteriaQuery.from(Staff.class);
       criteriaQuery.set(rootStaff.get(Staff_.firstName),name).where(criteriaBuilder.equal(rootStaff.get(Staff_.id),id));
       try{
           Query doing = entityManager.createQuery(criteriaQuery);
           doing.executeUpdate();
           return true;
       }catch (Exception ex){
           return false;
       }
    }

    @Override
    public List<Object> getAvgSalaryInDept() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //что вернется
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();

        // откуда доставать инфу
        Root<Staff> staffRoot = criteriaQuery.from(Staff.class);

        Join<Staff, Department> join = staffRoot.join("department", JoinType.LEFT);
        criteriaQuery.multiselect(join, criteriaBuilder.avg(staffRoot.get(Staff_.salary))).
                      groupBy(staffRoot.get(Staff_.department));

        try {
            Query doing = entityManager.createQuery(criteriaQuery);
            return doing.getResultList();
        } catch (NoResultException ex) {
            System.out.println("result is null");
            return null;
        }


    }
}
