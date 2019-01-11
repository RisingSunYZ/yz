package com.yz.config;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttribute =  super.getErrorAttributes(requestAttributes, includeStackTrace);
        errorAttribute.put("autor","yangzhao");
        errorAttribute.put("res",requestAttributes.getAttribute("res",0));
        return errorAttribute;
    }
}
