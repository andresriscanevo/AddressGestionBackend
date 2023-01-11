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

    public Country(Long country_id, String country_name, String country_code, boolean active, List<Regions> regionss, Timestamp date_created, Timestamp date_update, Timestamp date_delete) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.country_code = country_code;
        this.active = active;
        this.regionss = regionss;
        this.date_created = date_created;
        this.date_update = date_update;
        this.date_delete = date_delete;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Regions> getRegionss() {
        return regionss;
    }

    public void setRegionss(List<Regions> regionss) {
        this.regionss = regionss;
    }

    public Timestamp getDate_created() {
        return date_created;
    }

    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }

    public Timestamp getDate_update() {
        return date_update;
    }

    public void setDate_update(Timestamp date_update) {
        this.date_update = date_update;
    }

    public Timestamp getDate_delete() {
        return date_delete;
    }

    public void setDate_delete(Timestamp date_delete) {
        this.date_delete = date_delete;
    }
}

