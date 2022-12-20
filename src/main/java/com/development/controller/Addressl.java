package com.development.controller;



public class Addressl {

    private int id;

    private String address_txt;

    private String zona_name;

    private String city_name;

    private String region_name_l1;

    private String region_name_l2;

    private String name_country;
    public Addressl( int id,  String address_txt, String zona_name,
                     String city_name,  String region_name_l1,  String region_name_l2,
                     String name_country) {

        this.id = id;
        this.address_txt = address_txt;
        this.zona_name = zona_name;
        this.city_name = city_name;
        this.region_name_l1 = region_name_l1;
        this.region_name_l2 = region_name_l2;
        this.name_country = name_country;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress_txt() {
        return address_txt;
    }
    public void setAddress_txt(String address_txt) {
        this.address_txt = address_txt;
    }
    public String getZona_name() {
        return zona_name;
    }
    public void setZona_name(String zona_name) {
        this.zona_name = zona_name;
    }
    public String getCity_name() {
        return city_name;
    }
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
    public String getRegion_name_l1() {
        return region_name_l1;
    }
    public void setRegion_name_l1(String region_name_l1) {
        this.region_name_l1 = region_name_l1;
    }
    public String getRegion_name_l2() {
        return region_name_l2;
    }
    public void setRegion_name_l2(String region_name_l2) {
        this.region_name_l2 = region_name_l2;
    }
    public String getName_country() {
        return name_country;
    }
    public void setName_country(String name_country) {
        this.name_country = name_country;
    }

}
