package com.happy.javautil.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author happy
 */
@Component
public class PropertyUtil {

    @Value("${content.extract}")
    private String contentExtract;

    public String getContentExtract() {
        return contentExtract;
    }

    public void setContentExtract(String contentExtract) {
        this.contentExtract = contentExtract;
    }
}