package com.zlx.poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class PoiApplicationTests {

    @Test
    void createsheet1() throws IOException {
        //1 ����������
        Workbook workbook = new XSSFWorkbook(); //2007�汾

        //2 ������ sheet
        workbook.createSheet("mysheet");

        //�ļ���
        FileOutputStream outputStream =
                new FileOutputStream("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\mysheet.xlsx");

        //д���ļ�
        workbook.write(outputStream);
        workbook.close();
        System.out.println("jjjj");
    }

    @Test
    void createSheet2() throws IOException {
        //1 ����������
        Workbook workbook = new XSSFWorkbook(); //2007�汾

        //2 ������ sheet
        Sheet sheet = workbook.createSheet("mysheet");

        //�ļ���
        FileOutputStream outputStream =
                new FileOutputStream("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\mysheet2.xlsx");

        //�����ж���
        Row row = sheet.createRow(3);
        //������Ԫ�����
        Cell cell = row.createCell(2);
        //��Ԫ��д������
        cell.setCellValue("first Value");


        //��Ԫ����ʽ
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);

        //������ʽ
        Font font = workbook.createFont();
        font.setFontName("΢���ź�");
        font.setBold(true);//�Ӵ�
        font.setFontHeightInPoints((short)20);//�����С
        cellStyle.setFont(font);

        //�и��п�
        row.setHeightInPoints(30); //�и�
        sheet.setColumnWidth(3,80*256);//�������п�

        //������ʾ
        cellStyle.setAlignment(HorizontalAlignment.CENTER); //ˮƽ����
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); //��ֱ����
        cell.setCellStyle(cellStyle);

        //д���ļ�
        workbook.write(outputStream);
        workbook.close();
    }

    //����ͼƬ
    @Test
    void createsheet3() throws IOException {
        //1 ����������
        Workbook workbook = new XSSFWorkbook(); //2007�汾

        //2 ������ sheet
        Sheet sheet = workbook.createSheet("mysheet");

        //��ȡͼƬ��������
        FileInputStream inputStream = new FileInputStream("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\me.jpg");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        inputStream.read(bytes);

        //��POI�ڴ������ͼƬ����ͼƬ����
        int index = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);

        //����ͼƬ������
        CreationHelper creationHelper = workbook.getCreationHelper();
        //������ͼ����
        Drawing<?> drawingPatriarch = sheet.createDrawingPatriarch();
        //����ê��  ����ͼƬ����
        ClientAnchor clientAnchor = creationHelper.createClientAnchor();
        clientAnchor.setRow1(1);
        clientAnchor.setCol1(1);

        //����ͼƬ
        Picture picture = drawingPatriarch.createPicture(clientAnchor, index); //ͼƬλ�ã�����
        picture.resize();//����Ӧ
        //�ļ���
        FileOutputStream outputStream =
                new FileOutputStream("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\mysheet3.xlsx");

        //д���ļ�
        workbook.write(outputStream);
        workbook.close();
        System.out.println("jjjj");
    }

    //��ȡexcel���޸�
    @Test
    void createsheet4() throws IOException {
        //1 ����������
        Workbook workbook = new XSSFWorkbook("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\mysheet.xlsx");//2007�汾

        //��ȡsheet
        Sheet sheetAt = workbook.getSheetAt(0); //����
        //������  С�ڵ���
        for (int rowNum = 0;rowNum <= sheetAt.getLastRowNum();rowNum++){
            //��ȡ��
            Row row = sheetAt.getRow(rowNum);
            StringBuilder builder = new StringBuilder();
            //������Ԫ��   С�� 
            for (int cellNum = 2;cellNum<row.getLastCellNum();cellNum++){
                //��ȡÿһ����Ԫ��
                Cell cell = row.getCell(cellNum);
                builder.append(cell).append("\t");
            }
            System.out.println(builder.toString());
        }
        workbook.close();
        System.out.println("jjjj");
    }

    public Object getValue(Cell cell){
        CellType cellType = cell.getCellType();
        Object value = null;
        switch (cellType){
            case STRING: //string ����
                value = cell.getStringCellValue();break;
            case BOOLEAN: //Boolean ����
                value = cell.getBooleanCellValue();break;
            case NUMERIC: //���ڻ���������
                if (DateUtil.isCellDateFormatted(cell)){
                    value = cell.getDateCellValue();
                }else {
                    value = cell.getNumericCellValue();
                }
                break;
            case FORMULA:
                value = cell.getCellFormula();break;
            default:
                break;
        }
        return value;
    }
}
