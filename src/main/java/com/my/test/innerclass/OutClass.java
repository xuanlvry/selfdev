package com.my.test.innerclass;

import com.my.test.IMyService;
import com.my.test.UserInfo;

/**
 * Created by sunchengfei on 2019/2/21.
 */
public class OutClass {
    private String name = "outclass";
    private Integer age = 17;

    /**
     * 外部类访问内部类属性，需要先创建内部对象
     * @return
     */
    public String mainHandle() {
        final String title = "aa";
        IMyService myService = new IMyService() {
            @Override
            public UserInfo selectUser(long id) {
                return new UserInfo(title, "");
            }

            @Override
            public UserInfo selectUser(String account) {
                return null;
            }

            @Override
            public void updateUser(UserInfo userInfo) {

            }

            @Override
            public UserInfo selectBySpringCache(String account) {
                return null;
            }
        };

        return null;
    }

    class OutClass$1 implements IMyService{
        private final OutClass this$0;
        private final String title;

        OutClass$1(OutClass this$0, String title) {
            this.this$0 = this$0;
            this.title = title;
        }

        @Override
        public UserInfo selectUser(long id) {
            return new UserInfo(this.title, "");
        }

        @Override
        public UserInfo selectUser(String account) {
            return null;
        }

        @Override
        public void updateUser(UserInfo userInfo) {

        }

        @Override
        public UserInfo selectBySpringCache(String account) {
            return null;
        }
    }
    /**
     * 1.内部类中，不能定义静态成员
     * 2.可以访问外部类的所有成员
     */
    class InClass {
        /** 隐藏现象，隐藏了外部类的name */
        String name = "hello：";

        String test() {
            return age + name;
        }
    }

    public static void main(String[] args) {
        /** 1.先创建外部类对象 */
        OutClass outClass = new OutClass();
        /** 2.根据外部类对象创建内部类对象 */
        InClass inClass = outClass.new InClass();
        /** 3.访问内部类属性or方法 */
        inClass.test();
    }
}
