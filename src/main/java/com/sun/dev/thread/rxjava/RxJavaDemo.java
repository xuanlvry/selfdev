package com.sun.dev.thread.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by sunchengfei on 2017/9/5.
 */
public class RxJavaDemo {
    public static void main(String[] args){
        //观察者
        Observer<String> observer = new Observer<String>() {
            public void onSubscribe(Disposable disposable) {
                System.out.println("观察者：订阅成功");
            }

            public void onNext(String s) {
                System.out.println("观察者：onNext-" + s);
            }

            public void onError(Throwable throwable) {
                System.out.println("观察者：异常");
            }

            public void onComplete() {
                System.out.println("观察者：操作结束");
            }
        };


        //被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("adfasdfasdf");
                observableEmitter.onComplete();
            }
        });

        observable.subscribe(observer);

    }
}
