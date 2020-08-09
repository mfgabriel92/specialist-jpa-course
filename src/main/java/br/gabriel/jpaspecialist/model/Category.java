package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    @Include
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table")
    @TableGenerator(name = "table", table = "hibernate_sequences", pkColumnName = "sequence_name", pkColumnValue = "category", valueColumnName = "next_val", initialValue = 0, allocationSize = 50)
    @Id
    private Integer id;
    
    private String name;
    
    @Column(name = "parent_category_id")
    private Integer parentCategoryId;
}
