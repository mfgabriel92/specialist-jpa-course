package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity {
    private String name;
    
    @Lob
    private String description;
    
    private BigDecimal price;
    
    @ManyToMany
    @JoinTable(
        name = "products_categories",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    
    @ElementCollection
    @CollectionTable(
        name = "product_tags",
        joinColumns = @JoinColumn(name = "product_id")
    )
    private List<String> tags;
    
    @Lob
    private byte[] photo;
    
    @ElementCollection
    @CollectionTable(
        name = "product_attributes",
        joinColumns = @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_products_attributes"))
    )
    private List<Attribute> attributes;
    
    @OneToOne(mappedBy = "product")
    private Stock stock;
}
