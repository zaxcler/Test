package com.zaxcler.test.modle;

import java.util.List;

/**
 * Created by zaxcler on 2016/4/18.
 */
public class CreditModle {

    /**
     * state : 0
     * message : 获取成功
     * data : [{"userid":"12","phone":"","address":"","id":"12521","credit":"1","title":"阅读新闻","addtime":"2016-04-18","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12520","credit":"1","title":"阅读新闻","addtime":"2016-04-18","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12519","credit":"1","title":"阅读新闻","addtime":"2016-04-18","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12518","credit":"1","title":"阅读新闻","addtime":"2016-04-18","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12517","credit":"1","title":"阅读新闻","addtime":"2016-04-18","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12515","credit":"5","title":"每日登录","addtime":"2016-04-18","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12484","credit":"1","title":"阅读新闻","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12482","credit":"3","title":"分享新闻","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12481","credit":"1","title":"阅读新闻","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12480","credit":"3","title":"分享新闻","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12479","credit":"1","title":"阅读新闻","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12472","credit":"1","title":"阅读新闻","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12470","credit":"1","title":"阅读新闻","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12464","credit":"3","title":"分享新闻","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12463","credit":"1","title":"阅读新闻","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12456","credit":"5","title":"每日登录","addtime":"2016-04-17","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12448","credit":"1","title":"阅读新闻","addtime":"2016-04-16","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12447","credit":"5","title":"每日登录","addtime":"2016-04-16","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12290","credit":"5","title":"每日登录","addtime":"2016-04-15","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12191","credit":"2","title":"分享被阅读送积分","addtime":"2016-04-14","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12176","credit":"10","title":"微信转入积分","addtime":"2016-04-14","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"12174","credit":"5","title":"每日登录","addtime":"2016-04-14","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"11534","credit":"3","title":"分享新闻","addtime":"2016-04-13","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"11533","credit":"1","title":"阅读新闻","addtime":"2016-04-13","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"11511","credit":"3","title":"分享新闻","addtime":"2016-04-13","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"11497","credit":"5","title":"每日登录","addtime":"2016-04-13","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"11325","credit":"1","title":"阅读新闻","addtime":"2016-04-13","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"10931","credit":"1","title":"阅读新闻","addtime":"2016-04-13","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"10918","credit":"1","title":"阅读新闻","addtime":"2016-04-13","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"10880","credit":"1","title":"阅读新闻","addtime":"2016-04-13","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"10879","credit":"5","title":"每日登录","addtime":"2016-04-13","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"8786","credit":"5","title":"每日登录","addtime":"2016-04-12","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"5415","credit":"1","title":"阅读新闻","addtime":"2016-04-11","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"5414","credit":"1","title":"阅读新闻","addtime":"2016-04-11","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"5413","credit":"5","title":"每日登录","addtime":"2016-04-11","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"2121","credit":"1","title":"阅读新闻","addtime":"2016-04-10","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"2052","credit":"5","title":"每日登录","addtime":"2016-04-10","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"1993","credit":"1","title":"阅读新闻","addtime":"2016-04-09","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"1480","credit":"1","title":"阅读新闻","addtime":"2016-04-09","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"1402","credit":"1","title":"阅读新闻","addtime":"2016-04-09","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"1401","credit":"1","title":"阅读新闻","addtime":"2016-04-09","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"1400","credit":"1","title":"阅读新闻","addtime":"2016-04-09","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"1398","credit":"1","title":"阅读新闻","addtime":"2016-04-09","status":"0","deliverytime":"0","type":"1","fullname":""},{"userid":"12","phone":"","address":"","id":"1373","credit":"1","title":"阅读新闻","addtime":"2016-04-09","status":"0","deliverytime":"0","type":"1","fullname":""}]
     */

    private int state;
    private String message;
    /**
     * userid : 12
     * phone :
     * address :
     * id : 12521
     * credit : 1
     * title : 阅读新闻
     * addtime : 2016-04-18
     * status : 0
     * deliverytime : 0
     * type : 1
     * fullname :
     */

    private List<DataBean> data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String userid;
        private String phone;
        private String address;
        private int id;
        private int credit;
        private String title;
        private String addtime;
        private String status;
        private String deliverytime;
        private String type;
        private String fullname;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDeliverytime() {
            return deliverytime;
        }

        public void setDeliverytime(String deliverytime) {
            this.deliverytime = deliverytime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "userid='" + userid + '\'' +
                    ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' +
                    ", id=" + id +
                    ", credit=" + credit +
                    ", title='" + title + '\'' +
                    ", addtime='" + addtime + '\'' +
                    ", status='" + status + '\'' +
                    ", deliverytime='" + deliverytime + '\'' +
                    ", type='" + type + '\'' +
                    ", fullname='" + fullname + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CreditModle{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
