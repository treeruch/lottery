package com.hendisantika.service;

import java.util.ArrayList;
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
		return  new ArrayList<>();
	}

	public List<LotteryModel> LotteryTod(String startDate, String endDate, List<String> list) {

		List<Object[]> listArrayObject = new ArrayList<>();
		List<Lottery> listlottery = new ArrayList<>();
		List<LotteryModel> listLotteryModels = new ArrayList<>();
		LotteryModel objModel = new LotteryModel();
		
		/*Object[] obj = new Object[6];
		try {
			
			if(list.size() == 0) {
				listlottery = lotteryRepository.LotteryTod(startDate,endDate,null);
				for (Lottery ls : listlottery) {
					objModel = new LotteryModel();
					objModel.setTod(ls.getTod());
					objModel.setTodPrice(ls.getTodPrice());
					listLotteryModels.add(objModel);
				}
				return  listLotteryModels;
			}
			
			for(String tod: list) {
				if(tod.length() == 3) {
					obj = new Object[6];
					utilService.random6(obj,tod);
					listArrayObject.add(obj);
				} 
			}
			
			for(int i = 0 ; i < listArrayObject.size() ; i++){
				listlottery = lotteryRepository.LotteryTod(startDate,endDate,listArrayObject.get(i));
				
				for(int j = 0 ; j < listlottery.size() ; j++ ) {
					objModel = new LotteryModel();
					if(j == 0) {
						Object[] obJect = listArrayObject.get(i);
						String key = (String) obJect[0];
						objModel.setTodStr(key);
					} else {
						objModel.setTodStr("");
					}
					objModel.setTod(listlottery.get(j).getTod());
					objModel.setTodPrice(listlottery.get(j).getTodPrice());
					listLotteryModels.add(objModel);
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} */
		return  listLotteryModels;
	}

	public List<Lottery> LotteryTopTwo(String startDate, String endDate) {
		return new ArrayList<Lottery>();
	}

	public List<Lottery> LotteryUnderTwo(String startDate, String endDate) {
		return new ArrayList<Lottery>();
	}

	public List<Lottery> LotteryUnderTwoPrice(String startDate, String endDate) {
		return new ArrayList<Lottery>();
	}

	public List<Lottery> LotteryRun(String startDate, String endDate) {
		return new ArrayList<Lottery>();
	}

	public List<Lottery> LotteryRunPrice(String startDate, String endDate) {
		return new ArrayList<Lottery>();
	}

	public List<Lottery> LotteryUnderRun(String startDate, String endDate) {
		return new ArrayList<Lottery>();
	}

	public List<HistoryModel> getHistory(String startDate, String endDate) throws Exception {
		return new ArrayList<HistoryModel>();
	}

	public void deleteLotter(Long id) throws Exception {
		
		
	}
	
	
	
}

