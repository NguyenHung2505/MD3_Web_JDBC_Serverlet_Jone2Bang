package controller;

import model.Lop;
import service.Lopservice;
import service.LopserviceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LopServlet", urlPatterns = "/lopse")
public class LopServlet extends HttpServlet {
    Lopservice lopservice = new LopserviceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String atc = request.getParameter("atc");
        if(atc== null){
            atc ="";
        }
        switch (atc){
            case "them":
                ThemForm(request,response);
                break;
            default:showlist(request,response);

        }
    }

    private void ThemForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/lop/them.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop>lops = lopservice.findAll();
        request.setAttribute("ds",lops);
        request.getRequestDispatcher("/lop/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String atc = request.getParameter("atc");
//        if(atc == null) {
//            atc = "";
//        }
//        switch (atc){
//            case "them":
//                try {
//                    them(request,response);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
    }
//}
//
//    private void them(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        lopservice.add(new Lop(id,name));
//        response.sendRedirect("/lopse");
//    }
}
