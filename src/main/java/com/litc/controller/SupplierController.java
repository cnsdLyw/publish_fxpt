package com.litc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.litc.security.model.Supplier;

/**
 * 
 * @author LITC Liyw 2018-3-30
 */

@Controller
@RequestMapping(value = "/supplier")
public class SupplierController extends BaseController<Supplier> {
	@RequestMapping(value = "/list")
	public ModelAndView index() {
		return new ModelAndView("supplier/supplier-list");
	}
}
