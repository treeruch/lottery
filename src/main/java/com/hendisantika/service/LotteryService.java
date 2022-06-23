package com.hendisantika.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hendisantika.entity.History;
import com.hendisantika.entity.Lottery;
import com.hendisantika.model.HistoryModel;
import com.hendisantika.model.LotteryModel;

@Service
public class LotteryService {
	
	@Autowired
	private UtilService utilService;

	public List<Lottery> fildAll() throws Exception {
		return new ArrayList<>();
	}

	public List<Lottery> getDashBoard(String startDate,String endDate) throws Exception {
		return  new ArrayList<>();
	}
	
	public List<Lottery> getDashBoardPrice(String startDate,String endDate) throws Exception {
		return  new ArrayList<>();
	}
	
	public List<Lottery> LotteryTopThree(String startDate, String endDate) throws Exception {
		List<Lottery> list = new ArrayList<Lottery>();
		list = this.three();
		return list;
	}

	private List<Lottery> three() {
		List<Lottery> list = new ArrayList<Lottery>();
		int a = 100;
		int b = 100;
			for(int i = 0 ; i < 20 ;i++ ) {
				Lottery obj = new Lottery();
				obj.setTopThree(String.valueOf(a++));
				obj.setTopThreePrice(b+=5);
				list.add(obj);
			}
		
		return list;
	}

	public List<LotteryModel> LotteryTod(String startDate, String endDate, List<String> list1) {
		List<LotteryModel> list = new ArrayList<LotteryModel>();
		list = this.tod();
		return list;
	}

	private List<LotteryModel> tod() {
		List<LotteryModel> list = new ArrayList<LotteryModel>();
		int a = 100;
		int b = 100;
		for(int i = 0 ; i < 20 ;i++ ) {
			LotteryModel obj = new LotteryModel();
			obj.setTod(String.valueOf(a++));
			obj.setTodPrice(b+=5);
			list.add(obj);
	}
		return list;
	}

	public List<Lottery> LotteryTopTwo(String startDate, String endDate) {
		List<Lottery> list = new ArrayList<Lottery>();
		int a = 11;
		int b = 0;
			for(int i = 0 ; i < 20 ;i++ ) {
				Lottery obj = new Lottery();
				obj.setTopTwo(String.valueOf(a++));
				obj.setTopTwoPrice(b+=5);
				list.add(obj);
			}
		
		return list;
	}

	public List<Lottery> LotteryUnderTwo(String startDate, String endDate) {
		List<Lottery> list = new ArrayList<Lottery>();
		int a = 11;
		int b = 0;
			for(int i = 0 ; i < 20 ;i++ ) {
				Lottery obj = new Lottery();
				obj.setUnderTwo(String.valueOf(a++));
				obj.setUnderTwoPrice(b+=5);
				list.add(obj);
			}
		
		return list;
	}

	public List<Lottery> LotteryRun(String startDate, String endDate) {
		List<Lottery> list = new ArrayList<Lottery>();
		int a = 1;
		int b = 0;
			for(int i = 0 ; i < 9 ;i++ ) {
				Lottery obj = new Lottery();
				obj.setRun(String.valueOf(a++));
				obj.setRunPrice(b+=5);
				list.add(obj);
			}
		
		return list;
	}

	public List<Lottery> LotteryUnderRun(String startDate, String endDate) {
		List<Lottery> list = new ArrayList<Lottery>();
		int a = 1;
		int b = 0;
			for(int i = 0 ; i < 9 ;i++ ) {
				Lottery obj = new Lottery();
				obj.setUnderRun(String.valueOf(a++));
				obj.setUnderRunPrice(b+=5);
				list.add(obj);
			}
		
		return list;
	}

	public List<HistoryModel> getHistory(String startDate, String endDate) throws Exception {
		List<HistoryModel> list = new ArrayList<HistoryModel>();
		int a = 1000;
		int b = 1000;
		int c = 1000;
		int d = 1000;
		int e = 1000;
		int f = 1000;
		
		for(int i = 0 ; i< 5 ;i++) {
			HistoryModel obj = new HistoryModel();
			obj.setCreateDate("2022-06-24");
			obj.setSumTopThreePrice(a+=50);
			obj.setSumTodPrice(b+=50);
			obj.setSumTopTwoPrice(c+=50);
			obj.setSumUnderTwoPrice(d+=50);
			obj.setSumRunPrice(e+=50);
			obj.setSumUnderRunPrice(f+=50);
			obj.setSumPrice(a+b+c+d+e+f);
			list.add(obj);
		}
		return list;
	}

	public void deleteLotter(Long id) throws Exception {
		
		
	}

	public List<LotteryModel> LotteryTodSearch(String startDate, String endDate, List<String> list1) {
		List<LotteryModel> list = new ArrayList<LotteryModel>();
			LotteryModel obj = new LotteryModel();
			obj.setTodStr("123");
			obj.setTod("123");
			obj.setTodPrice(50);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("132");
			obj.setTodPrice(100);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("213");
			obj.setTodPrice(150);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("231");
			obj.setTodPrice(200);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("321");
			obj.setTodPrice(250);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("312");
			obj.setTodPrice(300);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("456");
			obj.setTod("456");
			obj.setTodPrice(50);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("465");
			obj.setTodPrice(100);
			list.add(obj);
			
		     obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("546");
			obj.setTodPrice(150);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("564");
			obj.setTodPrice(200);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("645");
			obj.setTodPrice(250);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("");
			obj.setTod("654");
			obj.setTodPrice(300);
			list.add(obj);
			
			obj = new LotteryModel();
			obj.setTodStr("111");
			obj.setTod("111");
			obj.setTodPrice(100);
			list.add(obj);
		return list;
	
	}
	
	
	
}

