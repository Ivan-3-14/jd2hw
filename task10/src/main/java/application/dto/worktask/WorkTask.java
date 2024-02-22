package application.dto.worktask;

import application.dto.task.Task;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "work_task")
@PrimaryKeyJoinColumn(name = "task_id")
public class WorkTask extends Task {
    @Column
    private Double cost;
}
