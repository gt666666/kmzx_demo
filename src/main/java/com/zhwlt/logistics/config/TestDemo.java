package com.zhwlt.logistics.config;

class Message{
        private String title ;
        private String info ;
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getInfo() {
            return info;
        }
        public void setInfo(String info) {
            this.info = info;
        }
    }
    class Producer implements Runnable {
        private Message message ;
        public Producer(Message message) {
            this.message = message ;
        }
        @Override
        public void run() {
            for (int x = 0 ; x < 50 ; x ++) {
                if (x % 2 == 0) {
                    this.message.setTitle("你好");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.message.setInfo("nihao");
                } else {
                    this.message.setTitle("不好");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.message.setInfo("buhao");
                }
            }
        }
    }
    class Consumer implements Runnable {
        private Message message ;
        public Consumer(Message message) {
            this.message = message ;
        }
        @Override
        public void run() {
            for (int x = 0 ; x < 50 ; x ++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.message.getTitle() + " - " + this.message.getInfo());
            }
        }
    }
    public class TestDemo {
        public static void main(String[] args) throws Exception {
            Message message = new Message() ;
            Producer pro = new Producer(message) ;
            Consumer con = new Consumer(message) ;
            new Thread(pro).start();
            new Thread(con).start();
        }
    }