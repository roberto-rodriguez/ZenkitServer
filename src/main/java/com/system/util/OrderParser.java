/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.util;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author roberto.rodriguez
 */
public class OrderParser {

    public static List<Order> parseOrders(String ordersStr) {
        System.out.println("OrderParser:: ordersStr = " + ordersStr);
        if (ordersStr == null || ordersStr.isEmpty()) {
            return null;
        }

        List<Order> list = new ArrayList<Order>();

        String[] orders = ordersStr.split("@o@");

        for (String orderStr : orders) {
            System.out.println("OrderParser:: parsing orderStr = " + orderStr);
            String[] parts = orderStr.split(":");
            String o = parts[0];
            String prop = parts[1];

            System.out.println("OrderParser:: o = " + o + ", prop = " + prop);

            Order order;

            if (o.equals("ASC")) {
                order = Order.asc(prop);
            } else {
                order = Order.desc(prop);
            }
            list.add(order);
        }

        return list;
    }
}
