package com.development.controller;

import com.development.address.Address;
import com.development.address.City;
import com.development.address.Regions;
import com.development.dto.AddressDTO;
import com.development.dto.CityDTO;
import com.development.dto.CountryDTO;
import com.development.dto.RegionsDTO;
import com.development.exceptions.ResourceNotFoundException;
import com.development.mapstruct.MapStructMapper;
import com.development.repository.Address_repository;
import com.development.repository.Country_repository;
import com.development.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/caddress")
@CrossOrigin(origins="*")
public class ControllerAddress {
    @Autowired
    private DataSource dataSource;
    private final MapStructMapper mapstructMapper;
    private final Address_repository addressRepository;
    private final Country_repository countryRepository;

    private final AddressService addressService;
    @Autowired
    public ControllerAddress(
            MapStructMapper mapstructMapper,
            Address_repository addressRepository,
            AddressService addressService,
            Country_repository countryRepository
    ) {
        this.mapstructMapper= mapstructMapper;
        this.addressRepository=addressRepository;
        this.addressService=addressService;
        this.countryRepository=countryRepository;
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
        Date currentDate= new Date();
        Timestamp timestamp= new Timestamp(currentDate.getTime());
        address.setActive(true);
        address.setDate_delete(timestamp);
        addressRepository.save(address);
        return ResponseEntity.ok(mapstructMapper.addressToAddressDTO(address));
    }
    // filtro de regions en un pais
    @GetMapping(value="/regbycountry")
    public ResponseEntity<List<RegionsDTO>> getRegByCountry(@RequestParam("country_name") String country){
        List<Regions> regions=addressService.getRegionsByCountry(country);
        List<RegionsDTO> regionsDTOS= mapstructMapper.RegionsToRegionsAllDTO(regions);
        return ResponseEntity.ok(regionsDTOS);
    }
    //filtrado por ciudad
    @GetMapping(value="/citybyreg")
    public ResponseEntity<List<CityDTO>> getRegByCity(@RequestParam("region_name") String city){
        List<City> cities=addressService.getCityByRegion(city);
        List<CityDTO> cityDTOS= mapstructMapper.CityToCityAllDTO(cities);
        return ResponseEntity.ok(cityDTOS);
    }
    // Este metodo hara un post de country que trae consigo region city y zone y por ende los metodos crud
    @PostMapping(value="createcountry")
    public ResponseEntity<Void> createcountry(
            @Valid @RequestBody CountryDTO countryDTO
    ){
        countryRepository.save(mapstructMapper.countryDTOToCountry(countryDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "exportfile")
    public ResponseEntity<String> exportdata(@RequestParam String tablename,@RequestParam String filename) throws Exception{
        addressService.exportdata(tablename,filename);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
