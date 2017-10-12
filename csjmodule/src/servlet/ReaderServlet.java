package servlet;

import java.util.*;
import cn.itcast.commons.CommonUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import service.ReaderService;
import domain.Reader;
import domain.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import cn.itcast.servlet.BaseServlet;

public class ReaderServlet extends BaseServlet{

    private ReaderService readerService = new ReaderService();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        Reader r = CommonUtils.toBean(request.getParameterMap(), Reader.class);
        r.setId(CommonUtils.uuid());
        readerService.add(r);
        request.setAttribute("msg","Added successful!");
        return "/msg.jsp";
    }

    public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String id = request.getParameter("id");
        Reader r = readerService.find(id);
        request.setAttribute("Reader",r);
        return "/edit.jsp";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        Reader r = CommonUtils.toBean(request.getParameterMap(), Reader.class);
        readerService.edit(r);
        request.setAttribute("msg","Editted successful!");
        return "/msg.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String id = request.getParameter("id");
        readerService.delete(id);
        request.setAttribute("msg","Deleted successful!");
        return "/msg.jsp";
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        int pc = getPc(request);
        int pr = 10;
        PageBean pageBean = readerService.findAll(pc,pr);
        String url = getUrl(request);
        pageBean.setUrl(url);
        request.setAttribute("pb",pageBean);
        return "/list.jsp";
    }

    public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        int pc = getPc(request);
        int pr = 10;
        Reader r = CommonUtils.toBean(request.getParameterMap(), Reader.class);
        request.setAttribute("Reader",r);
        PageBean pageBean = readerService.query(r,pc,pr);
        String url = getUrl(request);
        pageBean.setUrl(url);
        request.setAttribute("pb",pageBean);
        return "/list.jsp";
    }



    private int getPc(HttpServletRequest request)
    {
        String value = request.getParameter("pc");
        if(value == null || value.trim().isEmpty())
            return 1;
        return Integer.parseInt(value);
    }

    private String getUrl(HttpServletRequest request)
    {
        String requestUri = request.getRequestURI();
        String queryString = request.getQueryString();
        if(queryString.contains("&pc="))
        {
            int index = queryString.lastIndexOf("&pc=");
            queryString = queryString.substring(0,index);
        }

        return requestUri + "?" + queryString;
    }

    private Reader encoding(Reader r) throws UnsupportedEncodingException {
        String name = r.getName();
        String gender = r.getGender();
        String phone = r.getPhone();
        String email = r.getEmail();

        if (name != null && !name.trim().isEmpty()) {
            name = new String(name.getBytes("ISO-8859-1"), "utf-8");
            r.setName(name);
        }
        if (gender != null && !gender.trim().isEmpty()) {
            gender = new String(gender.getBytes("ISO-8859-1"), "utf-8");
            r.setGender(gender);
        }
        if (phone != null && !phone.trim().isEmpty()) {
            phone = new String(phone.getBytes("ISO-8859-1"), "utf-8");
            r.setPhone(phone);
        }
        if (email != null && !email.trim().isEmpty()) {
            email = new String(email.getBytes("ISO-8859-1"), "utf-8");
            r.setEmail(email);
        }
        return r;
    }
}
