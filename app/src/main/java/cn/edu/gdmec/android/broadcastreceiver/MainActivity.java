package cn.edu.gdmec.android.broadcastreceiver;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        //实例化广播接收者
        MyReceiver receiver = new MyReceiver ();
        //实例化过滤器并设置要过滤的广播
        String action = "android.provider.Telephony.SMS_RECEIVED";
        IntentFilter filter = new IntentFilter ( action );
        //注册广播
        registerReceiver ( receiver,filter );
    }
    @Override
    protected void onDestroy(){
        super.onDestroy ();
        //当Activity销毁时取消注册BroadcastReceiver
        unregisterReceiver ( receiver );
    }
}
