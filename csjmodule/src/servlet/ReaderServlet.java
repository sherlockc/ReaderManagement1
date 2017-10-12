package servlet;

import java.util.*;
import cn.itcast.commons.CommonUtils;
import java.io.IOException;

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
        request.setAttribute("pageBean",pageBean);
        return "/list.jsp";
    }

    public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        int pc = getPc(request);
        int pr = 10;
        Reader r = CommonUtils.toBean(request.getParameterMap(), Reader.class);
        PageBean pageBean = readerService.query(r,pc,pr);
        String url = getUrl(request);
        pageBean.setUrl(url);
        request.setAttribute("pageBean",pageBean);
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
}
