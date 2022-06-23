package com.hendisantika.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hendisantika.entity.Lottery;
import com.hendisantika.entity.UserLotter;
import com.hendisantika.service.LotteryService;
import com.hendisantika.service.UtilService;


@Controller
public class WebPageController {
	
	@Autowired
	private UtilService formatService;

	@Autowired
	private LotteryService lotteryService;
	
	 private static final String LOGIN = "/login";
	 private static final String FORM = "/form";
	 
	 private static final String VIEW_DASHBOARD = "lotteryDashboard";
	 private static final String VIEW_LOGIN = "lotteryLogin";
	 private static final String VIEW_FORM = "formDashboard";
	 
	 private static final SimpleDateFormat sdf_ddMMyyyy = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
	 
    @GetMapping(LOGIN)
    public ModelAndView login(UserLotter userLottery, HttpSession session) {
    	ModelAndView modelview = new ModelAndView();
    	//modelAndView.setViewName(VIEW_LOGIN);
    	modelview.setViewName(VIEW_DASHBOARD);
    	try {
    		// headerDashBoard
    		String startDate = sdf_ddMMyyyy.format(new Date());
    		String endDate = sdf_ddMMyyyy.format(new Date());
    		List<Lottery> listDashBoard = new ArrayList<>();
    		formatService.headerDashBoard(modelview,listDashBoard);
    		
    		modelview.addObject("startDate",startDate);
    		modelview.addObject("endDate",endDate);
    		this.setSession(session,startDate,endDate);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
        return modelview;
    }
    
	@RequestMapping(value = FORM,method = {RequestMethod.POST})
    public ModelAndView form(UserLotter userLottery) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName(VIEW_FORM);
        return modelAndView;
    }
	
	private void setSession(HttpSession session, String startDate, String endDate) {
		session.setAttribute("startDate", startDate);
		session.setAttribute("endDate", endDate);
}
    
}
