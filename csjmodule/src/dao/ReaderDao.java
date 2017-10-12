package dao;

import domain.Reader;
import domain.PageBean;
import java.util.*;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;

public class ReaderDao {

    private QueryRunner qr = new TxQueryRunner();

    public ReaderDao()
    {
    }

    public void add (Reader r)
    {
        try {
            String sql = "INSERT INTO t_reader VALUES(?,?,?,?,?,?)";
            Object[] params = {r.getId(), r.getName(), r.getGender(), r.getPhone(), r.getEmail(), r.getDescription()};
            qr.update(sql, params);
        }
        catch(Exception e){
            throw  new RuntimeException();
        }
    }

    public Reader find(String id)
    {
        try{
            String sql = "SELECT * FORM t_reader WHERE id=?";
            return qr.query(sql,new BeanHandler<Reader>(Reader.class),id);
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void edit(Reader r)
    {
        try{
            String sql = "UPDATE t_reader SET name=?,gender=?,phone=?,email=?,description=? WHERE id=?";
            Object[] params = {r.getName(),r.getGender(),r.getPhone(),r.getEmail(),r.getDescription(),r.getId()};
            qr.update(sql,params);
        }
        catch(Exception e){
            throw new RuntimeException();
        }
    }

    public void delete(String id)
    {
        try{
            String sql = "DELETE FROM t_reader WHERE id = ?";
            qr.update(sql,id);
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    public PageBean findAll(int pc, int pr)
    {
        try {
            PageBean pb = new PageBean();
            pb.setPc(pc);
            pb.setPr(pr);

            String sql = "SELECT COUNT(*) FROM t_reader";
            Number number = (Number)qr.query(sql,new ScalarHandler());

            int tr = number.intValue();
            pb.setTr(tr);

            sql = "SELECT * FROM t_reader LIMIT ?,?";
            Object[] params = {(pc - 1)*pr,pr};
            List<Reader> beanList = qr.query(sql,new BeanListHandler<Reader>(Reader.class),params);
            pb.setBeanList(beanList);
            return pb;
        }
        catch(Exception e){
            throw new RuntimeException();
        }
    }

    public PageBean query(Reader r, int pc, int pr)
    {
        try{
            PageBean pb = new PageBean();
            pb.setPc(pc);
            pb.setPr(pr);

            StringBuilder sql = new StringBuilder("SELECT * FROM t_reader WHERE 1=1");
            List<Object> params = new ArrayList<>();

            String name = r.getName();
            if(name != null && !name.trim().isEmpty())
            {
                sql.append(" AND name=?");
                params.add("%" + name + "%");
            }

            String gender = r.getGender();
            if(gender != null && !gender.trim().isEmpty())
            {
                sql.append(" AND gender=?");
                params.add(gender);
            }

            String phone = r.getPhone();
            if(phone != null && !phone.trim().isEmpty())
            {
                sql.append(" AND phone=?");
                params.add("%" + phone + "%");
            }

            String email = r.getEmail();
            if(email != null && !email.trim().isEmpty())
            {
                sql.append(" AND email=?");
                params.add("%" + email + "%");
            }

            String description = r.getDescription();
            if(description != null && !description.trim().isEmpty())
            {
                sql.append("AND description=?");
                params.add("%" + description + "%");
            }

            String s = sql.toString();
            int tr = (int)qr.query(s,new ScalarHandler(),params.toArray());
            pb.setTr(tr);

            s = "SELECT * FROM t_reader LIMIT ?,?";
            Object[] p = {(pc - 1)*pr,pr};
            List<Reader> beanList = qr.query(s,new BeanListHandler<Reader>(Reader.class),p);
            pb.setBeanList(beanList);
            return pb;

        }
        catch(Exception e){
            throw new RuntimeException();
        }
    }

}
