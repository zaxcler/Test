package com.zaxcler.test.modle;

import java.util.List;

/**
 * Created by zaxcler on 2016/4/13.
 */
public class Model1 {


    /**
     * id : 98183
     * title : 鍐欐儏涔︾粰浣忛櫌濡诲瓙锛氫綘涓€鑴哥瑧鍊煎崈閲�
     * titleurl : /hot/2016-04-13/98183.html
     * video : 2
     * titletype : 鏃�
     * titlepic : /d/file/hot/2016-04-13/7ef42a320d58d3cd057bea6106352f1b.jpg
     */

    private List<NewslistBean> newslist;

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String id;
        private String title;
        private String titleurl;
        private String video;
        private String titletype;
        private String titlepic;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleurl() {
            return titleurl;
        }

        public void setTitleurl(String titleurl) {
            this.titleurl = titleurl;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getTitletype() {
            return titletype;
        }

        public void setTitletype(String titletype) {
            this.titletype = titletype;
        }

        public String getTitlepic() {
            return titlepic;
        }

        public void setTitlepic(String titlepic) {
            this.titlepic = titlepic;
        }
    }
}
