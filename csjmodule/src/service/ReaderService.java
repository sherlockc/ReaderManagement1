package service;

import dao.ReaderDao;
import domain.Reader;
import domain.PageBean;

public class ReaderService {

    ReaderDao readerDao = new ReaderDao();

    public ReaderService(){
    }

    public void add(Reader r)
    {
        this.readerDao.add(r);
    }

    public Reader find(String id)
    {
        return this.readerDao.find(id);
    }

    public void edit(Reader r)
    {
        this.readerDao.edit(r);
    }

    public void delete(String id)
    {
        this.readerDao.delete(id);
    }

    public PageBean findAll(int pc, int pr)
    {
        return this.readerDao.findAll(pc, pr);
    }

    public PageBean query(Reader r, int pc, int pr)
    {
        return this.readerDao.query(r, pc, pr);
    }

}
