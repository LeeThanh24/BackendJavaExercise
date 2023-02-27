package com.thanhLee.demoJPA.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "status")
public class StatusEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name ="name")
    private String name ;

    @OneToMany(mappedBy = "status")
    Set<TasksEntity> tasks;
}
