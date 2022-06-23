package com.hendisantika.service;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.hendisantika.entity.Lottery;
import com.hendisantika.model.LotteryModel;

@Service
public class UtilService {

	public String formatPrice(int sumTopThree) {
		String number = String.valueOf(sumTopThree);
		double amount = Double.parseDouble(number);
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(amount);
	}

	public void headerDashBoard(ModelAndView modelview, List<Lottery> listDashBoard) {
		for (Lottery obj : listDashBoard) {
			modelview.addObject("sumTopThree", this.formatPrice(obj.getTopThreePrice()));
			modelview.addObject("sumTod", this.formatPrice(obj.getTodPrice()));
			modelview.addObject("sumTopTwo", this.formatPrice(obj.getTopTwoPrice()));
			modelview.addObject("sumUnderTwo", this.formatPrice(obj.getUnderTwoPrice()));
			modelview.addObject("sumRun", this.formatPrice(obj.getRunPrice()));
			modelview.addObject("sumUnderRun", this.formatPrice(obj.getUnderRunPrice()));
			modelview.addObject("sumlottery", this.formatPrice(obj.getTopThreePrice() + obj.getTodPrice()
					+ obj.getTopTwoPrice() + obj.getUnderTwoPrice() + obj.getRunPrice() + obj.getUnderRunPrice()));
		}
	}

	public void random6(Object[] obj, String tod) {
		String sub1 = "";
		String sub2 = "";
		String sub3 = "";

		sub1 = tod.substring(0, 1);
		sub2 = tod.substring(1, 2);
		sub3 = tod.substring(2, 3);

		obj[0] = tod;
		obj[1] = sub1 + sub3 + sub2;
		obj[2] = sub2 + sub1 + sub3;
		obj[3] = sub2 + sub3 + sub1;
		obj[4] = sub3 + sub1 + sub2;
		obj[5] = sub3 + sub2 + sub1;
		System.out.println(obj[0] + " , " + obj[1] + " , " + obj[2] + " , " + obj[3] + " , " + obj[5] + " , " + obj[5]);

	}

	public XSSFWorkbook getExcel(String headerStr, List<LotteryModel> list, String startDateEndDate) {
		int indexRow = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Lottery");
		
		/* Draw header */
		Row rowHeaderl = sheet.createRow(indexRow);
		Cell cellHeaderl;
		cellHeaderl = rowHeaderl.createCell(0);
		cellHeaderl.setCellValue(startDateEndDate);
		indexRow++;
		
		String[] header = headerStr.toString().split(",");
		int[] headerCell = { 8000, 8000 };
		rowHeaderl = sheet.createRow(indexRow);
		
		for (int i = 0; i < header.length; i++) {
			sheet.setColumnWidth(i, headerCell[i]);
			cellHeaderl = rowHeaderl.createCell(i);
			cellHeaderl.setCellStyle(UtilService.setBorderMediumCenterVerticalCenter(workbook));
			cellHeaderl.setCellValue(header[i]);
			if (i == 0) {
				this.setCellHeaderCenter(cellHeaderl, workbook);
			} else {
				this.setCellHeaderLeft(cellHeaderl, workbook);
			}
		}
		indexRow++;
		/* data */
		for (int j = 0 ; j < list.size() ; j++) {
			rowHeaderl = sheet.createRow(indexRow);
			cellHeaderl = rowHeaderl.createCell(0);
			cellHeaderl.setCellValue(list.get(j).getTod());
			this.setCellDataCenter(cellHeaderl, workbook);
			
			cellHeaderl = rowHeaderl.createCell(1);
			cellHeaderl.setCellValue(list.get(j).getTodPrice());
			this.setCellDataLeft(cellHeaderl, workbook);
			indexRow++;
		}
		return workbook;
	}
	
