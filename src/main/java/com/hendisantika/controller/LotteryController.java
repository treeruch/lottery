package com.hendisantika.controller;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hendisantika.entity.Lottery;
import com.hendisantika.entity.UserLotter;
import com.hendisantika.model.HistoryModel;
import com.hendisantika.model.LotteryModel;
import com.hendisantika.service.ImportExcelService;
import com.hendisantika.service.LotteryService;
import com.hendisantika.service.UtilService;

@Controller
public class LotteryController {
	
	@Autowired
	private UtilService formatService;

	@Autowired
	private LotteryService lotteryService;
	
	@Autowired
	private ImportExcelService importExcelService;
	
	@Autowired
	private UtilService utilService;
	
	 private static final String MAP_UPLOAD_FILE = "/uploadFile";
	 private static final String MAP_UPLOAD = "/upload";
	 
	 private static final String DASHBOARD = "/dashboard";
	 private static final String MAP_HISTORY = "/history";
	 private static final String MAP_LOTTERY_TOP_THREE = "/LotteryTopThree";
	 private static final String MAP_LOTTERY_TOD = "/LotteryTod";
	 private static final String MAP_LOTTERY_TOP_TWO = "/LotteryTopTwo";
	 private static final String MAP_LOTTERY_UNDER_TWO = "/LotteryUnderTwo";
	 private static final String MAP_LOTTERY_TOP_RUN = "/LotteryTopRun";
	 private static final String MAP_LOTTERY_UNDER_RUN = "/LotteryUnderRun";
	 
	 private static final String MAP_SEARCH_DASH_BORD = "/SearchDashBord";
	 private static final String MAP_SERCH_HISTORY = "/searchHistory";
	 private static final String MAP_SEARCH_LOTTERY_TOP_THREE = "/SearchLotteryTopThree";
	 private static final String MAP_SEARCH_LOTTERY_TOD = "/SearchLotteryTod";
	 private static final String MAP_SEARCH_LOTTERY_TOP_TWO = "/SearchLotteryTopTwo";
	 private static final String MAP_SEARCH_LOTTERY_UNDER_TWO = "/SearchLotteryUnderTwo";
	 private static final String MAP_SEARCH_LOTTERY_TOP_RUN = "/SearchLotteryTopRun";
	 private static final String MAP_SEARCH_LOTTERY_UNDER_RUN = "/SearchLotteryUnderRun";
	 
	 private static final String VIEW_DASHBOARD = "lotteryDashboard";
	 private static final String VIEW_HISTORY = "lotteryHistory";
	 private static final String VIEW_FORM_DASH_BOARD = "formDashBoard";
	 private static final String VIEW_FORM_DASH_BOARD2 = "index2";
	 private static final String VIEW_FORM_DASH_BOARD3 = "index3";
	 private static final String VIEW_UPLOAD_FILE = "uploadFile";
	 
	 private static final String VIEW_LOTTERY_TOP_THREE = "lotteryTopThree";
	 private static final String VIEW_LOTTERY_TOD = "lotteryTod";
	 private static final String VIEW_LOTTERY_TOP_TWO = "lotteryTopTwo";
	 private static final String VIEW_LOTTERY_UNDER_TWO = "lotteryUnderTwo";
	 private static final String VIEW_LOTTERY_TOP_RUN = "lotteryTopRun";
	 private static final String VIEW_LOTTERY_UNDER_RUN = "lotteryUnderRun";
	 
	 private static final String MAP_EXPORT_TOP_THREE = "/exportTopThree";
	 private static final String MAP_EXPORT_TOD = "/exportTod";
	 private static final String MAP_EXPORT_TOP_TWO = "/exportTopTwo";
	 private static final String MAP_EXPORT_UNDER_TWO = "/exportUnderTwo";
	 private static final String MAP_EXPORT_TOP_RUN = "/exportTopRun";
	 private static final String MAP_EXPORT_UNDER_RUN = "/exportUnderRun";
	 
	 //TEST
	 private static final String MAP_FORM_DASH_BOARD = "/FormDashBoard";
	 private static final String MAP_FORM_DASH_BOARD2 = "/FormDashBoard2";
	 private static final String MAP_FORM_DASH_BOARD3 = "/FormDashBoard3";
	 
