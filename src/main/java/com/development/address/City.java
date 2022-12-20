package com.development.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="city")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE city SET active=true where city_id=?")
@FilterDef(
        name = "deletedCityFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedCityFilter",
        condition = "deleted = :isDeleted"
)
public class City {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long city_id;

    @Column(name="city_name",nullable=false)
    private String city_name;
    @Column(name="timezone",nullable=false)
    private String timezone;
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
    @OneToMany(mappedBy="city",cascade=CascadeType.ALL)
    private List<Zones> zoness;
    @ManyToOne()
    private Regions regions;

}
