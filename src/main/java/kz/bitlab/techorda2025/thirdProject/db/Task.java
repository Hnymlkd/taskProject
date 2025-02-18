package kz.bitlab.techorda2025.thirdProject.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Task {
    private Long id;
    private String name;
    private String deadlineDate;
    private boolean isCompleted;
}
