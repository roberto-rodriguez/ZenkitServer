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
import java.util.Arrays;
import java.util.List;

public class HashList extends ArrayList<Hash> {

    public HashList() {
    }

    public HashList(List<Hash> list) {
        addAll(list);
    }

    public HashList(Hash... hashes) {
        this.addAll(Arrays.asList(hashes));
    }

}
