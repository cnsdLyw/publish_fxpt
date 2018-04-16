package com.litc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.litc.security.model.Supplier;
import com.litc.security.model.User;
import com.litc.service.SupplierService;

/**
 * 
 * @author LITC Liyw 2018-3-30
 */

@Controller
@RequestMapping(value = "/supplier")
public class SupplierController extends BaseController<Supplier> {
	
	private final static Logger logger = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private SupplierService supplierService;
	
	/**
	 * 每页数量
	 */
	private static final int PAGEPERSIZE = 10;
	
	/**
	 * 加工任务排序字段
	 */
	private static String ORDER_TYPE = "id";
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request,String orderType,String sortType, String keyWord) {
		ModelAndView modelAndView = new ModelAndView("supplier/supplier-list");
		pageNo = this.getInt(request, "pageNo");
		//扩展根据表头字段排序
		Direction sortDirection = null;
		if(StringUtils.isNotBlank(sortType)){
			if("asc".equals(sortType.toLowerCase())){
				sortDirection = SORT_TYPE_ASC ;
			}else if("desc".equals(sortType.toLowerCase())){
				sortDirection = SORT_TYPE_DESC ;
			}
			
		}else{
			sortDirection = SORT_TYPE_DESC;
		}
		
		if(!StringUtils.isNotBlank(orderType)){
			orderType = ORDER_TYPE;
		}
		
		modelAndView.addObject("orderType",orderType);
		modelAndView.addObject("sortType",sortType);
		
		page = supplierService.getSuppliersByPages(pageNo, PAGEPERSIZE,sortDirection,orderType,keyWord);
		modelAndView.addObject("keyWord",keyWord);
		modelAndView.addObject("pageContent",page);
		return modelAndView;
	}
	
	@RequestMapping(value="/getJsonSupplier", method=RequestMethod.GET)
	@ResponseBody
	public Supplier getJsonSupplier(Long id){
		logger.info("查询用户  getJsonSupplierr "+id);
		Supplier supplier = supplierService.getSupplier(id);
		return supplier;
	}
}
