package domain;

import java.util.*;

public class PageBean {
    private int pc; //the page code
    private int tp; //the total page
    private int tr; //the total record
    private int pr; //the page record
    private String url;

    private List<Object> beanList = new ArrayList<>();


    public PageBean()
    {
    }

    public void setPc(int pc)
    {
        this.pc = pc;
    }

    public int getPc()
    {
        return pc;
    }

    public int getTp()
    {
        tp = tr/pr;
        return tr%pr == 0 ? tp: tp+1;
    }

    public void setTr(int tr)
    {
        this.tr = tr;
    }

    public int getTr()
    {
        return tr;
    }

    public void setPr(int pr)
    {
        this.pr = pr;
    }

    public int getPr()
    {
        return pr;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public void setBeanList(List<Object> beanList)
    {
        this.beanList = beanList;
    }

    public List<Object> getBeanList()
    {
        return beanList;
    }



}
