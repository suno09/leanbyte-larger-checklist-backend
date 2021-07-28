package de.leanbyte.checklisttask.model;

import com.arangodb.springframework.annotation.Document;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * The checklist model
 */
@Document
@Getter
@Setter
public class CheckList {
    @Id
    private String id;

    private String title = "";

    private String[][] checklists;

    @Override
    public String toString() {
        return "CheckList{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
