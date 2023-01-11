package com.development.address;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name="zones")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE zones SET active=true where zone_id=?")
@FilterDef(
        name = "deletedZonesFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedZoneFilter",
        condition = "deleted = :isDeleted"
)
public class Zones {
    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long zone_id;
    @ManyToOne(cascade = CascadeType.ALL)
    private City city;
    @Column(name="zone_name",nullable=false)
    private String zone_name;
    @Column(name="active",nullable=false)
    private boolean active=Boolean.FALSE;
    @CreationTimestamp()
    private Timestamp date_created;
    @UpdateTimestamp()
    private Timestamp date_update;

    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;
    private Timestamp zoness;
    @ManyToMany(mappedBy="zoness")
    private Set<Products> productss;
    @ManyToMany(mappedBy="zoness")
    private Set<Services> servicess;
}
