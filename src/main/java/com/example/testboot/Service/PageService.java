package com.example.testboot.Service;

import com.example.testboot.repository.PageRepository;
import com.example.testboot.Entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Service
@RequestMapping("/pages")
public class PageService {

    @Autowired
    private PageRepository pageDao;


    public Collection<Page> getAll() {
        return pageDao.findAll();
    }

    public Page getSinglePage(int id) {
        return pageDao.getPageById(id);
    }

    public void deletePage(int id) {
        pageDao.deletePage(id);
    }

    public void insertPage(Page page) {
        pageDao.insertPage(page);
    }

}
