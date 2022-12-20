package com.development.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Timestamp;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="building_type")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE building_type SET active=true where building_type_id=?")
@FilterDef(
        name = "deletedBuilding_typeFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedBuilding_typeFilter",
        condition = "deleted = :isDeleted"
)
public class Building_type {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long building_type_id;
    @Column(name="building_type_name",nullable=false)
    private String building_type_name;
    @Column(name="building_type_code",nullable=false)
    private String building_type_code;

    @Column(name="building_type_use",nullable=false)
    private String building_type_use;
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
    @OneToOne(mappedBy="building_type")
    private Address address;


}
