package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "categories",
    uniqueConstraints = { @UniqueConstraint(name = "uk_categories_name", columnNames = { "name" }) }
)
@Getter
@Setter
public class Category extends BaseEntity {
    @Column(length = 50, nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(
        name = "parent_category_id",
        foreignKey = @ForeignKey(name = "fk_categories_categories")
    )
    private Category parentCategory;
    
    @OneToMany(mappedBy = "parentCategory")
    private List<Category> categories = new ArrayList<>();
    
    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();
}
