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
@Table(name="products")
//aplicacion del borrado logico en la base de datos con la variable active
@SQLDelete(sql = "UPDATE products SET active=true where product_id=?")
@FilterDef(
        name = "deletedProductsFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedProductsFilter",
        condition = "deleted = :isDeleted"
)
public class Products {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long product_id;
    @Column(name="product_name",nullable=false)
    private String product_name;

    @Column(name="category_name",nullable=false)
    private String category_name;
    @Column(name="stock")
    private long stock;
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
            name="product_zone",
            joinColumns= {@JoinColumn(name="product_identify")},
            inverseJoinColumns= {@JoinColumn(name="zone_identify")}
    )
    private Set<Zones> zoness;
}
