package application.dto.address;
import application.dto.people.People;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "peopleSet")
@ToString(exclude = "peopleSet")
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private Integer house;

    @ManyToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<People> peopleSet = new HashSet<>();
}
