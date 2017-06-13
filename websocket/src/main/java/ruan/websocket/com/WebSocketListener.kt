package ruan.websocket.com

/**
 * Created by 19820 on 2017/6/13.
 */
interface WebSocketListener {

    /**
     * 接收信息的接口
     */
    fun onRevice(msg : String?)

    /**
     * 发生错误的接口
     */
    fun onError()


    /**
     * 关闭连接的接口
     */
    fun onClose()


    /**
     * 保持长连接的ping 和 pong 的触发接口
     */
    fun onPong()


    /**
     * 连接成功的接口
     */
    fun onOpen()

}