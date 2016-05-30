package com.zaxcler.test.modle;

import java.util.List;

/**
 * Created by zaxcler on 2016/4/18.
 */
public class CreditListModle {
    private String time;

    List<CreditModle.DataBean> dataBeans;

    public List<CreditModle.DataBean> getDataBeans() {
        return dataBeans;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDataBeans(List<CreditModle.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    @Override
    public String toString() {
        return "CreditListModle{" +
                "time='" + time + '\'' +
                ", dataBeans=" + dataBeans +
                '}';
    }
}
