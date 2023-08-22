// package com.example.demo;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.example.demo.entities.Department;
// import com.example.demo.entities.Region;
// import com.example.demo.services.DepartmentService;
// import com.example.demo.services.RegionService;

// @SpringBootTest
// public class Testing {
    
//     @Autowired
//     private DepartmentService departmentService;

//     @Autowired
//     private RegionService regionService;

//     @Test
//     public void Save() {
//         Boolean expected=true;
//         Region region = regionService.Get(2);
//         Department department = new Department();
//         department.setDepartment_id(1);
//         department.setName("Finance");
//         department.setRegion_id(region);
//         Boolean result = departmentService.Save(department);
//         assertEquals(expected,result);
//     }
// }
