package com.thanhLee.demoJPA.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name="jobs")
public class JobsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "name")
    private String name ;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate ;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate ;

    @OneToMany(mappedBy = "job")
    Set<TasksEntity> tasks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<TasksEntity> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TasksEntity> tasks) {
        this.tasks = tasks;
    }
}
