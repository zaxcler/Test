package com.zaxcler.test.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zaxcler.test.modle.CreditListModle;
import com.zaxcler.test.modle.CreditModle;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaxcler on 2016/4/18.
 */
public class CountUtils {

    public static List<CreditListModle> countCredit(String object){
        List<CreditListModle> result= new ArrayList<>();


        CreditModle modle=null;
        CreditModle.DataBean dataBean=null;
        CreditModle.DataBean temp=null;

        modle=new Gson().fromJson(object,new TypeToken<CreditModle>(){}.getType());

        List<CreditModle.DataBean> beans=null;


        beans=modle.getData();

        if (modle==null){
            Log.e("modle","   modle=null");
            return null;
        }
        if (beans==null){
            Log.e("beans","   beans=null");
            return null;
        }

        for (int i=0;i<beans.size();i++){

            if (beans.get(i).getStatus().equals("0")){
                temp=beans.get(i);
            }else {
                continue;
            }
            List<CreditModle.DataBean> result_modle=new ArrayList<>();
            CreditListModle creditListModle=new CreditListModle();
            for (int j=i;j<beans.size();j++){

                if (beans.get(j).getAddtime()!=null && !"".equals(beans.get(j).getAddtime()) && beans.get(j).getTitle()!=null && !"".equals(beans.get(j).getTitle()) ){
                    dataBean=beans.get(j);

                    //如果时间标题都相同作为同一个元素相加
                    if (dataBean.getAddtime().equals(temp.getAddtime()) && dataBean.getTitle().equals(temp.getTitle())){


                        int credit=temp.getCredit()>0?temp.getCredit():0;
                        if(i!=j){
                            credit=credit+dataBean.getCredit();
                        }
                        temp.setCredit(credit);

                        beans.get(j).setStatus("1");
                    }
                    if (j==beans.size()-1){
                        result_modle.add(temp);
                        creditListModle.setTime(temp.getAddtime());
                        creditListModle.setDataBeans(result_modle);
                        result.add(creditListModle);
                    }

                }


            }
        }

        return result;

    }

    public static List<CreditListModle> sortByTime(String data){
        List<CreditListModle> listModles=countCredit(data);


        for (int i=0;i<listModles.size();i++) {

            for (int j=0;j<listModles.size();j++) {

                if (listModles.get(i).getTime().equals(listModles.get(j).getTime())){

                    if (i!=j){
                        listModles.get(i).getDataBeans().add(listModles.get(j).getDataBeans().get(0));
                        listModles.remove(listModles.get(j));
                    }

                }
            }
        }

        return listModles;

    }
}
