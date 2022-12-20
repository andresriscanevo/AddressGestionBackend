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
@Table(name="regions")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE Regions SET active=true where region_id=?")
@FilterDef(
        name = "deletedRegionsFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedRegionsFilter",
        condition = "deleted = :isDeleted"
)
public class Regions {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long region_id;
    @Column(name="level1_code",nullable=false)
    private String level1_code;
    @Column(name="level1_name",nullable=false)
    private String level1_name;
    @Column(name="level2_code",nullable=false)
    private String level2_code;
    @Column(name="level2_name",nullable=false)
    private String level2_name;
    @Column(name="level3_code",nullable=true)
    private String level3_code;
    @Column(name="level3_name",nullable=true)
    private String level3_name;
    @Column(name="level4_code",nullable=true)
    private String level4_code;
    @Column(name="level4_name",nullable=true)
    private String level4_name;
    @Column(name="active",nullable=false)
    private boolean active=Boolean.FALSE;
    @CreationTimestamp()
    private Timestamp date_created;
    @UpdateTimestamp()
    private Timestamp date_update;

    private Timestamp date_delete;


    @ManyToOne()
    private Country country;


}
