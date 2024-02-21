package application.dto.people;

import application.dto.address.Address;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private Integer age;

    @ManyToMany(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JoinTable(name = "people_address",
            joinColumns = {@JoinColumn(name = "people_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
        private Set<Address> addressSet = new HashSet<>();
}
