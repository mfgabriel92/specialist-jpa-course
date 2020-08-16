package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(
    name = "clients",
    uniqueConstraints = { @UniqueConstraint(name = "uk_clients_cpf", columnNames = { "cpf" }) },
    indexes = { @Index(name = "idx_clients_name", columnList = "name") }
)
@SecondaryTable(name = "clients_details", pkJoinColumns = @PrimaryKeyJoinColumn(name = "client_id"))
@Setter
@Getter
public class Client extends BaseEntity {
    private String name;
    
    private String cpf;
    
    @Transient
    private String firstName;
    
    @Enumerated(EnumType.STRING)
    @Column(table = "clients_details")
    private Gender gender;
    
    @Column(table = "clients_details")
    private LocalDate birthdate;
    
    @ElementCollection
    @CollectionTable(name = "clients_contacts", joinColumns = @JoinColumn(name = "client_id"))
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
