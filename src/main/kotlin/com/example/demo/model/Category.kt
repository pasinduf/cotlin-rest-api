package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "category")
 class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null;

    var name:String?=null;

    var description:String?=null;

    @Column(name = "createddate")
    var createdDate:Date?=null;

    @Column(name = "isactive")
    var isActive :Boolean=true;


}
