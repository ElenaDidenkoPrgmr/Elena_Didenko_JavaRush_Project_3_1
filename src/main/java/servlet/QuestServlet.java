package servlet;

import com.javarush.quest.QuestService;
import com.javarush.quest.Question;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
@WebServlet("/logic")
public class QuestServlet extends HttpServlet {
    private final QuestService questService = new QuestService();
    Map<Integer, Question> questionMap;//= questService.getQuestMap();
    private final int FIRST_QUESTION = 7;
    Map<String, Integer> userRep = new HashMap();


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        questionMap = (Map<Integer, Question>) servletContext.getAttribute("questionMap");

        System.out.println("Init method with ServletConfig ended");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userName = request.getParameter("username");
        if (userName != null) {
            userName.trim();
            if (!userRep.containsKey(userName)) {
                userRep.put(userName, 0);
            }
            synchronized (session) {
                session.setAttribute("username", userName);
            }
        } else {
            userName = (String) request.getSession().getAttribute("username");
        }
        session.setAttribute("statistics", getStatistics(request).toString());

        String requestedQuestion = request.getParameter("requestedQuestion");
        Question currentQuestion;
        if (requestedQuestion != null) {
            currentQuestion = questionMap.get(Integer.parseInt(requestedQuestion));
        } else {
            // currentQuestion = firstQuestion;
            currentQuestion = questionMap.get(FIRST_QUESTION);
        }
        synchronized (session) {
            session.setAttribute("currentQuestion", currentQuestion);
        }

        if (currentQuestion.isLoose() || currentQuestion.isWin()) {
            userRep.put(userName, (userRep.get(userName) + 1));
            getServletContext().getRequestDispatcher("/WEB-INF/endGame.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/quest.jsp").forward(request, response);
        }


    }

    private StringBuilder getStatistics(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return new StringBuilder("User name: ").
                append(session.getAttribute("username")).
                append("<br />").
                append("IP address: ").
                append(request.getRemoteAddr()).
                append("<br />").
                append("Number of games played: ").
                append(userRep.get(session.getAttribute("username")));
    }

}
