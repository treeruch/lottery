package com.hendisantika.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hendisantika.entity.History;
import com.hendisantika.entity.Lottery;

@Service
public class ImportExcelService {
	
	
	public String readFileExcel(MultipartFile files) throws Exception {
       List<Lottery> lotteryList = new ArrayList<>();
       int rowText = 2;
       String cellText = "";
		  
		return "";
       
	}


}
