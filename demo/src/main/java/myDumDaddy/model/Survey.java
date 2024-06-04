package myDumDaddy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    @Id
    private String surveyQuestionId;
    private String productCode;
    private String surveyCategory;
    private String surveyDescription;
    private String surveyQuestion;
    private String created;
    private String updated;
}