	public XSSFWorkbook getExcelTopThree(String headerStr, List<Lottery> list, String startDateEndDate) {
		int indexRow = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Lottery");
		
		/* Draw header */
		Row rowHeaderl = sheet.createRow(indexRow);
		Cell cellHeaderl;
		cellHeaderl = rowHeaderl.createCell(0);
		cellHeaderl.setCellValue(startDateEndDate);
		indexRow++;
		
		String[] header = headerStr.toString().split(",");
		int[] headerCell = { 8000, 8000 };
		rowHeaderl = sheet.createRow(indexRow);
		
		for (int i = 0; i < header.length; i++) {
			sheet.setColumnWidth(i, headerCell[i]);
			cellHeaderl = rowHeaderl.createCell(i);
			cellHeaderl.setCellStyle(UtilService.setBorderMediumCenterVerticalCenter(workbook));
			cellHeaderl.setCellValue(header[i]);
			if (i == 0) {
				this.setCellHeaderCenter(cellHeaderl, workbook);
			} else {
				this.setCellHeaderLeft(cellHeaderl, workbook);
			}
		}
		indexRow++;
		/* data */
		for (int j = 0 ; j < list.size() ; j++) {
			
			
			rowHeaderl = sheet.createRow(indexRow);
			cellHeaderl = rowHeaderl.createCell(0);
			cellHeaderl.setCellValue(list.get(j).getTopThree());
			this.setCellDataCenter(cellHeaderl, workbook);
			
			cellHeaderl = rowHeaderl.createCell(1);
			cellHeaderl.setCellValue(list.get(j).getTopThreePrice());
			this.setCellDataLeft(cellHeaderl, workbook);
			indexRow++;
		}
		return workbook;
	}
	
	public XSSFWorkbook getExcelFilter(String headerStr, List<LotteryModel> list, String startDateEndDate) {
		int indexRow = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Lottery");
		
		/* Draw header */
		Row rowHeaderl = sheet.createRow(indexRow);
		Cell cellHeaderl;
		cellHeaderl = rowHeaderl.createCell(0);
		cellHeaderl.setCellValue(startDateEndDate);
		indexRow++;
		
		String[] header = headerStr.toString().split(",");
		int[] headerCell = {5000, 8000, 8000 };
		rowHeaderl = sheet.createRow(indexRow);
		
		for (int i = 0; i < header.length; i++) {
			sheet.setColumnWidth(i, headerCell[i]);
			cellHeaderl = rowHeaderl.createCell(i);
			cellHeaderl.setCellStyle(UtilService.setBorderMediumCenterVerticalCenter(workbook));
			cellHeaderl.setCellValue(header[i]);
			if (i == 0 || i == 1 ) {
				this.setCellHeaderCenter(cellHeaderl, workbook);
			} else {
				this.setCellHeaderLeft(cellHeaderl, workbook);
			}
		}
		indexRow++;
		/* data */
		for (int j = 0 ; j < list.size() ; j++) {
			rowHeaderl = sheet.createRow(indexRow);
			cellHeaderl = rowHeaderl.createCell(0);
			cellHeaderl.setCellValue(list.get(j).getTodStr());
			this.setCellDataCenter(cellHeaderl, workbook);
			
			cellHeaderl = rowHeaderl.createCell(1);
			cellHeaderl.setCellValue(list.get(j).getTod());
			this.setCellDataCenter(cellHeaderl, workbook);
			
			cellHeaderl = rowHeaderl.createCell(2);
			cellHeaderl.setCellValue(list.get(j).getTodPrice());
			this.setCellDataLeft(cellHeaderl, workbook);
			indexRow++;
		}
		return workbook;
	
	}

	private void setCellDataLeft(Cell cell, XSSFWorkbook workbook) {
		XSSFCellStyle styleHeader = workbook.createCellStyle();

		styleHeader.setAlignment(HorizontalAlignment.LEFT);
		cell.setCellStyle(styleHeader);

	}

	private void setCellDataCenter(Cell cell, XSSFWorkbook workbook) {
		XSSFCellStyle styleHeader = workbook.createCellStyle();
		DataFormat fmt = workbook.createDataFormat();

		styleHeader.setAlignment(HorizontalAlignment.CENTER);
		styleHeader.setDataFormat(fmt.getFormat("@"));
		cell.setCellStyle(styleHeader);

		Font font = workbook.createFont();
		font.setBold(true);
		styleHeader.setFont(font);

	}

