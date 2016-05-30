package com.zaxcler.test.rxandroid;

/**
 * Created by zaxcler on 2016/4/13.
 */

import android.os.Handler;
import android.os.Looper;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;

/**
 * Created by zhy on 15/8/17.
 */
public class OkHttp
{

    public static final long DEFAULT_MILLISECONDS = 10000;
    private static OkHttp mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;

    public OkHttp(OkHttpClient okHttpClient)
    {
        if (okHttpClient == null)
        {
            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
            //cookie enabled
//            okHttpClientBuilder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));
            okHttpClientBuilder.hostnameVerifier(new HostnameVerifier()
            {
                @Override
                public boolean verify(String hostname, SSLSession session)
                {
                    return true;
                }
            });

            mOkHttpClient = okHttpClientBuilder.build();
        } else
        {
            mOkHttpClient = okHttpClient;
        }

        init();
    }

    private void init()
    {
        mDelivery = new Handler(Looper.getMainLooper());
    }


//    public OkHttpUtils debug(String tag)
//    {
//        mOkHttpClient = getOkHttpClient().newBuilder().addInterceptor(new LoggerInterceptor(tag, false)).build();
//        return this;
//    }

//    /**
//     * showResponse may cause error, but you can try .
//     *
//     * @param tag
//     * @param showResponse
//     * @return
//     */
//    public OkHttpUtils debug(String tag, boolean showResponse)
//    {
//        mOkHttpClient = getOkHttpClient().newBuilder().addInterceptor(new LoggerInterceptor(tag, showResponse)).build();
//        return this;
//    }

    public static OkHttp getInstance(OkHttpClient okHttpClient)
    {
        if (mInstance == null)
        {
            synchronized (OkHttp.class)
            {
                if (mInstance == null)
                {
                    mInstance = new OkHttp(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public static OkHttp getInstance()
    {
        if (mInstance == null)
        {
            synchronized (OkHttp.class)
            {
                if (mInstance == null)
                {
                    mInstance = new OkHttp(null);
                }
            }
        }
        return mInstance;
    }


    public Handler getDelivery()
    {
        return mDelivery;
    }

    public OkHttpClient getOkHttpClient()
    {
        return mOkHttpClient;
    }



    /**
     * for https-way authentication
     *
     * @param certificates
     */
    public void setCertificates(InputStream... certificates)
    {
        SSLSocketFactory sslSocketFactory = HttpUtils.getSslSocketFactory(certificates, null, null);

        OkHttpClient.Builder builder = getOkHttpClient().newBuilder();
        builder = builder.sslSocketFactory(sslSocketFactory);
        mOkHttpClient = builder.build();


    }

    /**
     * for https mutual authentication
     *
     * @param certificates
     * @param bksFile
     * @param password
     */
    public void setCertificates(InputStream[] certificates, InputStream bksFile, String password)
    {
        mOkHttpClient = getOkHttpClient().newBuilder()
                .sslSocketFactory(HttpUtils.getSslSocketFactory(certificates, bksFile, password))
                .build();
    }

    public void setHostNameVerifier(HostnameVerifier hostNameVerifier)
    {
        mOkHttpClient = getOkHttpClient().newBuilder()
                .hostnameVerifier(hostNameVerifier)
                .build();
    }

    public void setConnectTimeout(int timeout, TimeUnit units)
    {
        mOkHttpClient = getOkHttpClient().newBuilder()
                .connectTimeout(timeout, units)
                .build();
    }

    public void setReadTimeout(int timeout, TimeUnit units)
    {
        mOkHttpClient = getOkHttpClient().newBuilder()
                .readTimeout(timeout, units)
                .build();
    }

    public void setWriteTimeout(int timeout, TimeUnit units)
    {
        mOkHttpClient = getOkHttpClient().newBuilder()
                .writeTimeout(timeout, units)
                .build();
    }


    public static class METHOD
    {
        public static final String HEAD = "HEAD";
        public static final String DELETE = "DELETE";
        public static final String PUT = "PUT";
        public static final String PATCH = "PATCH";
    }
}
