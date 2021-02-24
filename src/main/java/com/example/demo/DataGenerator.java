package com.example.demo;

package demo.com.example.customerdata;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;

public class DataGeneratorImpl implements DataGenerator {

    Function<String, Optional<String>> nullChecker = x -> Optional.ofNullable(x);

    public String versionChecker(String version) {
        List<HSSFWorkbook> verList = new ArrayList<>();
        return "";
    }

    public void makeData(String version) {
        if (nullChecker.apply(version).isPresent()) {

        }
    }

    public Workbook createWorkbook(String version) throws NoClassDefFoundError {
        Optional<String> nullChecker = Optional.ofNullable(version);
        if (nullChecker.isPresent() && versionChecker("d") != null) {
            return new HSSFWorkbook();
        }
        throw new NoClassDefFoundError("Please check the version again.");
    }

//                if ("xls".equals(nullChecker.get())) {
//        return new HSSFWorkbook();
//    } else ("xlsx".equals(nullChecker.get())) {
//        return new HSSFWorkbook();
//    }


    static HSSFRow row;
    static HSSFCell cell;

    List<String> values = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i");

    public void dataGenerator(int dataCount, int valueCount) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("usrdata");
        CellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);
        bodyStyle.setAlignment(HorizontalAlignment.CENTER);

        for (int i = 0; i < dataCount; i++) {
            row = sheet.createRow(i);

            for (int j = 0; j < valueCount; j++) {
                row.createCell(j).setCellValue(values.get(j));
            }
        }


        FileOutputStream outFile;

        try {
            outFile = new FileOutputStream("CustomerData.csv");
            workbook.write(outFile);
            outFile.close();
            System.out.println("고객데이터 생성완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        DataGeneratorImpl dataGenerator = new DataGeneratorImpl();
        dataGenerator.dataGenerator(1000, 9);
        String city = "서울시 신림동";
        String regex ="[가-힣]+[시|도]";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher(city).matches());
    }
}