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
@Table(name="address")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE address SET active=true where address_id=?")
@FilterDef(
        name = "deletedAddressFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedAddressFilter",
        condition = "deleted = :isDeleted"
)
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="address_id",nullable=false)
    private Long address_id;
    @OneToMany(mappedBy="zone_id",cascade = CascadeType.ALL)

    private List<Zones> zones;



    @ManyToOne
    private Way_type way_type;


    @Column(name="way_main",nullable=false)
    private String way_main;
    @Column(name="way_secondary",nullable=false)
    private String way_secondary;


    @OneToOne(cascade=CascadeType.ALL)
    private Place_type place_type;
    @OneToOne(cascade=CascadeType.ALL)
    private Building_type building_type;

    @Column(name="place",nullable=false)
    private String place;
    @Column(name="addr_txt",nullable=true)
    private String addr_txt;
    @Column(name="latitude",nullable=false)
    private Float latitude;
    @Column(name="longitude",nullable=false)
    private Float longitude;
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
    //Constructor

    public Address(Long address_id, List<Zones> zones, Way_type way_type, String way_main, String way_secondary, Place_type place_type, Building_type building_type, String place, String addr_txt, Float latitude, Float longitude, boolean active, Timestamp date_created, Timestamp date_update, Timestamp date_delete) {
        this.address_id = address_id;
        this.zones = zones;
        this.way_type = way_type;
        this.way_main = way_main;
        this.way_secondary = way_secondary;
        this.place_type = place_type;
        this.building_type = building_type;
        this.place = place;
        this.addr_txt = addr_txt;
        this.latitude = latitude;
        this.longitude = longitude;
        this.active = active;
        this.date_created = date_created;
        this.date_update = date_update;
        this.date_delete = date_delete;
    }


    //generacion de getters y setters


    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public List<Zones> getZones() {
        return zones;
    }

    public void setZones(List<Zones> zones) {
        this.zones = zones;
    }

    public Way_type getWay_type() {
        return way_type;
    }

    public void setWay_type(Way_type way_type) {
        this.way_type = way_type;
    }

    public String getWay_main() {
        return way_main;
    }

    public void setWay_main(String way_main) {
        this.way_main = way_main;
    }

    public String getWay_secondary() {
        return way_secondary;
    }

    public void setWay_secondary(String way_secondary) {
        this.way_secondary = way_secondary;
    }

    public Place_type getPlace_type() {
        return place_type;
    }

    public void setPlace_type(Place_type place_type) {
        this.place_type = place_type;
    }

    public Building_type getBuilding_type() {
        return building_type;
    }

    public void setBuilding_type(Building_type building_type) {
        this.building_type = building_type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddr_txt() {
        return addr_txt;
    }

    public void setAddr_txt(String addr_txt) {
        this.addr_txt = addr_txt;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
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
}
