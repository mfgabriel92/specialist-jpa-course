package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "clients")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {
    @Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    @Transient
    private String firstName;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @ElementCollection
    @CollectionTable(
        name = "clients_contacts",
        joinColumns = @JoinColumn(name = "client_id")
    )
    @MapKeyColumn(name = "type")
    @Column(name = "value")
    private Map<String, String> contacts;
    
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
    
    @PostLoad
    private void setFirstName() {
        if (name != null && !name.isBlank()) {
            int index = name.indexOf(" ");
            
            if (index != -1) {
                firstName = name.substring(0, index);
            }
        }
    }
}
