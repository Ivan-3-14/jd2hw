package application.dto.hometask;
import application.address.Address;

import application.dto.task.Task;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "home_task")
public class HomeTask extends Task {

    @CreationTimestamp
    @Column(name = "start_date",
            updatable = false)
    private Timestamp  startDate;

    @UpdateTimestamp
    @Column(name = "end_date",
            insertable = false)
    private Timestamp endDate;

    @Embedded
    private Address address;
}
