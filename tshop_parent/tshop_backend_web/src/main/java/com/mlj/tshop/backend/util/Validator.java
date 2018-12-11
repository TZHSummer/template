package com.mlj.tshop.backend.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2018/12/10：
 *
 * @author mlj
 */
public class Validator {
    /**
     * validate验证方法
     *
     * @param obj         要验证的bean
     * @param errorResult 验证错误map
     * @return 没有错误时返回null
     */
    public static Map<String, String> validate(Object obj, BindingResult errorResult) {
        Map<String, String> errorMap = null;
        if (errorResult.hasErrors()) {
            errorMap = new HashMap<>();
            List<FieldError> errorList = errorResult.getFieldErrors();
            for (FieldError fieldError : errorList) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        return errorMap;
    }
}
