package application.servlets.student;

import application.services.impl.StudentService;
import application.services.interfaces.StudentServiceInt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static application.utils.constant.ServletsConstant.*;

@WebServlet(urlPatterns = "/readAllStudents")
public class StudentGetAllServlet extends HttpServlet {

    private final StudentServiceInt studentService = StudentService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(TEXT_HTML);
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(READ_ALL_JSP);
        requestDispatcher.include(req, resp);

        try (var writer = resp.getWriter()) {
            writer.write(UL_START);
            studentService.getAllStudents().forEach(studentDTO ->
                    writer.write(
                            LI_START +
                                    READ_STUDENT_HIPPER +
                                    studentDTO.getId() +
                                    END +
                                    studentDTO.getName() +
                                    SPACE +
                                    studentDTO.getSurname() +
                                    A_END +
                                    LI_END

                    ));

            writer.write(UL_END);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
