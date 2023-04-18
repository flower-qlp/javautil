package com.happy.javautil.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author happy
 */
@Component
@RefreshScope
public class PropertyUtil {

    @Value("${content.extract}")
    private String contentExtract;
    
    @Value("${example.name}")
    private String exampleName;
    
    public String getExampleName() {
        return exampleName;
    }
    
    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }
    
    public String getContentExtract() {
        return contentExtract;
    }

    public void setContentExtract(String contentExtract) {
        this.contentExtract = contentExtract;
    }
}