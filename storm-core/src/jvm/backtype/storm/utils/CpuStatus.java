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
 * @date 2014-4-26 11:01:00
 */
public class CpuStatus {
    public static Logger LOG = LoggerFactory.getLogger(CpuStatus.class);
    private Integer cpus;
    private Double idle;

    public Integer getCpus() {
        return cpus;
    }

    public void setCpus(Integer cpus) {
        this.cpus = cpus;
    }

    public Double getIdle() {
       	LOG.info(this.toString()); 
		return idle;
    }

    public void setIdle(Double idle) {
        this.idle = idle;
    }
    
    @Override
    public String toString(){
        return String.format("CPU Status: %d cpus, %f idle", cpus, idle);
    }
}
