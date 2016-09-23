package biz.service.impl;

import biz.dao.ApachePOIDao;
import biz.model.Student;
import biz.service.ApachePOIService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Knight_JXNU on 2016/9/23.
 */
@Service
public class ApachePOIServiceImpl implements ApachePOIService {
    @Autowired
    ApachePOIDao apachePOIDao;

    private String fileUrl = "C:/Users/MW/Desktop/student.xlsx";

    public void getAll() throws Exception{
        List<Student> list = apachePOIDao.getAll();
        for(Student s : list){
            System.out.println(s);
        }
        writeToExcle(list);
    }

    public void insert(){
        Student s = new Student("qinying", 20);
        apachePOIDao.insert(s);
    }

    private void writeToExcle(List<Student> list) throws Exception{
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Students");
        Iterator<Student> iterator = list.iterator();
        int rowIndex = 0;
        while(iterator.hasNext()){
            Student student = iterator.next();
            Row row = sheet.createRow(rowIndex++);
            Cell idCell = row.createCell(0);
            idCell.setCellValue(student.getId());
            Cell nameCell = row.createCell(1);
            nameCell.setCellValue(student.getName());
            Cell ageCell = row.createCell(2);
            ageCell.setCellValue(student.getAge());
        }
        FileOutputStream fos = new FileOutputStream(fileUrl);
        workbook.write(fos);
        fos.close();
    }
}
