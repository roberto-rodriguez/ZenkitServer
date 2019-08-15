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

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Hash extends LinkedHashMap<String, Object> {

    public Hash() {
    }

    public Hash(Object... values) {
        if (values.length % 2 != 0) {
            throw new IllegalArgumentException("Expected pairs of key -> value. -> " + values.length);
        }
        for (int i = 0; i < values.length; i += 2) {
            put(values[i].toString(), values[i + 1]);
        }
    }

    public Hash(Map map) {
        this.putAll(map);
    }

    public Hash getHash(String name) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) get(name);

        return new Hash(map);
    }

//    public List<Hash> getHashList(String name) {
//        List<LinkedHashMap<String, Object>> mapList = (List<LinkedHashMap<String, Object>>) get(name);
//
//        List<Hash> result = new ArrayList<Hash>();
//        if (mapList != null) {
//            result = mapList.stream().map(m -> new Hash(m)).collect(Collectors.toList());
//        }
//        return result; 
//    } 
    public HashList getHashList(String name) {
        Object obj = get(name);
        HashList hashList = new HashList();

        if (obj instanceof HashList) {
            hashList = (HashList) obj;
        } else {
            if (obj instanceof List) {
                List<java.util.Map<String, Object>> mapList = (List<java.util.Map<String, Object>>) obj;

                if (mapList != null) {
                    for (Map<String, Object> map : mapList) {
                        hashList.add(new Hash(map));
                    }
                    put(name, hashList);
                }
            }
        }

        return hashList;
    }

    public Integer getId() {
        return getInt("id");
    }

    public Integer getInteger(String name) {
        return getInt(name);
    }

    public Integer getInt(String name) {
        Object obj = get(name);
        if (obj == null) {
            return null;
        }

        if (obj instanceof Integer) {
            return (Integer) obj;
        } else {
            try {
                return Integer.parseInt(obj.toString());
            } catch (Exception e) {
                System.out.println("Hash Error: Failed to convert " + obj + " to Integer");
                return null;
            }
        }
    }

    public Long getLong(String name) {
        Object obj = get(name);
        if (obj == null) {
            return null;
        }

        if (obj instanceof Long) {
            return (Long) obj;
        } else {
            try {
                return Long.parseLong(obj.toString());
            } catch (Exception e) {
                System.out.println("Hash Error: Failed to convert " + obj + " to Long");
                return null;
            }
        }
    }

    public Date getDate(String name) {
        Object obj = get(name);
        if (obj == null) {
            return null;
        }

        if (obj instanceof Date) {
            return (Date) obj;
        } else {
            System.out.println("Hash Error: Failed to convert " + obj + " to Date");
            return null;
        }
    }

    public Double getDouble(String name) {
        Object obj = get(name);
        if (obj == null) {
            return null;
        }

        if (obj instanceof Double) {
            return (Double) obj;
        } else {
            try {
                return Double.parseDouble(obj.toString());
            } catch (Exception e) {
                System.out.println("Hash Error: Failed to convert " + obj + " to Double..");
                return null;
            }
        }
    }

    public String getString(String prop) {
        Object obj = get(prop);

        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public Boolean getBoolean(String name) {
        Object obj = get(name);
        if (obj == null) {
            return null;
        }

        if (obj instanceof Boolean) {
            return (Boolean) obj;
        } else {
            try {
                return Boolean.parseBoolean(obj.toString());
            } catch (Exception e) {
                System.out.println("Error: Failed to convert " + obj + " to Boolean");
                return null;
            }
        }
    }

    public Integer getInt(String prop, Integer defaultValue) {
        if (containsKey(prop)) {
            return getInt(prop);
        }
        return defaultValue;
    }

    public String getString(String prop, String defaultValue) {
        if (containsKey(prop)) {
            return getString(prop);
        }
        return defaultValue;
    }

    public Boolean getBoolean(String prop, Boolean defaultValue) {
        if (containsKey(prop)) {
            return getBoolean(prop);
        }
        return defaultValue;
    }

}
