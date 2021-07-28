package de.leanbyte.checklisttask.model;

import com.arangodb.springframework.annotation.Document;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * The checklistGroup model
 */
@Document
@Getter
@Setter
public class CheckListGroup {
    @Id
    private String id;

    private String title;

    private String[][] checklists;

    @Override
    public String toString() {
        return "CheckListGroup{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