	 private static final String VIEW_LOTTERY_ERROR = "lotteryError";
	
	 
	 private static final SimpleDateFormat sdf_ddMMyyyy = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
	 
	 @RequestMapping(value = DASHBOARD,method = {RequestMethod.POST})
	    public ModelAndView loginUser(UserLotter userLottery) {
	    	ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName(VIEW_DASHBOARD);
	        return modelAndView;
	    }
	    
		@GetMapping(DASHBOARD)
	    public ModelAndView dashBoard(UserLotter userLottery, HttpSession session) {
	    	ModelAndView modelview = new ModelAndView();
	    	modelview.setViewName(VIEW_DASHBOARD);
	    	try {
	    		// headerDashBoard
	    		String startDate = sdf_ddMMyyyy.format(new Date());
	    		String endDate = sdf_ddMMyyyy.format(new Date());
	    		List<Lottery> listDashBoard = new ArrayList<Lottery>();
	    		formatService.headerDashBoard(modelview,listDashBoard);
	    		
	    		modelview.addObject("startDate",startDate);
	    		modelview.addObject("endDate",endDate);
	    		this.setSession(session,startDate,endDate);
	    		
			} catch (Exception e) {
				modelview.setViewName(VIEW_LOTTERY_ERROR);
				e.printStackTrace();
			}
	        return modelview;
	 }
		
	@GetMapping(MAP_HISTORY)
	 public ModelAndView history(UserLotter userLottery, HttpSession session) throws Exception {
		ModelAndView modelview = new ModelAndView();
		try {
			String startDate = sdf_ddMMyyyy.format(new Date());
			String endDate = sdf_ddMMyyyy.format(new Date());
			
			modelview.addObject("startDate",startDate);
			modelview.addObject("endDate",endDate);
			
			List<HistoryModel> history = lotteryService.getHistory(startDate,endDate);
			modelview.addObject("listHistory",history);
			modelview.setViewName(VIEW_HISTORY);
		} catch (Exception e) {
			modelview.setViewName(VIEW_LOTTERY_ERROR);
			e.printStackTrace();
		}
		
	    return modelview;
	 }
	
	@GetMapping("/{id}")
	public ModelAndView DeleteLottery(@PathVariable(name = "id", required = false) Long id,
			Model model, HttpSession session) throws Exception {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_HISTORY);
		System.out.println("id : "+ id);
		
		String startDate = (String) session.getAttribute("startDate");
		String endDate = (String) session.getAttribute("endDate");
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		
		lotteryService.deleteLotter(id);
		
