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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HocSinhServlet", urlPatterns = "/hocsinhse")
public class HocSinhServlet extends HttpServlet {
    HocSinhservice hocSinhservice = new HocSinhServiceImpl();
    Lopservice lopservice = new LopserviceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String abc = request.getParameter("abc");
        if (abc == null) {
            abc = "";
        }
        switch (abc) {
            case "them":
                themForm(request, response);
                break;
            case "view":
                showView(request, response);
                break;
            case "xoa":
                showdelete(request, response);
                break;
            case "sua":
                showEdit(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop> lops = lopservice.findAll();
        request.setAttribute("lops",lops);
        int id = Integer.parseInt(request.getParameter("id"));
        HocSinh hocSinh = hocSinhservice.findById(id);
        request.setAttribute("sua",hocSinh);
        request.getRequestDispatcher("hocsinh/sua.jsp").forward(request, response);
    }

    private void showdelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop>lops = lopservice.findAll();
        request.setAttribute("lops", lops);
        int id= Integer.parseInt(request.getParameter("id"));
        HocSinh hocSinhs = hocSinhservice.findById(id);
//        gui di noi dung
        request.setAttribute("xoa",hocSinhs);
        request.getRequestDispatcher("hocsinh/xoa.jsp").forward(request, response);
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop>lops = lopservice.findAll();
        request.setAttribute("lops", lops);
        int id= Integer.parseInt(request.getParameter("id"));
        HocSinh hocSinhs = hocSinhservice.findById(id);
        request.setAttribute("hocsinh",hocSinhs);
        request.getRequestDispatcher("hocsinh/view.jsp").forward(request, response);
    }

    private void themForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop>lops = lopservice.findAll();
        request.setAttribute("lops", lops);
        request.getRequestDispatcher("/hocsinh/them.jsp").forward(request,response);

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HocSinh> hocSinhs = hocSinhservice.findAll();
        request.setAttribute("dsm", hocSinhs);
        request.getRequestDispatcher("hocsinh/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String abc = request.getParameter("abc");
        if (abc == null) {
            abc = "";
        }
        switch (abc) {

            case "them":
                try {
                    themhs(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "xoa":
                try {
                    xoa(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "sua":
                try {
                    sua(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                showList(request, response);
        }
    }

    private void sua(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int id = Integer.parseInt(request.getParameter("id"));
        int cID = Integer.parseInt(request.getParameter("classId"));
        Lop lop = lopservice.findById(cID);
        hocSinhservice.update(new HocSinh(id,name, lop, age));
        response.sendRedirect("/home");
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        hocSinhservice.delete(id);
        response.sendRedirect("/home");
    }

    private void themhs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        Lop lop = lopservice.findById(classId);
        hocSinhservice.add(new HocSinh(name,lop,age));
        response.sendRedirect("/home");
    }

}

