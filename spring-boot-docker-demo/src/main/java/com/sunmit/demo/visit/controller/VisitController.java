package com.sunmit.demo.visit.controller;

import com.sunmit.demo.visit.constants.Constant;
import com.sunmit.demo.visit.constants.ResponseConstant;
import com.sunmit.demo.visit.controller.base.BaseController;
import com.sunmit.demo.visit.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/web")
public class VisitController extends BaseController {

    @Autowired
    private VisitService visitService;

    @RequestMapping(value = "/visit",method = RequestMethod.GET)
    public ResponseEntity<ModelMap> visit(){
        ModelMap modelMap = new ModelMap();
        Map data;
        data = new HashMap();
        Long num = visitService.visitAdd();
        data.put("visit",num);
        modelMap.put(ResponseConstant.STATUS, Constant.SUCCESS_STATUS);
        modelMap.put(ResponseConstant.MESSAGE, "visit success");
        return this.setSuccessModelMap(modelMap, data);
    }
}
