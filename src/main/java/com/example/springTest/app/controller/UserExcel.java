package com.example.springTest.app.controller;

import static org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined.*;

import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.example.springTest.app.view.ExcelView;

public class UserExcel implements ExcelView.Callback {

    @Override
    public void buildExcelWorkbook(Map<String, Object> model, Workbook workbook) {

        // シートを作成する
        Sheet sheet = workbook.createSheet("チェック結果");
        sheet.setDefaultColumnWidth(50);
//        sheet.addMergedRegion(new CellRangeAddress(1,5,0,0));

        // フォント
        Font font = workbook.createFont();
        font.setFontName("メイリオ");
        font.setBold(true);
        font.setColor(BLACK.getIndex());

        // 結果フォント
        Font resultFont = workbook.createFont();
        resultFont.setFontName("メイリオ");
        resultFont.setBold(true);
        resultFont.setColor(WHITE.getIndex());

        Font errorMessageFont = workbook.createFont();
        errorMessageFont.setFontName("メイリオ");
        errorMessageFont.setBold(true);
        errorMessageFont.setColor(RED.getIndex());

        // ヘッダーのスタイル
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(YELLOW.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setFont(font);

        // ボディのスタイル
        CellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setFont(font);

        // 結果：OKのスタイル
        CellStyle okStyle = workbook.createCellStyle();
        okStyle.setFillForegroundColor(BRIGHT_GREEN.getIndex());
        okStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        okStyle.setFont(resultFont);

        // 結果：NGのスタイル
        CellStyle ngStyle = workbook.createCellStyle();
        ngStyle.setFillForegroundColor(RED.getIndex());
        ngStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        ngStyle.setFont(resultFont);

        // エラーメッセージのスタイル
        CellStyle errorMessageStyle = workbook.createCellStyle();
        errorMessageStyle.setFont(errorMessageFont);


        Row headerResult = sheet.createRow(0);
        headerResult.createCell(0).setCellValue("結果");
        headerResult.getCell(0).setCellStyle(headerStyle);

        Row headerResultData = sheet.createRow(1);
        if("OK".equals((String)model.get("result"))) {
        	headerResultData.createCell(0).setCellValue("結果が一致しています。");
        	headerResultData.getCell(0).setCellStyle(okStyle);
        }else {
        	headerResultData.createCell(0).setCellValue("結果が一致していません。もう一度修正してください");
        	headerResultData.getCell(0).setCellStyle(ngStyle);
        }

        Row headerId = sheet.createRow(3);
        headerId.createCell(0).setCellValue("対象");
        headerId.getCell(0).setCellStyle(headerStyle);

        Row headerIdData = sheet.createRow(4);
        headerIdData.createCell(0).setCellValue((String)model.get("id"));
        headerIdData.getCell(0).setCellStyle(bodyStyle);

        Row headerOldJson = sheet.createRow(6);
        headerOldJson.createCell(0).setCellValue("oldJson");
        headerOldJson.getCell(0).setCellStyle(headerStyle);

        Row headerOldJsonData = sheet.createRow(7);
        headerOldJsonData.createCell(0).setCellValue((String)model.get("oldJson"));
        headerOldJsonData.getCell(0).setCellStyle(bodyStyle);

        Row headerNewJson = sheet.createRow(9);
        headerNewJson.createCell(0).setCellValue("newJson");
        headerNewJson.getCell(0).setCellStyle(headerStyle);

        Row headerNewJsonData = sheet.createRow(10);
        headerNewJsonData.createCell(0).setCellValue((String)model.get("newJson"));
        headerNewJsonData.getCell(0).setCellStyle(bodyStyle);



        if("NG".equals((String)model.get("result"))) {
        	Row headerErrorMessage = sheet.createRow(12);
        	headerErrorMessage.createCell(0).setCellValue("エラーメッセージ");
        	headerErrorMessage.getCell(0).setCellStyle(headerStyle);
        	int count = 13;
        	for(int i=0; i < 100; i++) {
              Row errorMessageRow = sheet.createRow(count++);
              errorMessageRow.createCell(0).setCellValue("エラーメッセージ"+i);
              errorMessageRow.getCell(0).setCellStyle(errorMessageStyle);

        	}
        }
//        Map<String,Object> test = new HashMap<String,Object>();
//        List<String> testList = new ArrayList<String>();
//        List<String> testList2 = new ArrayList<String>();
//
//        for(int i=0; i < 100; i++) {
//        	testList.add("testListValue:"+i);
//        	testList2.add("testList2Value:"+i);
//        }
//        test.put("testList", testList);
//        test.put("testList2", testList2);
//
//        CreationHelper helper = workbook.getCreationHelper();
//        RichTextString jsonStr = helper.createRichTextString(JSON.encode(test,true));
////        String jsonStr = JSON.encode(test,true).replaceAll("\t","\\\t");
//
//        System.out.println("Json確認:"+jsonStr);
//
//        CellStyle style2 = workbook.createCellStyle();
//        style2.setFillForegroundColor(DARK_GREEN.getIndex());
//        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        style2.setFont(font);
////        style2.setWrapText(true);
//
//        Row body = sheet.createRow(1);
//        body.createCell(0).setCellValue(jsonStr);
//        body.getCell(0).setCellStyle(style2);
//        body.setHeightInPoints(1000);

        // 明細
//        @SuppressWarnings("unchecked")
//        List<User> users = (List<User>) model.get("data");
//
//        int count = 1;
//        for (User user : users) {
//            Row userRow = sheet.createRow(count++);
//            userRow.createCell(0).setCellValue(user.getLastName());
//            userRow.createCell(1).setCellValue(user.getFirstName());
//            userRow.createCell(2).setCellValue(user.getEmail());
//        }
    }
}
