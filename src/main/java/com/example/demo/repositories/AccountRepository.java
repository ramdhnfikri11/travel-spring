package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;
// import com.example.demo.dto.LoginResponse;
import com.example.demo.entities.User;

@Repository
public interface AccountRepository extends JpaRepository<Employee,Integer>{
    // pakai prosedure
    @Query(value = "select u from User u join u.employee e where e.email = ?1")
    public User login(String Email);

    // bisa pake native query tapi pakai dto
    // @Query(value = "Select e.email, u.password, r.name from tb_m_user u join tb_m_employee e on e.employee_id = u.user_id join tb_m_role r on r.role_id=e.role_id where e.email = ?1", nativeQuery = true)
    // public LoginResponse login(String email);
}
