package com.example.myergedd.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

public class SharedPreferencesUtils {
    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型不同而调用不同的方法
     *
     * @param context
     * @param key
     * @param object
     */
    public static void put(Context context, String name, String key, Object object) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (object instanceof String) {
            edit.putString(key, (String) object);
        } else if (object instanceof Integer) {
            edit.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            edit.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            edit.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            edit.putLong(key, (Long) object);
        } else {
            edit.putString(key, object.toString());
        }
        SharedPreferencesCompat.apply(edit);
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据类型，然后调用相对应的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     */
    public static Object get(Context context, String name, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        }
        return null;
    }

    /**
     * 移除某个key值对应的值
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String name, String key) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit().remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     *
     * @param context
     */
    public static void clear(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit().clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 查询某个key是否存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String name, String key) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context, String name) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE).getAll();
    }

    /**
     * 创建一个兼容apply()方法的兼容类
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 通过反射查找apply()方法
         *
         * @return
         */
        private static Method findApplyMethod() {
            try {
                Class<SharedPreferences.Editor> aClass = SharedPreferences.Editor.class;
                return aClass.getMethod("apply");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            editor.commit();
        }
    }
}
