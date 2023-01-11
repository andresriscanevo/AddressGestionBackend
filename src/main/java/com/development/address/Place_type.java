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
@Getter
@Setter
@Entity
@Table(name="place_type")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE place_type SET active=true where place_type_id=?")
@FilterDef(
        name = "deletedPlacetypeFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedPlacetypeFilter",
        condition = "deleted = :isDeleted"
)
public class Place_type {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long place_type_id;
    @Column(name="place_type_name",nullable=false)
    private String place_type_name;
    @Column(name="place_type_code",nullable=false)
    private String place_type_code;

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
    @OneToOne(mappedBy="place_type")
    private Address address;



}
