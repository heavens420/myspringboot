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
        //1 创建工作簿
        Workbook workbook = new XSSFWorkbook(); //2007版本

        //2 创建表单 sheet
        workbook.createSheet("mysheet");

        //文件流
        FileOutputStream outputStream =
                new FileOutputStream("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\mysheet.xlsx");

        //写入文件
        workbook.write(outputStream);
        workbook.close();
        System.out.println("jjjj");
    }

    @Test
    void createSheet2() throws IOException {
        //1 创建工作簿
        Workbook workbook = new XSSFWorkbook(); //2007版本

        //2 创建表单 sheet
        Sheet sheet = workbook.createSheet("mysheet");

        //文件流
        FileOutputStream outputStream =
                new FileOutputStream("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\mysheet2.xlsx");

        //创建行对象
        Row row = sheet.createRow(3);
        //创建单元格对象
        Cell cell = row.createCell(2);
        //向单元格写入数据
        cell.setCellValue("first Value");


        //单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);

        //字体样式
        Font font = workbook.createFont();
        font.setFontName("微软雅黑");
        font.setBold(true);//加粗
        font.setFontHeightInPoints((short)20);//字体大小
        cellStyle.setFont(font);

        //行高列宽
        row.setHeightInPoints(30); //行高
        sheet.setColumnWidth(3,80*256);//第三行列宽

        //剧中显示
        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); //垂直居中
        cell.setCellStyle(cellStyle);

        //写入文件
        workbook.write(outputStream);
        workbook.close();
    }

    //插入图片
    @Test
    void createsheet3() throws IOException {
        //1 创建工作簿
        Workbook workbook = new XSSFWorkbook(); //2007版本

        //2 创建表单 sheet
        Sheet sheet = workbook.createSheet("mysheet");

        //读取图片二进制流
        FileInputStream inputStream = new FileInputStream("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\me.jpg");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        inputStream.read(bytes);

        //向POI内存中添加图片返回图片索引
        int index = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);

        //绘制图片工具类
        CreationHelper creationHelper = workbook.getCreationHelper();
        //创建绘图对象
        Drawing<?> drawingPatriarch = sheet.createDrawingPatriarch();
        //创建锚点  设置图片坐标
        ClientAnchor clientAnchor = creationHelper.createClientAnchor();
        clientAnchor.setRow1(1);
        clientAnchor.setCol1(1);

        //绘制图片
        Picture picture = drawingPatriarch.createPicture(clientAnchor, index); //图片位置，索引
        picture.resize();//自适应
        //文件流
        FileOutputStream outputStream =
                new FileOutputStream("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\mysheet3.xlsx");

        //写入文件
        workbook.write(outputStream);
        workbook.close();
        System.out.println("jjjj");
    }

    //读取excel并修改
    @Test
    void createsheet4() throws IOException {
        //1 创建工作簿
        Workbook workbook = new XSSFWorkbook("C:\\Workplaces\\java\\w2\\myspringboot\\poi\\src\\main\\java\\com\\zlx\\poi\\excel\\mysheet.xlsx");//2007版本

        //获取sheet
        Sheet sheetAt = workbook.getSheetAt(0); //索引
        //遍历行  小于等于
        for (int rowNum = 0;rowNum <= sheetAt.getLastRowNum();rowNum++){
            //获取行
            Row row = sheetAt.getRow(rowNum);
            StringBuilder builder = new StringBuilder();
            //遍历单元格   小于 
            for (int cellNum = 2;cellNum<row.getLastCellNum();cellNum++){
                //获取每一个单元格
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
            case STRING: //string 类型
                value = cell.getStringCellValue();break;
            case BOOLEAN: //Boolean 类型
                value = cell.getBooleanCellValue();break;
            case NUMERIC: //日期或数字类型
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
