package ruan.websocket.com

import org.java_websocket.drafts.Draft_17
import org.java_websocket.framing.Framedata
import org.java_websocket.framing.FramedataImpl1
import java.net.URI
import java.nio.ByteBuffer

/**
 * 外部调用websocket的 类
 * Created by 19820 on 2017/6/13.
 */
class WebSocket {

    var url : String ?= null
    var webSocketListener : WebSocketListener?= null

    var webSocketUtils : WebSocketUtils?= null


    constructor(url : String ? , webSocketListener: WebSocketListener?) : super(){
        this.url = url
        this.webSocketListener = webSocketListener
    }


    /**
     * 初始化websocket 连接websocket
     */
    fun connect(){
        webSocketUtils = WebSocketUtils(URI(url), Draft_17(), webSocketListener)
        //连接数据库
        (webSocketUtils as WebSocketUtils).connectBlocking()
    }

    /**
     * 发送信息
     */
    fun send(msg : String?){
        webSocketUtils?.send(msg)
    }

    /**
     * 发送信息
     */
    fun send(msg : ByteBuffer?){
        webSocketUtils?.send(msg)
    }

    /**
     * 发送长连接心跳
     */
    fun sendPing(){
        val framedata = FramedataImpl1()
        //这个websocket的code   9为发送 ping标识
        framedata.setOptcode(Framedata.Opcode.PING)
        framedata.setFin(true)
        val buffer = ByteBuffer.allocate(1)
        //发送没有掩码  长度为0
        buffer.put(0x00)
        framedata.setPayload(buffer)
        webSocketUtils?.sendFrame(framedata)
    }

    /**
     * 关闭连接
     */
    fun close(){
        webSocketUtils?.close()
    }

}