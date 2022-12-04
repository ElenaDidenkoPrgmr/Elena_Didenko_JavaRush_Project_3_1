package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.javarush.quest.Question;
import com.javarush.quest.QuestionRepo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        QuestionRepo questionRepo = new QuestionRepo();

        ObjectMapper mapper = new JsonMapper();

        try (InputStream inputStream = getClass().getResourceAsStream("/QA.json");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            Question[] questions = mapper.readValue(contents, Question[].class);
            questionRepo.questions =  Arrays.stream(questions)
                    .collect(Collectors.toMap(Question::getId, Function.identity()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        servletContext.setAttribute("questionMap", questionRepo.questions);
    }
}
