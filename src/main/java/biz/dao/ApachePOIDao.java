package biz.dao;

import biz.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Knight_JXNU on 2016/9/23.
 */
@Repository
public interface ApachePOIDao {
    public List<Student> getAll();
}
