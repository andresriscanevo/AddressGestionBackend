package com.development.controller;


import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
//Controlador de prueba para el servicio base del requerimiento 03
@RestController
@RequestMapping(value="/address")
@CrossOrigin(origins="http://localhost:4200/")
public class controller {
    private static final List<Addressl> adrlist= new ArrayList<Addressl>();
    static {
        adrlist.add(new Addressl(21,"calle 5#4-25 barrio el tin","norte","bogota","dc","cundinamarca","Colombia"));
        adrlist.add(new Addressl(22,"calle 10#20-12 vereda sau","sur","madrid","mun","cundinamarca","Colombia"));
    }
    @GetMapping("/obtain")
    public List<Addressl> getAddressl(){
        return adrlist;
    }
    @PostMapping("/create")
    public void addAddressl(@RequestBody @Valid Addressl addressl){
        adrlist.add(addressl);
    }

}
