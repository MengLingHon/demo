package com.zr.demo.contributor;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ProjectInfoContributor implements InfoContributor {

    @Override
    public void contribute(Builder builder) {
        builder.withDetail("company.name", "study") ;
        builder.withDetail("version", "V1.0") ;
        builder.withDetail("author", "sss") ;
    }

}