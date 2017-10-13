package com.osp.log.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osp.common.json.JsonUtil;
import com.osp.log.model.Page;
import com.osp.log.model.SqlModel;
import com.osp.log.service.SqlService;

import net.sf.json.JSONObject;

/**
 * sql日志分析控制类
 * @author zhangmingcheng
 */
@Controller
public class EsSqlController {
	@Autowired
	SqlService sqlService;
	
	/**
	 * 获取当前页sql日志
	 * @param request
	 * @param index
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getSqlLogs")
	public String getSqlLogs(HttpServletRequest request,
			@RequestParam(value = "index", defaultValue = "") String index,
			@RequestParam(value = "type", defaultValue = "") String type) {
		System.out.println("getSqlLogs index=" + index +" type="+type);
		Page page = new Page();
		page.setDraw(Integer.parseInt(request.getParameter("draw").toString()));
		page.setStart(Integer.parseInt(request.getParameter("start").toString()));
		page.setLength(Integer.parseInt(request.getParameter("length").toString()));

		List<SqlModel> list = sqlService.getSqlLogs(page, index,type);
		String json = JsonUtil.beanListToJson(list);
		JSONObject jso = new JSONObject();
		jso.put("draw", page.getDraw());
		jso.put("recordsTotal", page.getRecordsTotal());
		jso.put("recordsFiltered", page.getRecordsFiltered());
		jso.put("data", json);
		return jso.toString();
	}
	
	/**
	 * 获取当前页错误sql日志
	 * @param request
	 * @param index
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getSqlErrLogs")
	public String getSqlErrLogs(HttpServletRequest request,
			@RequestParam(value = "index", defaultValue = "") String index,
			@RequestParam(value = "type", defaultValue = "") String type) {
		System.out.println("getSqlErrLogs index=" + index +" type="+type);
		Page page = new Page();
		page.setDraw(Integer.parseInt(request.getParameter("draw").toString()));
		page.setStart(Integer.parseInt(request.getParameter("start").toString()));
		page.setLength(Integer.parseInt(request.getParameter("length").toString()));

		List<SqlModel> list = sqlService.getSqlLogs(page, index,type);
		String json = JsonUtil.beanListToJson(list);
		JSONObject jso = new JSONObject();
		jso.put("draw", page.getDraw());
		jso.put("recordsTotal", page.getRecordsTotal());
		jso.put("recordsFiltered", page.getRecordsFiltered());
		jso.put("data", json);
		return jso.toString();
	}
}
