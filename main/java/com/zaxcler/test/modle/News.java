package com.zaxcler.test.modle;


/**
 * 新闻实体类
 * Created by wjz-pc on 2015/10/31.
 */
public class News  {


    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String titleurl;
    private String video;
    private String titletype;
    private String titlepic;
    private String smalltitlepic;
    private String newstime;
    private String smalltext;
    private String befrom;
    private String writer;
    private String onclick;
    private String plnum;
    private String column_id;
    private String smalltitlepic3;
    private long cid;   //畅言的ID


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

    public String getSmalltitlepic() {
        return smalltitlepic;
    }

    public void setSmalltitlepic(String smalltitlepic) {
        this.smalltitlepic = smalltitlepic;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }

    public String getSmalltext() {
        return smalltext;
    }

    public void setSmalltext(String smalltext) {
        this.smalltext = smalltext;
    }

    public String getBefrom() {
        return befrom;
    }

    public void setBefrom(String befrom) {
        this.befrom = befrom;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getOnclick() {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    public String getPlnum() {
        return plnum;
    }

    public void setPlnum(String plnum) {
        this.plnum = plnum;
    }

    public String getColumn_id() {
        return column_id;
    }

    public void setColumn_id(String column_id) {
        this.column_id = column_id;
    }

    public String getSmalltitlepic3() {
        return smalltitlepic3;
    }

    public void setSmalltitlepic3(String smalltitlepic3) {
        this.smalltitlepic3 = smalltitlepic3;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }
}
