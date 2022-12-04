package com.javarush.quest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    @NoArgsConstructor
    public class Answer implements Serializable {
        String text;
        int nextQuestionId;

       /* @WebServlet(
                name = "MyServlet",
                urlPatterns = {"/hello"}
        )
        public static class HelloServlet extends HttpServlet {

            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                ServletOutputStream out = resp.getOutputStream();
                out.write("hello heroku".getBytes());
                out.flush();
                out.close();
            }

        }*/
    }

