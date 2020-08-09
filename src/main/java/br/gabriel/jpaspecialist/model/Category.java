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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "pks_seq")
    @Id
    private Integer id;
    
    private String name;
    
    @Column(name = "parent_category_id")
    private Integer parentCategoryId;
}
