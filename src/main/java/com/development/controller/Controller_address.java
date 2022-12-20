package com.development.controller;

import com.development.address.Address;
import com.development.dto.AddressDTO;
import com.development.exceptions.ResourceNotFoundException;
import com.development.mapstruct.MapStructMapper;
import com.development.repository.Address_repository;
import com.development.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/caddress")
public class Controller_address {

    private final MapStructMapper mapstructMapper;
    private final Address_repository addressRepository;
    private AddressService addressService;
    @Autowired
    public Controller_address(
            MapStructMapper mapstructMapper,
            Address_repository addressRepository,
            AddressService addressService
    ) {
        this.mapstructMapper= mapstructMapper;
        this.addressRepository=addressRepository;
        this.addressService=addressService;
    }
    @PostMapping()
    public ResponseEntity<Void> create(
            @Valid @RequestBody AddressDTO addressDTO
    ){
        addressRepository.save(mapstructMapper.addressDTOToAddress(addressDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //peticion con todos los atributos
    @GetMapping("/getlist")
    public ResponseEntity<List<AddressDTO>> getAll(){
        return new ResponseEntity<>(
                mapstructMapper.addressToAddressAllDTO(addressRepository.findAll()
                ),HttpStatus.OK
        );
    }
    //peticion con la marca de borrado en la db
    @GetMapping(value="/listdeleted")
    public ResponseEntity<List<AddressDTO>> getAllfilter(@RequestParam(value="isDeleted",required=false,defaultValue = "false") boolean isDeleted){
        List<Address> addressList = addressService.findAddressFilter(isDeleted);
        return new ResponseEntity<>(mapstructMapper.addressToAddressAllDTO(addressList),HttpStatus.OK);
    }
    //endpoint para false que indica las direcciones activas de la lista
    //http://localhost:8080/caddress/listdeleted?isDeleted=false
    //endpoint para true que indica las direcciones eliminadas de la lista
    //http://localhost:8080/caddress/listdeleted?isDeleted=true

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getById(
            @PathVariable(value = "id") Long address_id
    ){
        Address address=addressRepository.findById(address_id).orElseThrow(()-> new ResourceNotFoundException("Address not found with id "+address_id));
        address.setActive(true);
        addressRepository.save(address);
        return ResponseEntity.ok(mapstructMapper.addressToAddressDTO(address));
    }
    @PutMapping("/update/{address_id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable Long address_id,@Valid @RequestBody AddressDTO addressDTO){
        Address address=addressRepository.findById(address_id).orElseThrow(() -> new ResourceNotFoundException("Address not found with id " + address_id));
        address=mapstructMapper.addressDTOToAddress(addressDTO);
        address=addressRepository.save(address);
        return ResponseEntity.ok(mapstructMapper.addressToAddressDTO(address));
    }

    @DeleteMapping("/delete/{address_id}")
    public ResponseEntity<AddressDTO> deleteaddress(@PathVariable Long address_id){
        Address address = addressRepository.findById(address_id).orElseThrow(()-> new ResourceNotFoundException("Address not found with id "+address_id));
        address.setActive(true);
        addressRepository.save(address);
        return ResponseEntity.ok(mapstructMapper.addressToAddressDTO(address));
    }



}
