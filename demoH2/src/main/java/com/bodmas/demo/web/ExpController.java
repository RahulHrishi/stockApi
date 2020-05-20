package com.bodmas.demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bodmas.demo.exception.RecordNotFoundException;
import com.bodmas.demo.model.ExpEntity;
import com.bodmas.demo.service.ExpService;

@Controller
public class ExpController {
	 //added by RahulS
	 @Autowired
	 ExpService service;

	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public ModelAndView displayLogin(Model model) { 
	    model.addAttribute("emp", new ExpEntity());
	    List<ExpEntity> list=new ArrayList<ExpEntity>();  
	    list=service.getAll();
	    return new ModelAndView("addExp","list",list); 
	}
	
	 @RequestMapping(value = "/", method = RequestMethod.POST)
	    public ModelAndView  processAdd(@Valid ExpEntity emp, BindingResult bindingResult) throws RecordNotFoundException {
		 service.createOrUpdate(emp);
		 return new ModelAndView("redirect:/");//will redirect to viewemp request mapping  
	 }
	 
	 @RequestMapping(value = "/calculate", method = RequestMethod.GET)
	    public ModelAndView  calculate(@Valid ExpEntity emp, BindingResult bindingResult) throws RecordNotFoundException {
		  List<ExpEntity> list=new ArrayList<ExpEntity>();  
		  list = service.getAll();
		  list.parallelStream().forEach(service::bodmasEval); // stream to use multiple processor
		 return new ModelAndView("redirect:/");
	 }
	 
	 @RequestMapping(value = "/calculate2", method = RequestMethod.GET)
	    public ModelAndView  calculate2(@Valid ExpEntity emp, BindingResult bindingResult) throws RecordNotFoundException {
		  List<ExpEntity> list=new ArrayList<ExpEntity>();  
		  list = service.getAll();
		  list.parallelStream().forEach(service::bodmasEvalByManual); // stream to use multiple processor
		 return new ModelAndView("redirect:/");
	 }
	

	
}