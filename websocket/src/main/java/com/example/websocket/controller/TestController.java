package com.example.websocket.controller;

import com.example.websocket.config.SocketManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author songbo
 * @Date 2020/2/8 下午5:16
 **/
@RestController
@Slf4j
public class TestController {

    @Autowired
    private SimpMessagingTemplate template;

    /*@RequestMapping("/test/{text}")
    public void test(@PathVariable String text) {
        template.convertAndSend("/topic/sendTopic", text);
    }*/

    /**
     * 服务器指定用户进行推送,需要前端开通 var socket = new SockJS(host+'/myUrl' + '?token=1234');
     */
    @RequestMapping("/sendUser/{token}/{text}")
    public void sendUser(@PathVariable String token,
                         @PathVariable String text) {
        log.info("token = {} ,对其发送您好", token);
        WebSocketSession webSocketSession = SocketManager.get(token);
        if (webSocketSession != null) {
            /**
             * 主要防止broken pipe
             */
            template.convertAndSendToUser("1234", "/queue/sendUser", text);

        }


    }

    /**
     * 广播，服务器主动推给连接的客户端
     */
    @RequestMapping("/sendTopic")
    public void sendTopic() {
        template.convertAndSend("/topic/sendTopic", "大家晚上好");
    }

    /**
     * 客户端发消息，服务端接收
     *
     * @param message
     */
    // 相当于RequestMapping
    @MessageMapping("/sendServer")
    public void sendServer(String message) {
        log.info("message:{}", message);
    }

    /**
     * 客户端发消息，大家都接收，相当于直播说话
     *
     * @param message
     * @return
     */
    @MessageMapping("/sendAllUser")
    @SendTo("/topic/sendTopic")
    public String sendAllUser(String message) {
        // 也可以采用template方式
        return message;
    }

    /**
     * 点对点用户聊天，这边需要注意，由于前端传过来json数据，所以使用@RequestBody
     * 这边需要前端开通var socket = new SockJS(host+'/myUrl' + '?token=4567');   token为指定name
     * @param map
     */
    @MessageMapping("/sendMyUser")
    public void sendMyUser(@RequestBody Map<String, String> map) {
        log.info("map = {}", map);
        WebSocketSession webSocketSession = SocketManager.get(map.get("name"));
        if (webSocketSession != null) {
            log.info("sessionId = {}", webSocketSession.getId());
            template.convertAndSendToUser(map.get("name"), "/queue/sendUser", map.get("message"));
        }
    }


}
