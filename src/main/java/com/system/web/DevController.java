/*
 ** File: WebResponse.java
 **
 ** Date Created: December 2016
 **
 ** Copyright @ 2016-2018 Roberto Rodriguez.
 ** Email: robertoSoftwareEngineer@gmail.com
 **
 ** All rights reserved. No part of this software may be 
 ** reproduced, transmitted, transcribed, stored in a retrieval 
 ** system, or translated into any language or computer language, 
 ** in any form or by any means, electronic, mechanical, magnetic, 
 ** optical, chemical, manual or otherwise, without the prior 
 ** written permission of Roberto Rodriguez.
 **
 */
package com.system.web;

import com.system.dev.DevExecutor;
import com.system.dto.request.Hash;
import com.system.dto.response.WebResponseData;
import com.system.session.DevData;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roberto Rodriguez
 */
@RestController
@RequestMapping(value = "/dev", method = RequestMethod.GET)
public class DevController {

    @Autowired
    protected DevExecutor devExecutor;

    @Autowired
    protected DevData devData;

    @RequestMapping(value = "/ping")
    public @ResponseBody
    String ping() throws IOException {
        return "PING";
    }

    @RequestMapping(value = "/generate", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    List<Hash> generate(@RequestBody Hash request) throws IOException {
        List<Hash> data = devExecutor.generate(request);
        devData.setData(data);        
        return data;
    }

    @RequestMapping(value = "/preview")
    public @ResponseBody
    List<Hash> preview() throws IOException {
        return devData.getData();
    }

    @RequestMapping(value = "/write")
    public @ResponseBody
    String write() throws IOException {
        devExecutor.write();
        return "done";
    }

    @RequestMapping(value = "/revert")
    public @ResponseBody
    String revert() throws IOException {
        System.out.println("DevController.revert");
        devExecutor.revert();
        return "done";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public WebResponseData updateFile(@RequestBody Hash data) {

        System.out.println("updateFile");
        devData.update(data);

        return new WebResponseData();
    }

    @RequestMapping(value = "/uifolders")
    public List<String> getUIFolders() {
        return devExecutor.getUIFolders();
    }
}
