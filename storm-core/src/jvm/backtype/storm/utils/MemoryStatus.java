/*
 * Copyright 2014 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package backtype.storm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Zhu Hanfeng <me@mlnotes.com>
 * @date 2014-4-26 8:58:41
 */
public class MemoryStatus {
    public static Logger LOG = LoggerFactory.getLogger(MemoryStatus.class);
    
	private Long total;
    private Long used;

    public Long getTotal() {
       	LOG.info(this.toString()); 
		return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getUsed() {
        return used;
    }

    public void setUsed(Long used) {
        this.used = used;
    }
    
    @Override
    public String toString(){
        return String.format("Memory Status: %d total, %d used", total, used);
    }
}
