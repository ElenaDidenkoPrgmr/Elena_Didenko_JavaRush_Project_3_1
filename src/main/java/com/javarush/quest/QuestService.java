package com.javarush.quest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestService {
    ObjectMapper mapper = new JsonMapper();

    public Map<Integer, Question> getQuestMap() {
        try (InputStream inputStream = getClass().getResourceAsStream("/QA.json");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            Question[] questions = mapper.readValue(contents, Question[].class);
            return Arrays.stream(questions)
                    .collect(Collectors.toMap(Question::getId, Function.identity()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
/*

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
class Question implements Serializable {

    private int id;
    private String text;
    List<Answer> answers;
    @JsonProperty
    private boolean isWin;
    @JsonProperty
    private boolean isLoose;

    public String getText() {
        return text;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
class Answer implements Serializable {
    String text;
    int nextQuestionId;
}
*/
