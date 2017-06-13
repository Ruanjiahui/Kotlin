package ruan.websocket.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity implements WebSocketListener{

    private WebSocket webSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webSocket = new WebSocket("ws://192.168.3.101:80/chat/MTUxMTk0ODEzNzMxMjM0NTYxNDk3MTg0MzgzMzcy" , this);
        webSocket.connect();

    }

    @Override
    public void onRevice(@Nullable String msg) {
        System.out.println("onRevice" + msg);
    }

    @Override
    public void onError() {
        System.out.println("onError");
    }

    @Override
    public void onClose() {
        System.out.println("onClose");
    }

    @Override
    public void onPong() {
        System.out.println("onPong");
    }

    @Override
    public void onOpen() {
        System.out.println("onOpen");
    }
}
