package com.example.demo.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;



@Entity
@Table(name = "tb_tr_travel")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travel_id;
    
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date departure;

    private Integer duration;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date go_back;

    private String destination;
    private String transportation;
    private String remarks;
    private String status_manager;
    private String status_hr;



    public Integer getTravel_id() {
        return travel_id;
    }

    public void setTravel_id(Integer travel_id) {
        this.travel_id = travel_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getGo_back() {
        return go_back;
    }

    public void setGo_back(Date go_back) {
        this.go_back = go_back;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus_manager() {
        return status_manager;
    }

    public void setStatus_manager(String status_manager) {
        this.status_manager = status_manager;
    }

    public String getStatus_hr() {
        return status_hr;
    }

    public void setStatus_hr(String status_hr) {
        this.status_hr = status_hr;
    }



    

    
}
