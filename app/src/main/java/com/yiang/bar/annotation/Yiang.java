package com.yiang.bar.annotation;

import android.app.Activity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by WYiang on 2017/7/28.
 */

public class Yiang {
    public static void injectView(Object object, Activity activity) {

        Class clazz = object.getClass();
        if (clazz.isAnnotationPresent(InjectLayout.class)) {
            InjectLayout injectLayout = (InjectLayout) clazz.getAnnotation(InjectLayout.class);//得到注解类
            int layoutId = injectLayout.layoutId();
            Method method = null;//得到setContentView方法
            try {
                method = clazz.getMethod("setContentView", int.class);
                method.invoke(object, layoutId);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
}
