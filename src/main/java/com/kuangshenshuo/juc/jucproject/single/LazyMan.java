package com.kuangshenshuo.juc.jucproject.single;

/**
 * @author yswu
 * @date 2021-03-10 00:25
 */
public class LazyMan {

        private LazyMan(){

        }

        private static volatile LazyMan lazyMan;

        public static LazyMan getInstance(){
            if(lazyMan == null){
                synchronized (LazyMan.class){
                    if(lazyMan == null){
                         lazyMan = new LazyMan();

                    }
                }


            }

            return lazyMan;
        }

}
