# Kotlin


这个依赖包主要解决了 android 使用websocket的繁琐操作
底层使用的是apache 的 websocket 解析包jar

之后上面封装一层方便使用
顺道加多一个 ping pong 心跳接口


使用方法

java 

      WebSocket websocket = new WebSocket("url" , new WebSocketListener() {
            @Override
            public void onRevice(String s) {
                
            }

            @Override
            public void onError() {

            }

            @Override
            public void onClose() {

            }

            @Override
            public void onPong() {

            }

            @Override
            public void onOpen() {

            }
        });
        websocket.connect();
 
 
 Kotlin
 
        class MyWebSocket : WebSocketListener{
          
            var websocket : WebSocket = WebSocket("url" , this)
            
            websocket.connect()
            
            override fun onRevice(msg: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

    
            override fun onError() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

   
            override fun onClose() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

    
            override fun onPong() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

    
            override fun onOpen() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        
        
 只需要两句话就可以实现websocket的通讯
 
 
 调用方式后续补上
