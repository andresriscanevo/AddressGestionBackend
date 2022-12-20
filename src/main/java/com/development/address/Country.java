package com.development.address;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="country")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE country SET active=true where country_id=?")
@FilterDef(
        name = "deletedCountryFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedCountryFilter",
        condition = "deleted = :isDeleted"
)
public class Country {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long country_id;
    @Column(name="country_name",nullable=false)
    private String country_name;
    @Column(name="country_code",nullable=false)
    private String country_code;
    @Column(name="active",nullable=false)
    private boolean active=Boolean.FALSE;
    @OneToMany(mappedBy="country",cascade=CascadeType.ALL)
    private List<Regions> regionss;

    @CreationTimestamp()
    @Column(name="date_created",nullable=true)
    private Timestamp date_created;
    @UpdateTimestamp()
    @Column(name="date_update",nullable=true)
    private Timestamp date_update;
    @Column(name="date_delete",nullable=true)
    private Timestamp date_delete;


}

