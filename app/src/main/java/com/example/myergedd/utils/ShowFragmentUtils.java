package com.example.myergedd.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

public class ShowFragmentUtils {
    public static void addFragment(FragmentManager manager, Class<? extends Fragment> tClass, int layout) {
        addFragment(manager, tClass, layout, null, false);
    }

    public static void addFragment(FragmentManager manager, Class<? extends Fragment> tClass, int layout, boolean isNeedToBackStack) {
        addFragment(manager, tClass, layout, null, isNeedToBackStack);
    }

    public static void addFragment(FragmentManager manager, Class<? extends Fragment> tClass, int layout, Bundle bundle) {
        addFragment(manager, tClass, layout, bundle, false);
    }

    public static void addFragment(FragmentManager manager, Class<? extends Fragment> tClass, int layoutId, Bundle bundle, boolean isNeedToBackStack) {
        //开启事务
        FragmentTransaction transaction = manager.beginTransaction();
        //获取当前全名称
        String name = tClass.getName();
        Fragment fragment = manager.findFragmentByTag(name);
        if (fragment == null) {
            try {
                fragment = tClass.newInstance();
                transaction.add(layoutId, fragment, name);//添加fragment
                fragment.setArguments(bundle);//传出消息
                hideOtherFragment(manager, transaction, fragment);//隐藏其他fragment
                if (isNeedToBackStack) {//是否需要添加回退栈
                    transaction.addToBackStack(name);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } else {
            if (fragment.isAdded()) {
                if (fragment.isHidden()) {
                    fragment.setArguments(bundle);//传出消息
                    transaction.show(fragment);//添加fragment
                    hideOtherFragment(manager, transaction, fragment);//隐藏其他fragment
                } else {
                    fragment.setArguments(bundle);//传出消息
                    transaction.add(layoutId, fragment, name);//添加fragment
                    hideOtherFragment(manager, transaction, fragment);//隐藏其他fragment
                }
            }
        }
        transaction.commit();//提交事务，只能提交一次
    }

    private static void hideOtherFragment(FragmentManager manager, FragmentTransaction transaction, Fragment willShowFragment) {
        List<Fragment> fragments = manager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != willShowFragment && !fragment.isHidden()) {
                transaction.hide(fragment);
            }
        }
    }
}
