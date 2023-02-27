package com.thanhLee.demoJPA.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tasks")
public class TasksEntity {
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

    @ManyToOne()
    @JoinColumn(name="user_id")
    private UsersEntity user ;

    @ManyToOne()
    @JoinColumn(name="job_id")
    private JobsEntity job ;

    @ManyToOne()
    @JoinColumn(name="status_id")
    private StatusEntity status ;
}
