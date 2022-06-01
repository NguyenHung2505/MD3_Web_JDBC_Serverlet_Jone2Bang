package controller;

import model.HocSinh;
import model.Lop;
import service.HocSinhServiceImpl;
import service.HocSinhservice;
import service.Lopservice;
import service.LopserviceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    Lopservice lopservice = new LopserviceImpl();
    HocSinhservice hocSinhservice = new HocSinhServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classId = request.getParameter("classId");
        String findName = request.getParameter("findName");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        List<Lop> lopsa = lopservice.findAll();
        request.setAttribute("lops",lopsa);
        List<HocSinh> hocSinhs = hocSinhservice.findAll();
        if(classId != null){
            hocSinhs = hocSinhservice.findAllByClass(Integer.parseInt(classId));
        }
        if(findName != null){
            hocSinhs = hocSinhservice.findAllByCNameContains(findName);
        }
        request.setAttribute("hocSinhs",hocSinhs);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
