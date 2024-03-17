package application.servlets.student;

import application.dto.StudentDTO;
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

@WebServlet(urlPatterns = "/readStudent")
public class StudentReadServlet extends HttpServlet {

    private final StudentServiceInt studentService = StudentService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(TEXT_HTML);
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(READ_JSP);
        requestDispatcher.include(req, resp);

        int id = Integer.parseInt(req.getParameter(STUDENT_ID));

        try (var writer = resp.getWriter()) {
            StudentDTO studentDTO = studentService.readStudent(id);
            writer.write(
                    studentDTO.getName() +
                            SPACE +
                            studentDTO.getSurname() +
                            SPACE +
                            studentDTO.getAge() +
                            SPACE +
                            studentDTO.getMark() +
                            SPACE +
                            studentDTO.getAddress()
            );
        }
    }
}
