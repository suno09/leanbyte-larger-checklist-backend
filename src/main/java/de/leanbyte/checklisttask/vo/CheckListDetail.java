package de.leanbyte.checklisttask.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckListDetail {
    private String id;
    private String title;
    private CheckListLevel[] checklists;

    @Override
    public String toString() {
        return "CheckListDetail{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
