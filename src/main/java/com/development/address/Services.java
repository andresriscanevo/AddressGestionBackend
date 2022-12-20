package com.development.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="services")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE services SET active=true where service_id=?")
@FilterDef(
        name = "deletedServicesFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedServicesFilter",
        condition = "deleted = :isDeleted"
)
public class Services {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long service_id;
    @Column(name="service_name",nullable=false)
    private String service_name;

    @Column(name="type_service",nullable=false)
    private String type_service;
    @Column(name="status_service",nullable=false)
    private String status_service;
    @Column(name="active",nullable=false)
    private boolean active=Boolean.FALSE;
    @CreationTimestamp()
    private Timestamp date_created;
    @UpdateTimestamp()
    private Timestamp date_update;

    private Timestamp date_delete;
    @ManyToMany(cascade= {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name="service_zone",
            joinColumns= {@JoinColumn(name="service_identify")},
            inverseJoinColumns= {@JoinColumn(name="zone_identify")}
    )
    private Set<Zones> zoness;
}
