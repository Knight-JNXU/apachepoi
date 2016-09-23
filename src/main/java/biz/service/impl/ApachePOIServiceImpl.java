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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Knight_JXNU on 2016/9/23.
 */
@Service
public class ApachePOIServiceImpl implements ApachePOIService {
    @Autowired
    ApachePOIDao apachePOIDao;

    public void getAll(String fileUrl) throws Exception{
        List<Student> list = apachePOIDao.getAll();
        for(Student s : list){
            System.out.println(s);
        }
        writeToExcle(list, fileUrl);
    }

    public void importFromExcel(String fileUrl) throws Exception{
        List<Student> list = readFromExcle(fileUrl);
        for(Student s : list){
            System.out.println(s);
            apachePOIDao.insert(s);
        }
    }

    public void insert(){
        Student s = new Student("qinying", 20);
        apachePOIDao.insert(s);
    }

    private void writeToExcle(List<Student> list, String fileUrl) throws Exception{
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
        File file = new File(fileUrl);
        file.mkdir();
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
    }

    private List<Student> readFromExcle(String fileUrl) throws Exception{
        FileInputStream fis = new FileInputStream(fileUrl);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        List<Student> list = new ArrayList<Student>();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                Student s = new Student();
                s.setId((int)cell.getNumericCellValue());
                cell = cellIterator.next();
                s.setName(cell.getStringCellValue());
                cell = cellIterator.next();
                s.setAge((int)cell.getNumericCellValue());
                list.add(s);
            }
        }
        return list;
    }
}
