/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.util;

import com.amazonaws.util.EC2MetadataUtils;
import com.amazonaws.util.EC2MetadataUtils.InstanceInfo;
import com.system.dto.request.Hash;
import com.system.util.Logger;

/**
 *
 * @author roberto.rodriguez
 */
public class InstanceUtil {

    private String localInstanceName;
    private String INSTANCE;

    public InstanceUtil(String localInstanceName) {
        this.localInstanceName = localInstanceName;
    }

    public String getInstanceId() {
        if (INSTANCE == null) {
            try {
                INSTANCE = EC2MetadataUtils.getInstanceId();
            } catch (Exception e) {
            }

            if (INSTANCE == null) {
                INSTANCE = localInstanceName;
            }
        }
        return INSTANCE;
    }

    public Hash getWorkerInfo() {
        Hash hash = new Hash();
        String instanceId = getInstanceId();
        hash.put("instanceId", instanceId);
         
        try {
            if (!instanceId.equals("local.dev")) {
                InstanceInfo instanceInfo = EC2MetadataUtils.getInstanceInfo();

                if (instanceInfo != null) {
                    hash.put("accountId", instanceInfo.getAccountId());

                }
            }
        } catch (Exception e) {
            Logger.exception(e);
        }
        return hash;
    }
}
