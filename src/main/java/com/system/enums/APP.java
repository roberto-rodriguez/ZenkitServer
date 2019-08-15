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
package com.system.enums;
 
public enum APP{ 
    AMS("ams");
 
    private String name;

    private APP(String name) { 
        this.name = name;
    }
 
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

   
}
