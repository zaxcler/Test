package com.zaxcler.test.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.analytics.MobclickAgent;
import com.zaxcler.test.base.BaseActivity;
import com.zaxcler.test.utils.CountUtils;
import com.zaxcler.test.modle.CreditListModle;
import com.zaxcler.test.rxandroid.HttpRequestInterface;
import com.zaxcler.test.modle.Model1;
import com.zaxcler.test.rxandroid.OkHttp;
import com.zaxcler.test.R;
import com.zaxcler.test.zxing.CaptureActivity;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    private Retrofit retrofit;
    private HttpRequestInterface requestInterface;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       Intent intent=new Intent(this,MyService.class);
//
//         startService(intent);

    }


    public void onClick(View v){
        Intent intent=new Intent(this,ChannelManangeActivity.class);
        startActivity(intent);
    }

    private void testdata(){

        MobclickAgent.onProfileSignIn(""+Math.random()*10);
        text = (TextView) findViewById(R.id.text);
        String data = "{\"state\":0,\"message\":\"获取成功\",\"data\":[{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12521\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-18\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12520\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-18\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12519\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-18\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12518\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-18\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12517\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-18\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12515\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-18\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12484\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12482\",\"credit\":\"3\",\"title\":\"分享新闻\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12481\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12480\",\"credit\":\"3\",\"title\":\"分享新闻\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12479\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12472\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12470\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12464\",\"credit\":\"3\",\"title\":\"分享新闻\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12463\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12456\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-17\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12448\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-16\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12447\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-16\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12290\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-15\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12191\",\"credit\":\"2\",\"title\":\"分享被阅读送积分\",\"addtime\":\"2016-04-14\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12176\",\"credit\":\"10\",\"title\":\"微信转入积分\",\"addtime\":\"2016-04-14\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"12174\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-14\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"11534\",\"credit\":\"3\",\"title\":\"分享新闻\",\"addtime\":\"2016-04-13\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"11533\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-13\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"11511\",\"credit\":\"3\",\"title\":\"分享新闻\",\"addtime\":\"2016-04-13\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"11497\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-13\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"11325\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-13\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"10931\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-13\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"10918\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-13\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"10880\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-13\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"10879\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-13\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"8786\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-12\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"5415\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-11\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"5414\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-11\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"5413\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-11\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"2121\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-10\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"2052\",\"credit\":\"5\",\"title\":\"每日登录\",\"addtime\":\"2016-04-10\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"1993\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-09\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"1480\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-09\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"1402\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-09\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"1401\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-09\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"1400\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-09\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"1398\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-09\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"},{\"userid\":\"12\",\"phone\":\"\",\"address\":\"\",\"id\":\"1373\",\"credit\":\"1\",\"title\":\"阅读新闻\",\"addtime\":\"2016-04-09\",\"status\":\"0\",\"deliverytime\":\"0\",\"type\":\"1\",\"fullname\":\"\"}]}\n";

        List<CreditListModle> So= CountUtils.sortByTime(data);

        text.setText(So.toString());
        text.setMovementMethod(ScrollingMovementMethod.getInstance());
        Log.e("result",So.toString());

    }


    private void testRXandroid() {
        OkHttp okHttp = OkHttp.getInstance();
        okHttp.setCertificates();
        OkHttpClient okHttpClient = okHttp.getOkHttpClient();

        ImageView img = (ImageView) findViewById(R.id.img);
        Glide.with(this).load("http://www.0739i.com.cn/data/attachment/portal/201603/09/120155zrcvtsvaj9ptaawt.jpg").into(img);

        retrofit = new Retrofit.Builder().baseUrl("http://m.cqcb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(okHttpClient)
                .build();

        requestInterface = retrofit.create(HttpRequestInterface.class);
        requestInterface.getJSONObject("class2_firstnews.js").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Model1>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("onError", e.toString());
            }

            @Override
            public void onNext(Model1 jsonObject) {
                Log.e("onNext", jsonObject.toString());
            }
        });
    }
}
