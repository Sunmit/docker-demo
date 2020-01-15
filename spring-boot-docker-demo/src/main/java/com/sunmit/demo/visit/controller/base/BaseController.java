package com.sunmit.demo.visit.controller.base;

import com.sunmit.demo.visit.constants.Constant;
import com.sunmit.demo.visit.constants.ResponseConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

public class BaseController {
    /**
     * void 返回方法调用
     * @return
     */
    protected ResponseEntity<ModelMap> setSuccessModelMap() {
        ModelMap modelMap = new ModelMap();
        modelMap.put(ResponseConstant.STATUS, Constant.SUCCESS_STATUS);
        return setSuccessModelMap(modelMap);
    }


    /**
     * 设置成功响应代码
     */
    protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap) {
        return setSuccessModelMap(modelMap, null);
    }

    /**
     * 设置成功响应代码
     */
    protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap, Object data) {
        return setModelMap(modelMap, HttpStatus.OK, data);
    }

    /**
     * 设置响应代码
     */
    protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, HttpStatus code) {
        return setModelMap(modelMap, code, null);
    }

    /**
     * 设置响应代码
     */
    protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, HttpStatus status, Object data) {
        modelMap.remove("void");
        if (modelMap.get(ResponseConstant.DATA) == null) {
            modelMap.put(ResponseConstant.DATA, data);
        }
        if (modelMap.get(ResponseConstant.STATUS) == null) {
            modelMap.put(ResponseConstant.STATUS, status.value());
        }
        if (modelMap.get(ResponseConstant.MESSAGE) == null) {
            modelMap.put(ResponseConstant.MESSAGE, status.getReasonPhrase());
        }
        modelMap.put(ResponseConstant.TIMESTAMP, System.currentTimeMillis());
        return ResponseEntity.status(status).body(modelMap);
    }
}
