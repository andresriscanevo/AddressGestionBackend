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
public class Regions  {
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

    public Regions(Long region_id, String level1_code, String level1_name, String level2_code, String level2_name, String level3_code, String level3_name, String level4_code, String level4_name, boolean active, Timestamp date_created, Timestamp date_update, Timestamp date_delete, Country country) {
        this.region_id = region_id;
        this.level1_code = level1_code;
        this.level1_name = level1_name;
        this.level2_code = level2_code;
        this.level2_name = level2_name;
        this.level3_code = level3_code;
        this.level3_name = level3_name;
        this.level4_code = level4_code;
        this.level4_name = level4_name;
        this.active = active;
        this.date_created = date_created;
        this.date_update = date_update;
        this.date_delete = date_delete;
        this.country = country;
    }

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    public String getLevel1_code() {
        return level1_code;
    }

    public void setLevel1_code(String level1_code) {
        this.level1_code = level1_code;
    }

    public String getLevel1_name() {
        return level1_name;
    }

    public void setLevel1_name(String level1_name) {
        this.level1_name = level1_name;
    }

    public String getLevel2_code() {
        return level2_code;
    }

    public void setLevel2_code(String level2_code) {
        this.level2_code = level2_code;
    }

    public String getLevel2_name() {
        return level2_name;
    }

    public void setLevel2_name(String level2_name) {
        this.level2_name = level2_name;
    }

    public String getLevel3_code() {
        return level3_code;
    }

    public void setLevel3_code(String level3_code) {
        this.level3_code = level3_code;
    }

    public String getLevel3_name() {
        return level3_name;
    }

    public void setLevel3_name(String level3_name) {
        this.level3_name = level3_name;
    }

    public String getLevel4_code() {
        return level4_code;
    }

    public void setLevel4_code(String level4_code) {
        this.level4_code = level4_code;
    }

    public String getLevel4_name() {
        return level4_name;
    }

    public void setLevel4_name(String level4_name) {
        this.level4_name = level4_name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
