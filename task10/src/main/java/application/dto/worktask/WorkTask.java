package application.dto.worktask;

import application.dto.task.Task;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_task")
public class WorkTask extends Task {
    @Column
    private Double cost;
}
