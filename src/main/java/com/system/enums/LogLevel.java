/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.enums;
 
/**
 *
 * @author roberto.rodriguez
 */
public enum LogLevel {
    NONE(0),
    ERROR(1),
    INFO(2),
    DEBUG(3);

    private LogLevel(Integer code) {
        this.code = code;
    }

    private Integer code;
 
    public Integer get() {
        return code;
    }

}
