package com.zaxcler.test.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;

import com.zaxcler.test.R;

public class MyService extends Service {

    private PendingIntent pendingIntent;
    private Intent intent;
    private Notification.Builder builder;
    private Notification notification;
    private NotificationManager manager;

    private int notificationid=1;
    private RemoteViews remoteViews;

    private int progress=0;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
//            builder=new Notification.Builder(getApplication())
//                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                    .setDefaults(Notification.DEFAULT_SOUND)
//                    .setContent(remoteViews)
//                    .setContentIntent(pendingIntent)
//                    .setProgress(100,msg.arg1,false);
//            notification=builder.getNotification();
//            manager.notify(notificationid,notification);
            Log.e("测试",""+msg.arg1);
            remoteViews =new RemoteViews(getPackageName(),R.layout.download_notification);
            remoteViews.setProgressBar(R.id.progress,100,msg.arg1,false);
            remoteViews.setTextViewText(R.id.progress_value, msg.arg1+"%");
            notification.contentView=remoteViews;
            manager.notify(notificationid, notification);
        }
    };

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {

        notification=new Notification();
        notification.icon = R.mipmap.ic_launcher;
        notification.tickerText="新消息";


        manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        intent=new Intent(this,MainActivity.class);
        pendingIntent=PendingIntent.getActivity(this, 0, intent, 0);
        remoteViews =new RemoteViews(getPackageName(),R.layout.download_notification);


//            builder=new Notification.Builder(getApplication())
//                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
//                    .setDefaults(Notification.DEFAULT_SOUND)
//                    .setContent(remoteViews)
//                    .setContentIntent(pendingIntent)
//                    .setProgress(100, 0, false);
//            notification=builder.getNotification();




        notification.contentIntent=pendingIntent;
        notification.contentView=remoteViews;

        remoteViews.setProgressBar(R.id.progress, 100, 20, false);
        remoteViews.setTextViewText(R.id.progress_value,"0%");
        manager.notify(notificationid,notification);

        MessageThread thread=new MessageThread();
        thread.start();

        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class MessageThread extends Thread{



        @Override
        public void run() {
            while (progress<100){
                try {
                    sleep(1000);
                    progress++;
                    Message message=new Message();
                    message.arg1=progress;
                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }


    }
}
