/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dev.frontEnd;

import com.system.dto.request.Hash;
import com.system.session.DevData;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 *
 * @author roberto.rodriguez
 */
@Component
public class SubPanelGenerator extends FrontEndGenerator {

    @Value("classpath:tpl/front/SubPanel.txt")
    private Resource template;

    @Override
    protected String additionalProcessing(String tpl, List<Hash> fields) throws IOException {
        return tpl.replace("%uipck%", devData.getUiPck());
    }

    @Autowired
    protected DevData devData;

    protected String getFileSuffix() {
        return "SubPanel";
    }

    protected Resource getResource() {
        return template;
    }
}
