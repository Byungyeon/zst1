package com.bque.zst1.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bque.zst1.annotation.NotLogin;
import com.bque.zst1.dao.TestDao;
import com.bque.zst1.utils.SOMap;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TestDao testDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, ModelMap map) throws Exception{
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		SOMap params = new SOMap();
		
		List list = testDao.selectTestList(params);
		
		map.put("list", list);
		
		return "home";
	}
	
	/**
	 * web chat
	 */
	@NotLogin
	@RequestMapping(value = "/webChat")
	public String webChat(Locale locale, Model model) {
		
		return "webChat";
	}
	
	/**
	 * loginCustom
	 */
	@NotLogin
	@RequestMapping(value = "/loginCustom")
	public String loginCustom(Locale locale, Model model) {
		
		return "loginCustom";
	}
	
}
