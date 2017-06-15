package ruan.kotlin.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import ruan.mydatabase.com.BaseUser;
import ruan.mydatabase.com.CheckDatabase;
import ruan.mydatabase.com.Database;
import ruan.mydatabase.com.Operation.CreateTable;
import ruan.mydatabase.com.api.Establish;
import ruan.websocket.com.WebSocket;
import ruan.websocket.com.WebSocketListener;

public class MainActivity extends AppCompatActivity implements Database.Check{

    private WebSocket webSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CheckDatabase.Companion.CheckData(this , "test" , "test" , this);

        Topic topic = new Topic();
        topic.setNickname("测试");

        int n = new BaseUser(this).INSERT("test" , "test" , topic);
        System.out.println("插入数据:" + n);


//        new BaseUser(this).

//        webSocket = new WebSocket("ws://192.168.3.101:80/chat/MTUxMTk0ODEzNzMxMjM0NTYxNDk3MTg0MzgzMzcy" , this);
//        webSocket.connect();

    }

    private Establish establish;

    @NotNull
    @Override
    public Establish CreateTable(@NotNull String database, @NotNull String table, boolean state) {
        //如果state 等于true说明这个表已经创建
        if (state) {
            return null;
        } else {
            if (TextUtils.equals(table, "test")) {
                establish = getTopic();
            }
            return establish;
        }
    }

    /**
     * 校汇圈表
     *
     * @return
     */
    private Establish getTopic() {
        Establish establish = new Establish();

        establish.put("comment_num", "int");
        establish.put("content", "varchar(50)");
        establish.put("created_at", "varchar(50)");
        establish.put("favorited", "int");
        establish.put("favourites_count", "int");
        establish.put("is_top", "int");
        establish.put("nickname", "varchar(50)");
        establish.put("openid", "varchar(50)");
        establish.put("thumb", "varchar(50)");
        establish.put("tid", "int");
        establish.put("view_num", "int");

        return establish;
    }


//    @Override
//    public void onRevice(@Nullable String msg) {
//        System.out.println("onRevice" + msg);
//    }
//
//    @Override
//    public void onError() {
//        System.out.println("onError");
//    }
//
//    @Override
//    public void onClose() {
//        System.out.println("onClose");
//    }
//
//    @Override
//    public void onPong() {
//        System.out.println("onPong");
//    }
//
//    @Override
//    public void onOpen() {
//        System.out.println("onOpen");
//    }
}
