package com.zaxcler.test.base;

import android.content.Context;
import android.util.Log;

/**
 * Created by zaxcler on 2016/4/29.
 */
public class MResource {

    public static int getIdbyName(Context context, String className, String name){

        String packagename=context.getPackageName();
        Class r=null;
        int id=0;
        try {
            r=Class.forName(packagename+".R");
            Log.e("packagename+\".R\"",packagename+".R");
            Class[] classes=r.getClasses();
            Class tempclass=null;
            for (int i=0;i<classes.length;i++){
                Log.e("classes[i].getName()",classes[i].getName().split("\\$")[1]);
                if (classes[i].getName().split("\\$")[1].equals(className)){
                    tempclass=classes[i];
                    break;
                }


            }
            if (tempclass!=null){
                id=tempclass.getField(name).getInt(tempclass);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return id;
    }
}
