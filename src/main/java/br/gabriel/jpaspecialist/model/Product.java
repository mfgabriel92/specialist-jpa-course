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
    
    @Lob
    private String description;
    
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal price;
    
    @ManyToMany
    @JoinTable(
        name = "products_categories",
        joinColumns = @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_products_categories_products")),
        inverseJoinColumns = @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_products_categories_categories"))
    )
    private List<Category> categories;
    
    @ElementCollection
    @CollectionTable(
        name = "product_tags",
        joinColumns = @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_products_tags"))
    )
    @Column(name = "tag", length = 21)
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
