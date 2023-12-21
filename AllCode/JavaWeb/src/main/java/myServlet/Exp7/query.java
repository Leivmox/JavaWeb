package myServlet.Exp7;

import beans.Student2;
import conn.queryCusDao;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/query.do")
public class query extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//解决post中文乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 获取输入参数
        String name = request.getParameter("name");

        // 创建学生对象
        Student2 student2 = new Student2();
        student2.setName(name);


        // 调用DAO查询数据库
        queryCusDao dao = new queryCusDao();
        List<Student2> students = null;
        try {
            students = dao.query(student2);


            // 遍历查询结果
            for (Student2 student1 : students) {
                out.print("<tr>");
                out.print("<td>" + student1.getId() + "</td>");
                out.print("<td>" + student1.getName() + "</td>");
                out.print("<td>" + student1.getAge() + "</td>");
                out.print("</tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