		List<HistoryModel> history = lotteryService.getHistory(startDate,endDate);
		modelview.addObject("listHistory",history);
		return modelview; // view
	}
	
	@RequestMapping(value = MAP_SERCH_HISTORY,method = {RequestMethod.POST})
	public ModelAndView SearchHistory(LotteryModel lottery, HttpSession session) throws Exception{
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_HISTORY);
		try {
			String startDate = "";
			String endDate = "";
			if(lottery.getStartDate() != null && lottery.getStartDate() != "") {
				startDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getStartDate()));
			} else {
				startDate =  sdf_ddMMyyyy.format(new Date());
			}
			
			if(lottery.getEndDate() != null && lottery.getEndDate() != "") {
				endDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getEndDate()));
			} else {
				endDate = sdf_ddMMyyyy.format(new Date());
			}
			
			// headerDashBoard
			List<HistoryModel> history = lotteryService.getHistory(startDate,endDate);
			modelview.addObject("listHistory",history);
			modelview.addObject("startDate",startDate);
			modelview.addObject("endDate",endDate);
			this.setSession(session,startDate,endDate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelview; // view
	}
	
	 @GetMapping(MAP_FORM_DASH_BOARD)
	    public ModelAndView FormDashBoard(UserLotter userLottery, HttpSession session) {
	    	ModelAndView modelview = new ModelAndView();
	    	modelview.setViewName(VIEW_FORM_DASH_BOARD);
	        return modelview;
	  }
	 
	 @GetMapping(MAP_UPLOAD_FILE)
	    public ModelAndView UploadFile(UserLotter userLottery) {
	    	ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName(VIEW_UPLOAD_FILE);
	        return modelAndView;
	  }
	 
	 @RequestMapping(value = MAP_UPLOAD,method = {RequestMethod.POST})
		public ModelAndView importExcelFile(@RequestParam("file") MultipartFile files,LotteryModel lottery, HttpSession session) throws Exception{
			ModelAndView modelview = new ModelAndView();
			modelview.setViewName(VIEW_UPLOAD_FILE);
			
			String text = "";
			try {
				
				text = importExcelService.readFileExcel(files);
				 
				// headerDashBoard
				 String startDate = sdf_ddMMyyyy.format(new Date());
				 String endDate = sdf_ddMMyyyy.format(new Date()); 
				 List<Lottery> listDashBoard =lotteryService.getDashBoard(startDate,endDate);
				 formatService.headerDashBoard(modelview,listDashBoard);
				  
				 modelview.addObject("startDate",startDate);
				 modelview.addObject("endDate",endDate);
				 System.out.println("End importExcelFile..."); 
				
				 if("".equals(text)) {
					 modelview.addObject("success","Upload file success.");
				 } else {
					 modelview.addObject("error",text);
				 } 
				
			} catch (Exception e) {
				 modelview.addObject("error","Error.");
				e.printStackTrace();
			}
			return modelview; // view
		}

	 
	 @GetMapping(MAP_FORM_DASH_BOARD2)
	    public ModelAndView FormDashBoard2(UserLotter userLottery) {
	    	ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName(VIEW_FORM_DASH_BOARD2);
	        return modelAndView;
	  }
	 
	 @RequestMapping(value = MAP_SEARCH_DASH_BORD,method = {RequestMethod.POST})
		public ModelAndView SearchDashBord(LotteryModel lottery, HttpSession session) throws Exception{
			ModelAndView modelview = new ModelAndView();
			modelview.setViewName(VIEW_DASHBOARD);
			try {
				String startDate = "";
				String endDate = "";
				if(lottery.getStartDate() != null && lottery.getStartDate() != "") {
					startDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getStartDate()));
				} else {
					startDate =  sdf_ddMMyyyy.format(new Date());
				}
				
				if(lottery.getEndDate() != null && lottery.getEndDate() != "") {
					endDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getEndDate()));
				} else {
					endDate = sdf_ddMMyyyy.format(new Date());
				}
				
				// headerDashBoard
				List<Lottery> listDashBoard = lotteryService.getDashBoard(startDate,endDate);
				modelview.addObject("startDate",startDate);
				modelview.addObject("endDate",endDate);
				formatService.headerDashBoard(modelview,listDashBoard);
				this.setSession(session,startDate,endDate);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return modelview; // view
		}
	 
	 @GetMapping(MAP_FORM_DASH_BOARD3)
	    public ModelAndView FormDashBoard3(UserLotter userLottery) {
	    	ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName(VIEW_FORM_DASH_BOARD3);
	        return modelAndView;
	  }
	 
	@GetMapping(MAP_LOTTERY_TOP_THREE)
	public ModelAndView LotteryTopThree(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model, HttpSession session)  throws Exception  {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_TOP_THREE);
		
		String startDate = (String) session.getAttribute("startDate");
		String endDate = (String) session.getAttribute("endDate");
		
		List<Lottery> listTopThree = new ArrayList<>();
		listTopThree = lotteryService.LotteryTopThree(startDate,endDate);
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		modelview.addObject("listTopThree", listTopThree);
		session.setAttribute("listData", listTopThree);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}
	
	@RequestMapping(value = MAP_SEARCH_LOTTERY_TOP_THREE,method = {RequestMethod.POST})
	public ModelAndView LotteryTopThree(LotteryModel lottery, HttpSession session) throws Exception{
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_TOP_THREE);
		
		try {
			String startDate = sdf_ddMMyyyy.format(new Date());
			String endDate = sdf_ddMMyyyy.format(new Date());
			if(lottery.getStartDate() != null && lottery.getStartDate() != "") {
				startDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getStartDate()));
			} else {
				startDate =  sdf_ddMMyyyy.format(new Date());
			}
			
			if(lottery.getEndDate() != null && lottery.getEndDate() != "") {
				endDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getEndDate()));
			} else {
				endDate = sdf_ddMMyyyy.format(new Date());
			}
	        
			List<Lottery> listTopThree = new ArrayList<>();
			listTopThree = lotteryService.LotteryTopThree(startDate,endDate);
			
			modelview.addObject("startDate",startDate);
			modelview.addObject("endDate",endDate);
			modelview.addObject("listTopThree", listTopThree);
			session.setAttribute("listData", listTopThree);
			session.setAttribute("startDateEndDate", startDate + " - "+endDate);
			modelview.addObject("startAndEndDate", startDate + " - "+endDate);
			this.setSession(session,startDate,endDate);
		} catch (Exception e) {
			modelview.setViewName(VIEW_LOTTERY_TOP_THREE);
			e.printStackTrace();
		}
		return modelview; // view
	}
	
	@GetMapping(MAP_LOTTERY_TOD)
	public ModelAndView LotteryTod(HttpServletRequest request,@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model, HttpSession session)  throws Exception  {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_TOD);
		
		String startDate = (String) session.getAttribute("startDate");
		String endDate = (String) session.getAttribute("endDate");
		
		List<LotteryModel> listTod = new ArrayList<>();
		
		listTod = lotteryService.LotteryTod(startDate,endDate,new ArrayList<String>());
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		
		List<Lottery> listTod1 = new ArrayList<>();
		modelview.addObject("listTod", listTod1);
		modelview.addObject("listTodFilter", listTod);
		modelview.addObject("checkFilter", "");
		
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		
		session.setAttribute("checkListTodFilter", null);
		session.setAttribute("listTodFilter", listTod);
		session.setAttribute("listData", listTod);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}
	 
	@RequestMapping(value = MAP_SEARCH_LOTTERY_TOD,method = {RequestMethod.POST})
	public ModelAndView LotteryTod(HttpServletRequest request,LotteryModel lottery, HttpSession session) throws Exception{
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_TOD);
	   try {
		   
			String startDate = sdf_ddMMyyyy.format(new Date());
			String endDate = sdf_ddMMyyyy.format(new Date());
			if(lottery.getStartDate() != null && lottery.getStartDate() != "") {
				startDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getStartDate()));
			} else {
				startDate =  sdf_ddMMyyyy.format(new Date());
			}
			
			if(lottery.getEndDate() != null && lottery.getEndDate() != "") {
				endDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getEndDate()));
			} else {
				endDate = sdf_ddMMyyyy.format(new Date());
			}
			
			List<String> list = new ArrayList<>();
			if(null != lottery.getTodStrfilter()) {
				  String[] arrayFilter = lottery.getTodStrfilter();
				  if(arrayFilter.length > 0) {
					  List<LotteryModel> listTod = lotteryService.LotteryTodSearch(startDate, endDate, list);
						modelview.addObject("checkFilter", "haveData");
						session.setAttribute("checkListTodFilter", "haveData");
						session.setAttribute("listTodFilter", listTod);
						modelview.addObject("listTodFilter", listTod);
				  } else {
					  modelview.addObject("checkFilter", "");
					  List<LotteryModel> listTod1 = lotteryService.LotteryTod(startDate, endDate, list);
						session.setAttribute("checkListTodFilter", null);
						session.setAttribute("listTodFilter", listTod1);
						session.setAttribute("listData", listTod1);
						modelview.addObject("listTodFilter", listTod1);
				  }
			}
			
			modelview.addObject("startDate",startDate);
			modelview.addObject("endDate",endDate);
			modelview.addObject("todPrice",lottery.getTodPrice());
			
			modelview.addObject("startAndEndDate", startDate + " - "+endDate);
			session.setAttribute("startDateEndDate", startDate + " - "+endDate);
			this.setSession(session,startDate,endDate);
			} catch (Exception e) {
				e.printStackTrace();
			}

		return modelview; 
	}
	
	@GetMapping(MAP_LOTTERY_TOP_TWO)
	public ModelAndView LotteryTopTwo(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model, HttpSession session) throws Exception {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_TOP_TWO);
		
		String startDate = (String) session.getAttribute("startDate");
		String endDate = (String) session.getAttribute("endDate");
		
		List<Lottery> list = new ArrayList<>();
		list = lotteryService.LotteryTopTwo(startDate,endDate);
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		modelview.addObject("listTopTwo", list);
		session.setAttribute("listData", list);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}
	
	@RequestMapping(value = MAP_SEARCH_LOTTERY_TOP_TWO,method = {RequestMethod.POST})
	public ModelAndView LotteryTopTwo(LotteryModel lottery, HttpSession session) throws Exception{
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_TOP_TWO);
		
		String startDate = sdf_ddMMyyyy.format(new Date());
		String endDate = sdf_ddMMyyyy.format(new Date());
		if(lottery.getStartDate() != null && lottery.getStartDate() != "") {
			startDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getStartDate()));
		} else {
			startDate =  sdf_ddMMyyyy.format(new Date());
		}
		
		if(lottery.getEndDate() != null && lottery.getEndDate() != "") {
			endDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getEndDate()));
		} else {
			endDate = sdf_ddMMyyyy.format(new Date());
		}
        
		List<Lottery> list = new ArrayList<>();
		list = lotteryService.LotteryTopTwo(startDate,endDate);
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		modelview.addObject("listTopTwo", list);
		session.setAttribute("listData", list);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}
	
	@GetMapping(MAP_LOTTERY_UNDER_TWO)
	public ModelAndView LotteryUnderTwo(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model, HttpSession session) throws Exception {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_UNDER_TWO);
		
		String startDate = (String) session.getAttribute("startDate");
		String endDate = (String) session.getAttribute("endDate");
		
		
		List<Lottery> list = new ArrayList<>();
		list = lotteryService.LotteryUnderTwo(startDate,endDate);
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		modelview.addObject("listUnderTwo", list);
		session.setAttribute("listData", list);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}
	
	@RequestMapping(value = MAP_SEARCH_LOTTERY_UNDER_TWO,method = {RequestMethod.POST})
	public ModelAndView LotteryUnderTwo(LotteryModel lottery, HttpSession session) throws Exception{
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_UNDER_TWO);
		
		String startDate = sdf_ddMMyyyy.format(new Date());
		String endDate = sdf_ddMMyyyy.format(new Date());
		if(lottery.getStartDate() != null && lottery.getStartDate() != "") {
			startDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getStartDate()));
		} else {
			startDate =  sdf_ddMMyyyy.format(new Date());
		}
		
		if(lottery.getEndDate() != null && lottery.getEndDate() != "") {
			endDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getEndDate()));
		} else {
			endDate = sdf_ddMMyyyy.format(new Date());
		}
        
		List<Lottery> list = new ArrayList<>();
		list = lotteryService.LotteryUnderTwo(startDate,endDate);
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		modelview.addObject("listUnderTwo", list);
		session.setAttribute("listData", list);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}
	
	@GetMapping(MAP_LOTTERY_TOP_RUN)
	public ModelAndView LotteryRun(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model, HttpSession session) throws Exception {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_TOP_RUN);
		

		String startDate = (String) session.getAttribute("startDate");
		String endDate = (String) session.getAttribute("endDate");
		
		List<Lottery> list = new ArrayList<>();
		list = lotteryService.LotteryRun(startDate,endDate);
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		modelview.addObject("listRunTop", list);
		session.setAttribute("listData", list);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}
	
	@RequestMapping(value = MAP_SEARCH_LOTTERY_TOP_RUN,method = {RequestMethod.POST})
	public ModelAndView LotteryRun(LotteryModel lottery, HttpSession session) throws Exception{
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_TOP_RUN);
		
		String startDate = sdf_ddMMyyyy.format(new Date());
		String endDate = sdf_ddMMyyyy.format(new Date());
		if(lottery.getStartDate() != null && lottery.getStartDate() != "") {
			startDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getStartDate()));
		} else {
			startDate =  sdf_ddMMyyyy.format(new Date());
		}
		
		if(lottery.getEndDate() != null && lottery.getEndDate() != "") {
			endDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getEndDate()));
		} else {
			endDate = sdf_ddMMyyyy.format(new Date());
		}
        
		List<Lottery> list = new ArrayList<>();
		list = lotteryService.LotteryRun(startDate,endDate);
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		modelview.addObject("listRunTop", list);
		session.setAttribute("listData", list);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}
	
	@GetMapping(MAP_LOTTERY_UNDER_RUN)
	public ModelAndView LotteryUnderRun(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model, HttpSession session) throws Exception {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_UNDER_RUN);

		String startDate = (String) session.getAttribute("startDate");
		String endDate = (String) session.getAttribute("endDate");
		
		List<Lottery> list = new ArrayList<>();
		list = lotteryService.LotteryUnderRun(startDate,endDate);
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		modelview.addObject("listRunUnder", list);
		session.setAttribute("listData", list);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}
	
	@RequestMapping(value = MAP_SEARCH_LOTTERY_UNDER_RUN,method = {RequestMethod.POST})
	public ModelAndView LotteryUnderRun(LotteryModel lottery, HttpSession session) throws Exception{
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(VIEW_LOTTERY_UNDER_RUN);
		
		String startDate = sdf_ddMMyyyy.format(new Date());
		String endDate = sdf_ddMMyyyy.format(new Date());
		if(lottery.getStartDate() != null && lottery.getStartDate() != "") {
			startDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getStartDate()));
		} else {
			startDate =  sdf_ddMMyyyy.format(new Date());
		}
		
		if(lottery.getEndDate() != null && lottery.getEndDate() != "") {
			endDate = sdf_ddMMyyyy.format(sdf_ddMMyyyy.parse(lottery.getEndDate()));
		} else {
			endDate = sdf_ddMMyyyy.format(new Date());
		}
        
		List<Lottery> list = new ArrayList<>();
		list = lotteryService.LotteryUnderRun(startDate,endDate);
		
		modelview.addObject("startDate",startDate);
		modelview.addObject("endDate",endDate);
		modelview.addObject("listRunUnder", list);
		session.setAttribute("listData", list);
		session.setAttribute("startDateEndDate", startDate + " - "+endDate);
		modelview.addObject("startAndEndDate", startDate + " - "+endDate);
		this.setSession(session,startDate,endDate);
		return modelview; // view
	}

	
	@SuppressWarnings({ "unchecked", "resource" })
	@RequestMapping(value = MAP_EXPORT_TOD, method = {RequestMethod.GET})
	@ResponseBody
	public byte[] ExportLotteryTod(@PathVariable(name = "listStrFilter", required = false) String listStrFilter,HttpServletRequest request,LotteryModel lottery, 
			HttpSession session, HttpServletResponse response) throws Exception{
		
		String checkListTodFilter = (String) session.getAttribute("checkListTodFilter");
		String startDateEndDate = (String) session.getAttribute("startDateEndDate");
		List<LotteryModel> list = new ArrayList<>();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		if(checkListTodFilter == null) {
			response.setHeader("Content-Disposition", "attachment;filename=\"LotteryTod.xlsx\"");
			list = (List<LotteryModel>) session.getAttribute("listData");
			String header = "สามต้วโต๊ด, ราคา / บาท"; 
			workbook = utilService.getExcel(header,list,startDateEndDate);
		} else {
			response.setHeader("Content-Disposition", "attachment;filename=\"LotteryTodFilter.xlsx\"");
			list = (List<LotteryModel>) session.getAttribute("listTodFilter");
			String header = "กลุ่ม,สามต้วบน, ราคา / บาท"; 
			workbook = utilService.getExcelFilter(header,list,startDateEndDate);
		}
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	   try {
		   workbook.write(byteArrayOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				byteArrayOutputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return byteArrayOutputStream.toByteArray(); 
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	@RequestMapping(value = MAP_EXPORT_TOP_THREE, method = {RequestMethod.GET})
	@ResponseBody
	public byte[] ExportLotteryTopThree(HttpServletRequest request,LotteryModel lottery, 
			HttpSession session, HttpServletResponse response) throws Exception{
		
		List<Lottery> list = new ArrayList<>();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		response.setHeader("Content-Disposition", "attachment;filename=\"LotteryTopThree.xlsx\"");
		list = (List<Lottery>) session.getAttribute("listData");
		String startDateEndDate = (String) session.getAttribute("startDateEndDate");
		String header = "สามตัวบน, ราคา / บาท"; 
		workbook = utilService.getExcelTopThree(header,list,startDateEndDate);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	   try {
		   workbook.write(byteArrayOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				byteArrayOutputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return byteArrayOutputStream.toByteArray(); 
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	@RequestMapping(value = MAP_EXPORT_TOP_TWO, method = {RequestMethod.GET})
	@ResponseBody
	public byte[] ExportLotteryTopTwo(HttpServletRequest request,LotteryModel lottery, 
			HttpSession session, HttpServletResponse response) throws Exception{
		
		List<Lottery> list = new ArrayList<>();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		response.setHeader("Content-Disposition", "attachment;filename=\"LotteryTopTwo.xlsx\"");
		list = (List<Lottery>) session.getAttribute("listData");
		String startDateEndDate = (String) session.getAttribute("startDateEndDate");
		String header = "สองตัวบน, ราคา / บาท"; 
		workbook = utilService.getExcelTopTwo(header,list,startDateEndDate);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	   try {
		   workbook.write(byteArrayOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				byteArrayOutputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return byteArrayOutputStream.toByteArray(); 
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	@RequestMapping(value = MAP_EXPORT_UNDER_TWO, method = {RequestMethod.GET})
	@ResponseBody
	public byte[] ExportLotteryUnderTwo(HttpServletRequest request,LotteryModel lottery, 
			HttpSession session, HttpServletResponse response) throws Exception{
		
		List<Lottery> list = new ArrayList<>();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		response.setHeader("Content-Disposition", "attachment;filename=\"LotteryUnderTwo.xlsx\"");
		list = (List<Lottery>) session.getAttribute("listData");
		String startDateEndDate = (String) session.getAttribute("startDateEndDate");
		String header = "สองตัวล่าง, ราคา / บาท"; 
		workbook = utilService.getExcelUnderTwo(header,list,startDateEndDate);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	   try {
		   workbook.write(byteArrayOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				byteArrayOutputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return byteArrayOutputStream.toByteArray(); 
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	@RequestMapping(value = MAP_EXPORT_TOP_RUN, method = {RequestMethod.GET})
	@ResponseBody
	public byte[] ExportLotteryTopRun(HttpServletRequest request,LotteryModel lottery, 
			HttpSession session, HttpServletResponse response) throws Exception{
		
		List<Lottery> list = new ArrayList<>();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		response.setHeader("Content-Disposition", "attachment;filename=\"LotteryTopRun.xlsx\"");
		list = (List<Lottery>) session.getAttribute("listData");
		String startDateEndDate = (String) session.getAttribute("startDateEndDate");
		String header = "วิ่งบน, ราคา / บาท"; 
		workbook = utilService.getExcelTopRun(header,list,startDateEndDate);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	   try {
		   workbook.write(byteArrayOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				byteArrayOutputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return byteArrayOutputStream.toByteArray(); 
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	@RequestMapping(value = MAP_EXPORT_UNDER_RUN, method = {RequestMethod.GET})
	@ResponseBody
	public byte[] ExportLotteryUnderRun(HttpServletRequest request,LotteryModel lottery, 
			HttpSession session, HttpServletResponse response) throws Exception{
		
		List<Lottery> list = new ArrayList<>();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		response.setHeader("Content-Disposition", "attachment;filename=\"LotteryUnderRun.xlsx\"");
		list = (List<Lottery>) session.getAttribute("listData");
		String startDateEndDate = (String) session.getAttribute("startDateEndDate");
		String header = "วิ่งล่าง, ราคา / บาท"; 
		workbook = utilService.getExcelUnderRun(header,list,startDateEndDate);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	   try {
		   workbook.write(byteArrayOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				byteArrayOutputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return byteArrayOutputStream.toByteArray(); 
	}
	
	 private void setSession(HttpSession session, String startDate, String endDate) {
			session.setAttribute("startDate", startDate);
			session.setAttribute("endDate", endDate);
	}

}
