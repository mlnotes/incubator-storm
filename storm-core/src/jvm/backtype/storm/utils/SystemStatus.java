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

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zhu Hanfeng <me@mlnotes.com>
 * @date 2014-4-26 10:53:39
 */
public class SystemStatus {
    public static Logger LOG =  LoggerFactory.getLogger(SystemStatus.class);
    
    private static SystemStatus instance;
    public static SystemStatus getInstance(){
        if(instance == null){
            instance = new SystemStatus();
        }
        return instance;
    }
    
    private Sigar sigar = null;
    
    private SystemStatus(){
        sigar = new Sigar();
    }
    
    public MemoryStatus getMemoryStatus(){
        MemoryStatus status = new MemoryStatus();
        try {
            Mem mem = sigar.getMem();
            status.setTotal(mem.getTotal());
            status.setUsed(mem.getUsed());
        } catch (SigarException ex) {
            LOG.error("can't get memory status", ex);
        }
        LOG.info(status.toString());
        return status;
    }
    
    public CpuStatus getCpuStatus() {
        CpuStatus status = new CpuStatus();
        try {
            CpuPerc[] cpus = sigar.getCpuPercList();
            status.setCpus(cpus.length);
            double idle = 0.0;
            for(int i = 0; i < cpus.length; ++i){
                idle += cpus[i].getIdle();
            }
            status.setIdle(idle/cpus.length);
        } catch (SigarException ex) {
            LOG.error("can't get cput status", ex);
        }
        
        LOG.info(status.toString());
        return status;
    }
    
    public static void main(String[] args){
        SystemStatus ss = SystemStatus.getInstance();
        MemoryStatus mem = ss.getMemoryStatus();
        CpuStatus cpu = ss.getCpuStatus();
        
        System.out.println(mem);
        System.out.println(cpu);
    }
}
