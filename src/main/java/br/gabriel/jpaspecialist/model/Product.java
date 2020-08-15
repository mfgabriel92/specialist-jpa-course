package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
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
    @Column(name = "tag")
    private List<String> tags;
    
    @ElementCollection
    @CollectionTable(
        name = "product_attributes",
        joinColumns = @JoinColumn(name = "product_id")
    )
    private List<Attribute> attributes;
    
    @OneToOne(mappedBy = "product")
    private Stock stock;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;
}
