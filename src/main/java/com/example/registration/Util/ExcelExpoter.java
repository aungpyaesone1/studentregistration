package com.example.registration.Util;

import com.example.registration.Config.CustomAnno;
import com.example.registration.Dto.StudentDto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@CustomAnno(name="anno1")
public class ExcelExpoter {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Name", "Classname", "Createddate", "Modifieddate" };
    static String SHEET = "Students";
    public static ByteArrayInputStream studentToExcel(List<StudentDto> students) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (StudentDto tutorial : students) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(tutorial.getId());
                row.createCell(1).setCellValue(tutorial.getName());
                row.createCell(2).setCellValue(tutorial.getClassName());
                row.createCell(3).setCellValue(tutorial.getCreateddate());
                row.createCell(4).setCellValue(tutorial.getModifieddate());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
