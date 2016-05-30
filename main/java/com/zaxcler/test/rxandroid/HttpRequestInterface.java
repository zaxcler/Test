package com.zaxcler.test.rxandroid;

import com.zaxcler.test.modle.Model1;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zaxcler on 2016/4/13.
 */
public interface HttpRequestInterface {

    @GET("d/js/class/{path}")
    Observable<Model1> getJSONObject(@Path("path") String path );
    @GET("http://m.cqcb.com/d/js/class/class2_firstnews.js")
    Observable<Model1> getJSONObject();

}
