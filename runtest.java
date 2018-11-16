package com.test.testFrame;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.landi.eightTestCase.eight_paras;
import com.method.ActionType;
import com.method.ElementType;
import com.method.commonOperater;
import com.test.frame.Action;
import com.test.frame.Step;

public class runtest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		commonOperater.initEnv(eight_paras.getCaps());
		
        Workbook wb=new XSSFWorkbook(new FileInputStream("/Users/bindo/eclipse-workspace/autotest/script/caseScriptOK.xlsx"));
        Sheet sheet=wb.getSheetAt(0);
        int rowCount=sheet.getPhysicalNumberOfRows();
        Row row=null;
		Step step=new Step();
        
        
        for(int i=0;i<rowCount;i++)
        {
        	row=sheet.getRow(i);
        	String str_Step=row.getCell(2).getStringCellValue();
        	if(str_Step.equals("GO"))
        	{
        		String str_ElementType=row.getCell(3).getStringCellValue();
            	String str_ElementValue=row.getCell(4).getStringCellValue();
            	String str_ActionType=row.getCell(5).getStringCellValue();
            	step.elementType=ElementType.valueOf(str_ElementType);
            	step.actionType=ActionType.valueOf(str_ActionType);
            	step.webElement=commonOperater.findElement(ElementType.valueOf(str_ElementType),str_ElementValue);
            	
            	
            	if(str_ActionType.equals(ActionType.INPUT.toString()))
            	{
            		String str_ActionValue=row.getCell(6).getStringCellValue();
            		step.actionValue=str_ActionValue;
            	}
            	
            	Action.takeAction(step);

        	}else if(str_Step.equals("SLEEP")) {
        		String str_SleepTime=row.getCell(7).getStringCellValue();
        		commonOperater.sleep(Integer.parseInt(str_SleepTime));
        	}
        	
        }

		
		commonOperater.endOperater();
		
//	    String rootpath="/Users/bindo/eclipse-workspace/autotest/report/";
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//		String date = df.format(new Date());
//		String filePath=rootpath+date+".html";
//		System.out.println(filePath);
//		FileOutputStream fileoutputstream = new FileOutputStream(filePath);
////        FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
//        OutputStreamWriter osw=new OutputStreamWriter(fileoutputstream, "UTF-8");
//        BufferedWriter  bw=new BufferedWriter(osw);
//
//		
//		String title="<!DOCTYPE html> \t\n" + 
//				"<html>  \t\n" +
//				"<head>  \t\n"+
//				"<meta charset=\"utf-8\" />  \t\n"+
//				"<title>测试报告</title>  \t\n"+
//				"</head> \t\n"+
//				"<body>  \t\n"+
//				"<table border=\"1\"> \n" +
//				"<tr>\n"+
//				"<th>case name</th> \n"+
//				"<th>check point</th> \n"+
//				"<th>expected value</th> \n"+
//				"<th>actual value</th>\n"+
//				"<th>screenshot</th>\n"+
//				"</tr>\n";
//		
//		String content="<tr>"
//				+"<th>"
//				+"abc"
//				+"</th>"
//				+"<th>"
//				+"abc"
//				+"</th>"
//				+"<th>"
//				+"abc"
//				+"</th>"
//				+"<th>"
//				+"abc"
//				+"</th>"
//				+"<th>"
//				+"abc"
//				+"</th>"
//				+ "</tr>";
//		String content2="<tr>"
//				+"<th>"
//				+""
//				+"</th>"
//				+"<th>"
//				+"abc"
//				+"</th>"
//				+"<th>"
//				+"abc"
//				+"</th>"
//				+"<th>"
//				+"abc"
//				+"</th>"
//				+"<th>"
//				+"abc"
//				+"</th>"
//				+ "</tr>";
//			
//				
//		
//		
//				
//		String end="</table>\n" +
//				"</body> \n" + 
//				"</html> ";
//
//		
//		bw.write(title+content+content2+end);
//
//		 bw.close();
//	     osw.close();
//		fileoutputstream.close();


	}

}
