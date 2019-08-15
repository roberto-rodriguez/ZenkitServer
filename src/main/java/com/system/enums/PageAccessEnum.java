/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.enums;

/**
 *
 * @author Alejo
 */
public enum PageAccessEnum {

    ROLES("region", "Region"),
    PAGES("country", "Country"),
    USERS("city", "City"),
    DASHBOARD("flight", "Flight"),
    PAYMENTS("fare", "Fare");

    private String idPage;
    private String name;

    private PageAccessEnum(String idPage, String name) {
        this.idPage = idPage;
        this.name = name;

    }

    /**
     * @return the idPage
     */
    public String getIdPage() {
        return idPage;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
