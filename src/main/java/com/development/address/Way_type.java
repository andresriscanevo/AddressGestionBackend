package com.development.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="way_type")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE way_type SET active=true where way_type_id=?")
@FilterDef(
        name = "deletedWay_typeFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedWay_typeFilter",
        condition = "deleted = :isDeleted"
)
public class Way_type {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long way_type_id;

    @Column(name="way_type_name",nullable=false)
    private String way_type_name;
    @Column(name="way_type_code",nullable=false)
    private String way_type_code;
    @Column(name="active",nullable=false)
    private boolean active=Boolean.FALSE;
    @CreationTimestamp()
    @Column(name="date_created",nullable=true)
    private Timestamp date_created;
    @UpdateTimestamp()
    @Column(name="date_update",nullable=true)
    private Timestamp date_update;
    @Column(name="date_delete",nullable=true)
    private Timestamp date_delete;
    @Column(name="timestamp",nullable=true)
    private Timestamp timestamp;
    @OneToOne(mappedBy="way_type")
    private Address address;

    public Way_type(Long way_type_id, String way_type_name, String way_type_code, boolean active, Timestamp date_created, Timestamp date_update, Timestamp date_delete, Timestamp timestamp, Address address) {
        this.way_type_id = way_type_id;
        this.way_type_name = way_type_name;
        this.way_type_code = way_type_code;
        this.active = active;
        this.date_created = date_created;
        this.date_update = date_update;
        this.date_delete = date_delete;
        this.timestamp = timestamp;
        this.address = address;
    }


}
