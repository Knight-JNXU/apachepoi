package biz.service.impl;

import biz.dao.ApachePOIDao;
import biz.model.Student;
import biz.service.ApachePOIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Knight_JXNU on 2016/9/23.
 */
@Service
public class ApachePOIServiceImpl implements ApachePOIService {
    @Autowired
    ApachePOIDao apachePOIDao;

    public void getAll(){
        List<Student> list = apachePOIDao.getAll();
        for(Student s : list){
            System.out.println(s);
        }
    }
}
