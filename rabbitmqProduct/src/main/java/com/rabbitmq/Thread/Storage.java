package com.rabbitmq.Thread;

import java.util.LinkedList;

/**
 * @author yakungao
 * @date 2018/2/7
 **/
public class Storage {

    private final int maxCount = 100;
    private LinkedList<Object> list = new LinkedList<Object>();

    public void produce(int num) {
        synchronized (list) {
            //当前仓库中数目大于设置的最大值，此线程等待
            if (list.size() + num > maxCount) {
                System.out.println("【要生产的产品数量】:" + num + "【库存量】:"
                    + list.size() + "暂时不能执行生产任务!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }

            System.out.println("【已经生产产品数】:" + num + "【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }

    public void consume(int num) {
        synchronized (list) {
            //当前仓库数量小于需要消费的数量
            if (list.size() < num) {
                System.out.println("【要消费的产品数量】:" + num + "【库存量】:"
                    + list.size() + "暂时不能执行生产任务!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                list.remove();
            }

            System.out.println("【已经消费产品数】:" + num + "【现仓储量为】:" + list.size());
            list.notifyAll();
        }
    }

}
