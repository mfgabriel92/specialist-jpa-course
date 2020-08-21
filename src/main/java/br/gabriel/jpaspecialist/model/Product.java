package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(
    name = "products",
    uniqueConstraints = { @UniqueConstraint(name = "uk_products_name", columnNames = { "name" }) },
    indexes = { @Index(name = "idx_products_name", columnList = "name") }
)
@Getter
@Setter
public class Product extends BaseEntity {
    @Column(length = 100)
    private String name;
    
    @Column(length = 276, nullable = false)
    private String description;
    
    @Column(nullable = false, precision = 7, scale = 2)
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
    @Column(name = "tag", length = 21)
    private List<String> tags;
    
    @Lob
    private byte[] photo;
    
    @ElementCollection
    @CollectionTable(
        name = "product_attributes",
        joinColumns = @JoinColumn(name = "product_id")
    )
    private List<Attribute> attributes;
    
    @OneToOne(mappedBy = "product")
    private Stock stock;
}
