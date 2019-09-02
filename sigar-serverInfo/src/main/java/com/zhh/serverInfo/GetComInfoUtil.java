package com.zhh.serverInfo;

import org.hyperic.sigar.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @Author:zhh
 * @Date:Created in 10:12 2019/6/3 0003
 */
@Component
public class GetComInfoUtil {
    NumberFormat nf = NumberFormat.getNumberInstance();

    public void memory(){
        try {
            Sigar sigar = new Sigar();
            Mem mem = sigar.getMem();
            // 内存总量
            System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
            // 当前内存使用量
            System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
            // 当前内存剩余量
            System.out.println("当前内存剩余量:    " + mem.getFree() /  (1024L*1024L) + "K free");
            Swap swap = sigar.getSwap();
            // 交换区总量
            System.out.println("交换区总量:    " + swap.getTotal() / 1024L + "K av");
            // 当前交换区使用量
            System.out.println("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
            // 当前交换区剩余量
            System.out.println("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getCpu(){
        try{
            Sigar sigar = new Sigar();
            CpuInfo infos[] = sigar.getCpuInfoList();
            CpuPerc cpuList[] = null;
            cpuList = sigar.getCpuPercList();
            for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
                CpuInfo info = infos[i];
                System.out.println("第" + (i + 1) + "块CPU信息");
                System.out.println("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
                System.out.println("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
                System.out.println("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
                System.out.println("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量
                printCpuPerc(cpuList[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void printCpuPerc(CpuPerc cpu) {
        System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
        System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
        System.out.println("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
        System.out.println("CPU当前错误率:    " + CpuPerc.format(cpu.getNice()));//
        System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
        System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
    }

    public void getPerCpuInfo(){
        try{
            nf.setMaximumFractionDigits(2);

            double result = 0.00;
            Sigar sigar = new Sigar();
            CpuPerc perc = sigar.getCpuPerc();
            result = new BigDecimal(perc.getIdle()).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println("整体cpu的占用情况:");
           /* System.out.println("空闲率: " + CpuPerc.format(perc.getIdle()));//获取当前cpu的空闲率
            System.out.println("占用率: "+ CpuPerc.format(perc.getCombined()));//获取当前cpu的占用率*/
            System.out.println("空闲率: " + result);//获取当前cpu的空闲率
            System.out.println("占用率: "+ perc.getCombined());//获取当前cpu的占用率
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}