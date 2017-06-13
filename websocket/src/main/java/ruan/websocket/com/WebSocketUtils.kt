package ruan.websocket.com

import android.util.Log
import org.java_websocket.WebSocket
import org.java_websocket.client.WebSocketClient
import org.java_websocket.drafts.Draft
import org.java_websocket.framing.Framedata
import org.java_websocket.handshake.ServerHandshake
import java.lang.Exception
import java.net.URI

/**
 * Created by 19820 on 2017/6/13.
 */
class WebSocketUtils (serverUri: URI, draft: Draft, webSocketListener: WebSocketListener?) : WebSocketClient(serverUri , draft) {

    /**
     * 打印的标识
     */
    var LOG : String = "WebSocketUtils"
    /**
     * 处理连接的节接口
     */
    var webSocketListener : WebSocketListener? = null

    init {
        this.webSocketListener = webSocketListener
    }


    override fun onOpen(p0: ServerHandshake?) {
        webSocketListener?.onOpen()
    }

    override fun onClose(p0: Int, p1: String?, p2: Boolean) {
        webSocketListener?.onClose()
    }

    override fun onMessage(p0: String?) {
        Log.d(LOG , p0)
        webSocketListener?.onRevice(p0)
    }

    override fun onError(p0: Exception?) {
        webSocketListener?.onError()
    }

    override fun onWebsocketPing(conn: WebSocket?, f: Framedata?) {
        super.onWebsocketPing(conn, f)
    }

    override fun onWebsocketPong(conn: WebSocket?, f: Framedata?) {
        super.onWebsocketPong(conn, f)
        webSocketListener?.onPong()
    }


}