	private void setCellHeaderLeft(Cell cell, XSSFWorkbook workbook) {
		XSSFCellStyle styleHeader = workbook.createCellStyle();

		styleHeader.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
		styleHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleHeader.setAlignment(HorizontalAlignment.LEFT);
		cell.setCellStyle(styleHeader);

		Font font = workbook.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		styleHeader.setFont(font);
	}

	private void setCellHeaderCenter(Cell cell, XSSFWorkbook workbook) {
		XSSFCellStyle styleHeader = workbook.createCellStyle();
		DataFormat fmt = workbook.createDataFormat();

		styleHeader.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
		styleHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleHeader.setAlignment(HorizontalAlignment.CENTER);
		styleHeader.setDataFormat(fmt.getFormat("@"));
		cell.setCellStyle(styleHeader);

		Font font = workbook.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		styleHeader.setFont(font);

	}

	public static XSSFCellStyle setBorderMediumCenterVerticalCenter(XSSFWorkbook workbook) {
		XSSFCellStyle cellstyle = workbook.createCellStyle();
		cellstyle.setBorderTop(BorderStyle.MEDIUM);
		cellstyle.setBorderRight(BorderStyle.MEDIUM);
		cellstyle.setBorderBottom(BorderStyle.MEDIUM);
		cellstyle.setBorderLeft(BorderStyle.MEDIUM);
		cellstyle.setAlignment(HorizontalAlignment.CENTER);
		cellstyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellstyle.setWrapText(true);

		return cellstyle;
	}

	public XSSFWorkbook getExcelTopTwo(String headerStr, List<Lottery> list, String startDateEndDate) {
		int indexRow = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Lottery");
		
		/* Draw header */
		Row rowHeaderl = sheet.createRow(indexRow);
		Cell cellHeaderl;
		cellHeaderl = rowHeaderl.createCell(0);
		cellHeaderl.setCellValue(startDateEndDate);
		indexRow++;
		
		String[] header = headerStr.toString().split(",");
		int[] headerCell = { 8000, 8000 };
		rowHeaderl = sheet.createRow(indexRow);
		
		for (int i = 0; i < header.length; i++) {
			sheet.setColumnWidth(i, headerCell[i]);
			cellHeaderl = rowHeaderl.createCell(i);
			cellHeaderl.setCellStyle(UtilService.setBorderMediumCenterVerticalCenter(workbook));
			cellHeaderl.setCellValue(header[i]);
			if (i == 0) {
				this.setCellHeaderCenter(cellHeaderl, workbook);
			} else {
				this.setCellHeaderLeft(cellHeaderl, workbook);
			}
		}
		indexRow++;
		/* data */
		for (int j = 0 ; j < list.size() ; j++) {
			
			
			rowHeaderl = sheet.createRow(indexRow);
			cellHeaderl = rowHeaderl.createCell(0);
			cellHeaderl.setCellValue(list.get(j).getTopTwo());
			this.setCellDataCenter(cellHeaderl, workbook);
			
			cellHeaderl = rowHeaderl.createCell(1);
			cellHeaderl.setCellValue(list.get(j).getTopTwoPrice());
			this.setCellDataLeft(cellHeaderl, workbook);
			indexRow++;
		}
		return workbook;
	}

	public XSSFWorkbook getExcelUnderTwo(String headerStr, List<Lottery> list, String startDateEndDate) {
		int indexRow = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Lottery");
		
		/* Draw header */
		Row rowHeaderl = sheet.createRow(indexRow);
		Cell cellHeaderl;
		cellHeaderl = rowHeaderl.createCell(0);
		cellHeaderl.setCellValue(startDateEndDate);
		indexRow++;
		
		String[] header = headerStr.toString().split(",");
		int[] headerCell = { 8000, 8000 };
		rowHeaderl = sheet.createRow(indexRow);
		
		for (int i = 0; i < header.length; i++) {
			sheet.setColumnWidth(i, headerCell[i]);
			cellHeaderl = rowHeaderl.createCell(i);
			cellHeaderl.setCellStyle(UtilService.setBorderMediumCenterVerticalCenter(workbook));
			cellHeaderl.setCellValue(header[i]);
			if (i == 0) {
				this.setCellHeaderCenter(cellHeaderl, workbook);
			} else {
				this.setCellHeaderLeft(cellHeaderl, workbook);
			}
		}
		indexRow++;
		/* data */
		for (int j = 0 ; j < list.size() ; j++) {
			
			
			rowHeaderl = sheet.createRow(indexRow);
			cellHeaderl = rowHeaderl.createCell(0);
			cellHeaderl.setCellValue(list.get(j).getUnderTwo());
			this.setCellDataCenter(cellHeaderl, workbook);
			
			cellHeaderl = rowHeaderl.createCell(1);
			cellHeaderl.setCellValue(list.get(j).getUnderTwoPrice());
			this.setCellDataLeft(cellHeaderl, workbook);
			indexRow++;
		}
		return workbook;
	}
	
