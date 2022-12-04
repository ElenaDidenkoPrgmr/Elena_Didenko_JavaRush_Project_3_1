package com.javarush.quest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class Question {

    private int id;
    private String text;
    List<Answer> answers;
    @JsonProperty
    private boolean isWin;
    @JsonProperty
    private boolean isLoose;

    public String[] getAnswersFromQuestion(){
        String[] result = new String[this.getAnswers().size()];
        for (int i = 0; i < this.getAnswers().size(); i++) {
            result[i] = this.getAnswers().get(i).getText();
        }
        return result;
    }
}
