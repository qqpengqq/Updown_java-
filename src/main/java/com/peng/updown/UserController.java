package com.peng.updown;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
/**
 * 下拉选项
 * @author peng
 *
 */
@Controller
public class UserController {
	
	 @Autowired
	 ServletContext context; 

	
	@RequestMapping(value = {"/"} , method = RequestMethod.GET)
	public ModelAndView user() {
		
		//用户初始化时所传的值
		User user = new User();
		user.setFavoriteFrameworks(new String[] {"Struts 2" , "Apache Hodoop"});
		user.setGender("M");
		user.setFavoriteNumber("2");
		return new ModelAndView("user" , "command" , user);
	}
	
	//连接action = "/RadioButtons/adduser",发出POST方法时，此方法启动，返回resulst.jsp视图
	@RequestMapping(value = {"/adduser"} , method = RequestMethod.POST)
	public String adduser(User user , ModelMap model) throws IOException{
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
	    model.addAttribute("address", user.getAddress());
	    model.addAttribute("receivePaper", user.isReceivePaper());
	    model.addAttribute("favoriteFrameworks", user.getFavoriteFrameworks());
	    model.addAttribute("gender", user.getGender());
	    model.addAttribute("favoriteNumber", user.getFavoriteNumber());
	    model.addAttribute("country", user.getCountry());
	    MultipartFile file = user.getFile();
	    String filePath = context.getRealPath("")+File.separator+"temp" + File.separator+file.getOriginalFilename();
		FileCopyUtils.copy(file.getBytes(), new File(filePath));
	    model.addAttribute("filepath", filePath);
		return "result";
	}
	
	/**
	 * 设置复选项目
	 * @return
	 */
	@ModelAttribute("webFrameworkList")
	public List<String> getfavoriteFrameworks(){
		List<String> webFrameworkList = new ArrayList<>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Spring boot");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("Apache Hodoop");
		
		return webFrameworkList;
	}
	
	/**
	 * 设置多项单选的项目
	 * @return
	 */
	@ModelAttribute("numbersList")
	public List<String> getnumbersList(){
		List<String> numbersList = new ArrayList<>();
		numbersList.add("1");
		numbersList.add("2");
		numbersList.add("3");
		numbersList.add("4");
		return numbersList;
	}
	
	/**
	 * 下拉列表
	 */
	@ModelAttribute("countryList")
	public List<String> getdownlist(){
		List<String> countryList = new ArrayList<>();
		countryList.add("USA");
		countryList.add("CHINA");
		countryList.add("F");
		countryList.add("Japan");
		
		return countryList;
	}
} 