	public XSSFWorkbook getExcelTopRun(String headerStr, List<Lottery> list, String startDateEndDate) {
		int indexRow = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Lottery");
		
		/* Draw header */
		Row rowHeaderl = sheet.createRow(indexRow);
		Cell cellHeaderl;
		cellHeaderl = rowHeaderl.createCell(0);
		cellHeaderl.setCellValue(startDateEndDate);
		indexRow++;
		
		String[] header = headerStr.toString().split(",");
		int[] headerCell = { 8000, 8000 };
		rowHeaderl = sheet.createRow(indexRow);
		
		for (int i = 0; i < header.length; i++) {
			sheet.setColumnWidth(i, headerCell[i]);
			cellHeaderl = rowHeaderl.createCell(i);
			cellHeaderl.setCellStyle(UtilService.setBorderMediumCenterVerticalCenter(workbook));
			cellHeaderl.setCellValue(header[i]);
			if (i == 0) {
				this.setCellHeaderCenter(cellHeaderl, workbook);
			} else {
				this.setCellHeaderLeft(cellHeaderl, workbook);
			}
		}
		indexRow++;
		/* data */
		for (int j = 0 ; j < list.size() ; j++) {
			
			
			rowHeaderl = sheet.createRow(indexRow);
			cellHeaderl = rowHeaderl.createCell(0);
			cellHeaderl.setCellValue(list.get(j).getRun());
			this.setCellDataCenter(cellHeaderl, workbook);
			
			cellHeaderl = rowHeaderl.createCell(1);
			cellHeaderl.setCellValue(list.get(j).getRunPrice());
			this.setCellDataLeft(cellHeaderl, workbook);
			indexRow++;
		}
		return workbook;
	}
	
	public XSSFWorkbook getExcelUnderRun(String headerStr, List<Lottery> list, String startDateEndDate) {
		int indexRow = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Lottery");
		
		/* Draw header */
		Row rowHeaderl = sheet.createRow(indexRow);
		Cell cellHeaderl;
		cellHeaderl = rowHeaderl.createCell(0);
		cellHeaderl.setCellValue(startDateEndDate);
		indexRow++;
		
		String[] header = headerStr.toString().split(",");
		int[] headerCell = { 8000, 8000 };
		rowHeaderl = sheet.createRow(indexRow);
		
		for (int i = 0; i < header.length; i++) {
			sheet.setColumnWidth(i, headerCell[i]);
			cellHeaderl = rowHeaderl.createCell(i);
			cellHeaderl.setCellStyle(UtilService.setBorderMediumCenterVerticalCenter(workbook));
			cellHeaderl.setCellValue(header[i]);
			if (i == 0) {
				this.setCellHeaderCenter(cellHeaderl, workbook);
			} else {
				this.setCellHeaderLeft(cellHeaderl, workbook);
			}
		}
		indexRow++;
		/* data */
		for (int j = 0 ; j < list.size() ; j++) {
			
			
			rowHeaderl = sheet.createRow(indexRow);
			cellHeaderl = rowHeaderl.createCell(0);
			cellHeaderl.setCellValue(list.get(j).getUnderRun());
			this.setCellDataCenter(cellHeaderl, workbook);
			
			cellHeaderl = rowHeaderl.createCell(1);
			cellHeaderl.setCellValue(list.get(j).getUnderRunPrice());
			this.setCellDataLeft(cellHeaderl, workbook);
			indexRow++;
		}
		return workbook;
	}

}
