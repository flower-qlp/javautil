package com.happy.javautil.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class DateUtil {

    @Autowired
    private PropertyUtil propertyUtil;


}
