package com.yuki.experiment.framework.socket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuki.experiment.framework.dto.SocketMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/so/{teamId}/{userId}")
@Slf4j
public class SO {
//    /**
//     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
//     */
//    private static int onlineCount = 0;
//    /**
//     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
//     */
//    private static final ConcurrentHashMap<Integer, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
//
//    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WebSocketServer>> allUserMap
//            = new ConcurrentHashMap<>();
//    /**
//     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
//     */
//    private Session session;
//    /**
//     * 接收userId
//     */
//    private Integer userId = null;
//    /**
//     * 团队Id
//     */
//    private String teamId=null;
//    /**
//     * 连接建立成功调用的方法
//     */
//    @OnOpen
//    public void onOpen(Session session,@PathParam("teamId")String teamId,
//                       @PathParam("userId") Integer userId) {
//        //String uuid = UUID.randomUUID().toString();
//        ConcurrentHashMap<Integer,WebSocketServer>tempMap=new ConcurrentHashMap<>();
//        allUserMap.put(teamId,tempMap);
//
//
//        this.teamId=teamId;
//        this.session = session;
//        this.userId = userId;
//
//        //webSocketMap.put(userId,this); put是可以覆盖的
//        if (webSocketMap.containsKey(userId)) {
//            webSocketMap.remove(userId);
//            webSocketMap.put(userId, this);
//            //加入set中
//        } else {
//            webSocketMap.put(userId, this);
//            //加入set中
//            addOnlineCount();
//            //在线数加1
//        }
//
//        log.info("用户连接:" + userId + ",当前在线人数为:" + getOnlineCount());
//
//        try {
//            sendMessage("连接成功");
//        } catch (IOException e) {
//            log.error("用户:" + userId + ",网络异常!!!!!!");
//        }
//    }
//
//    /**
//     * 连接关闭调用的方法
//     */
//    @OnClose
//    public void onClose() {
//        if (webSocketMap.containsKey(userId)) {
//            webSocketMap.remove(userId);
//            //从set中删除
//            subOnlineCount();
//        }
//        log.info("用户退出:" + userId + ",当前在线人数为:" + getOnlineCount());
//    }
//
//    /**
//     * 收到客户端消息后调用的方法
//     *这里参数只能是string
//     * @param message 客户端发送过来的消息
//     */
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        log.info("用户消息:" + userId + ",报文:" + message);
//        //可以群发消息
//        //消息保存到数据库、redis
//        if (StringUtils.isNotBlank(message)) {
//            try {
//                //解析发送的报文
//                JSONObject jsonObject = JSON.parseObject(message);
//                //追加发送人(防止串改)
//                jsonObject.put("fromUserId", this.userId);
//
//                String toUserId = jsonObject.getString("toUserId");
//                //传送给对应toUserId用户的websocket
//                if (StringUtils.isNotBlank(toUserId) && webSocketMap.containsKey(toUserId)) {
//                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
//                } else {
//                    log.error("请求的userId:" + toUserId + "不在该服务器上");
//                    //否则不在这个服务器上，发送到mysql或者redis
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    /**
//     * @param session
//     * @param error
//     */
//    @OnError
//    public void onError(Session session, Throwable error) {
//        log.error("用户错误:" + this.userId + ",原因:" + error.getMessage());
//        error.printStackTrace();
//    }
//
//    /**
//     * 实现服务器主动推送
//     */
//    public void sendMessage(String message) throws IOException {
//        this.session.getBasicRemote().sendText(message);
//    }
//
//
//    /**
//     * 发送自定义消息
//     */
//    public static void sendInfo(String message, String userId) throws IOException {
//        log.info("发送消息到:" + userId + "，报文:" + message);
//        if (StringUtils.isNotBlank(userId) && webSocketMap.containsKey(userId)) {
//            webSocketMap.get(userId).sendMessage(message);
//        } else {
//            log.error("用户" + userId + ",不在线！");
//        }
//    }
//
//    public static void sendInfo(SocketMessageDTO messageDTO) throws EncodeException, IOException {
//        Integer userId = messageDTO.getUserId();
//        JSONObject message = messageDTO.getMessage();
//        log.info("发送消息到:" + userId + "，报文:" + message);
//        if (webSocketMap.containsKey(userId)) {
//            webSocketMap.get(userId).sendMessage(message.toJSONString());
//        }
//    }
//
//    public static synchronized int getOnlineCount() {
//        return onlineCount;
//    }
//
//    public static synchronized void addOnlineCount() {
//        WebSocketServer.onlineCount++;
//    }
//
//    public static synchronized void subOnlineCount() {
//        WebSocketServer.onlineCount--;
//    }
}
