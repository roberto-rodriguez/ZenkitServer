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
package com.system.dto.request;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

public class ListRequestDTO {

    private Integer page;
    private Integer start;
    private Integer limit = 0;
    private String report = "";
    
    private boolean includeCount = true;

    private List<Criterion> expressions = new ArrayList<>();
    private List<Order> orders;

    public ListRequestDTO() {
    }

    public ListRequestDTO(Integer page, Integer start, Integer limit, String report, List<Criterion> expressions) {
        this.page = page;
        this.start = start;
        this.limit = limit;
        this.report = report;
        this.expressions = expressions;
    }

    public ListRequestDTO(Integer page, Integer start, Integer limit, String report, List<Criterion> expressions, List<Order> orders) {
        this(page, start, limit, report, expressions);
        this.orders = orders;
    }

    public void addExpression(Criterion expression) {
        expressions.add(expression);
    }

    /**
     * @return the page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return the start
     */
    public Integer getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * @return the expressions
     */
    public List<Criterion> getExpressions() {
        return expressions;
    }

    /**
     * @param expressions the expressions to set
     */
    public void setExpressions(List<Criterion> expressions) {
        this.expressions = expressions;
    }

    /**
     * @return the report
     */
    public String getReport() {
        return report;
    }

    /**
     * @param report the report to set
     */
    public void setReport(String report) {
        this.report = report;
    }

    public List<Order> getOrders() {
        return orders;
    }
 
    /**
     * @return the includeCount
     */
    public boolean includeCount() {
        return includeCount;
    }

    /**
     * @param includeCount the includeCount to set
     */
    public void setIncludeCount(boolean includeCount) {
        this.includeCount = includeCount;
    }

}
