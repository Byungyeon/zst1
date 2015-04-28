package com.bque.zst1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bque.zst1.annotation.NotLogin;
import com.bque.zst1.utils.ServletRequestInfoUtil;

@Controller
public class AngularController {
	
	private static final Logger logger = LoggerFactory.getLogger(AngularController.class);
	
	/**
	 * angular test
	 */
	@NotLogin
	@RequestMapping(value = {"/angular_01", "/angular_02"} )
	public String angular(Locale locale, Model model, ModelMap map) {
		
		return "/angular" + ServletRequestInfoUtil.getRequest().getRequestURI();
	}
	
	/**
	 * angular json
	 */
	@NotLogin
	@ResponseBody
	@RequestMapping(value = {"/angular_02_json"}, produces = "application/json; charset=utf8" )
	public String angularJson(Locale locale, Model model, ModelMap map) {
		
		ArrayList<Object> list = new ArrayList<Object>();
		HashMap<String, String> dataMap = new HashMap<String, String>(); 
		
		dataMap.put("no", "no1");
		dataMap.put("name", "이름1");
		dataMap.put("snippet", "설명1");
		list.add(dataMap);
		
		dataMap = new HashMap<String, String>();
		dataMap.put("no", "no2");
		dataMap.put("name", "이름2");
		dataMap.put("snippet", "설명2");
		list.add(dataMap);
		
		dataMap = new HashMap<String, String>();
		dataMap.put("no", "no3");
		dataMap.put("name", "이름3");
		dataMap.put("snippet", "설명3");
		list.add(dataMap);
		
		JSONObject json = new JSONObject();

		json.put("list", list);
		
		
		return json.toString();
	}
	
}
