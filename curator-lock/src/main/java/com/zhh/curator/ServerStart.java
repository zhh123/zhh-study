package com.zhh.curator;


import com.handmobi.core.rpc.api.IZookeeprService;
import com.handmobi.core.zookeeper.api.IZookeeperClient;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author:zhh
 * @Date:Created in 16:46 2019/7/31 0031
 */
@Component
public class ServerStart implements ApplicationRunner {
    @Autowired
    IZookeeprService iZookeeprService;

    @Autowired
    IZookeeperClient iZookeeperClient;

    public ConcurrentHashMap<String, InterProcessMutex> m_lock_objects = new ConcurrentHashMap<>();

    public CuratorFramework client;

    int count = 10;

    //InterProcessMutex lockObject = null;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final CountDownLatch countdown = new CountDownLatch(1);
        //final InterProcessMutex lockObject = new InterProcessMutex(iZookeeperClient.getClient(),"/testLock");
       /* if(client == null){
            createClient();
        }
        lockObject =   new InterProcessMutex(client,"/testLock");*/

        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countdown.await();
                        //-------------业务处理开始
                        boolean lockResult = iZookeeprService.acquireLock("testLock",5, TimeUnit.SECONDS);

                        //boolean lockResult = acquireLock("/testLock",5,TimeUnit.SECONDS);
                        System.out.println("lockResult: "+lockResult);
                        genarNo();
                        //-------------业务处理结束
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        //releaseLock("/testLock");
                        iZookeeprService.releaseLock("testLock");
                       /* try {
                            lockObject.release();
                        }catch (Exception e){
                            e.printStackTrace();
                        }*/
                    }
                }
            },"t" + i).start();
        }
        Thread.sleep(100);
        countdown.countDown();

    }

    public  boolean acquireLock(String vPath, long time, TimeUnit unit) {
        long start = System.currentTimeMillis();
        /*if(lockObject == null){
            if(client == null){
                createClient();
            }
            lockObject = new InterProcessMutex(client,"/testLock");
            System.out.println("创建锁对象");
        }*/
        //lockObject = new InterProcessMutex(client,"/testLock");
        InterProcessMutex lockObject = m_lock_objects.get(vPath);
        if(lockObject == null){
            System.out.println("创建锁对象");

            lockObject = new InterProcessMutex(client,"/testLock");
            if(lockObject != null) {
                m_lock_objects.put(vPath, lockObject);
            }
        }
        if(lockObject == null){
            return false;
        }
        boolean result = false;
        try {
            result = lockObject.acquire(time, unit);
        }catch (Exception e){

            e.printStackTrace();
        }
        System.out.println("lock times: "+(System.currentTimeMillis()-start));
        return result;
    }

    public void releaseLock(String vPath) {
        InterProcessMutex lockObject = m_lock_objects.get(vPath);
        if(lockObject == null){
            return ;
        }
        try {
            System.out.println("该对象是否拥有锁: "+lockObject.isOwnedByCurrentThread());
            lockObject.release();
            System.out.println("释放锁... ");
        }catch (Exception e){

            e.printStackTrace();
        }

    }

    public void createClient(){
        RetryPolicy retryPolicy = new RetryNTimes(5, 11000);
        CuratorFramework tClient = CuratorFrameworkFactory.builder()
                .connectionTimeoutMs(5000)
                .sessionTimeoutMs(5000)
                .connectString("192.168.1.241:2181,192.168.1.241:2182,192.168.1.241:2183")
                .retryPolicy(retryPolicy).build();
        tClient.start();
        client = tClient;
    }

    public void genarNo(){
        try{
            count --;
            System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}