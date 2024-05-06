package com.ruoyi.framework.websocket;

import com.ruoyi.common.core.domain.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket 客户端用户集
 *
 * @author ruoyi
 */
public class WebSocketUsers {
    /**
     * WebSocketUsers 日志控制器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketUsers.class);

    /**
     * 用户集
     */
    private static Map<String, Session> USERS = new ConcurrentHashMap<String, Session>();

    /**
     * sessionId 对应的用户列表
     */
    private static Map<String, SysUser> USER_S = new ConcurrentHashMap<>();

    /**
     * 存储用户
     *
     * @param key     唯一键
     * @param session 用户信息
     */
    public static void put(String key, Session session) {
        USERS.put(key, session);
    }

    /**
     * 移除用户
     *
     * @param session 用户信息
     * @return 移除结果
     */
    public static boolean remove(Session session) {
        String key = null;
        boolean flag = USERS.containsValue(session);
        if (flag) {
            Set<Map.Entry<String, Session>> entries = USERS.entrySet();
            for (Map.Entry<String, Session> entry : entries) {
                Session value = entry.getValue();
                if (value.equals(session)) {
                    key = entry.getKey();
                    break;
                }
            }
        } else {
            return true;
        }
        return remove(key);
    }

    /**
     * 移出用户
     *
     * @param key 键
     */
    public static boolean remove(String key) {
        LOGGER.info("\n 正在移出用户 - {}", key);
        Session remove = USERS.remove(key);
        SysUser user = USER_S.remove(key);
        if (remove != null && user != null) {
            boolean containsValue = USERS.containsValue(remove);
            boolean conVal = USER_S.containsValue(user);
            LOGGER.info("\n 移出结果 - {}", containsValue && conVal ? "失败" : "成功");
            return containsValue;
        } else {
            return true;
        }
    }

    /**
     * 获取在线用户列表
     *
     * @return 返回用户集合
     */
    public static Map<String, Session> getUsers() {
        return USERS;
    }

    /**
     * 群发消息文本消息
     *
     * @param message 消息内容
     */
    public static void sendMessageToUsersByText(String message) {
        Collection<Session> values = USERS.values();
        for (Session value : values) {
            sendMessageToUserByText(value, message);
        }
    }

    /**
     * 将上线的员工添加到员工列表
     *
     * @param session
     * @param user    用户信息
     */
    public static void putOnlineWorker(Session session, SysUser user) {
        USER_S.put(session.getId(), user);
        LOGGER.info("已添加车间为" + session.getId() + "员工");
    }

    /**
     * 发送文本消息
     *
     * @param session 自己的用户名
     * @param message 消息内容
     */
    public static void sendMessageToUserByText(Session session, String message) {
        if (session != null) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                LOGGER.error("\n[发送消息异常]", e);
            }
        } else {
            LOGGER.info("\n[你已离线]");
        }
    }

    /**
     * 向某人发送信息
     *
     * @param userId
     * @param msg
     */
    public static void sendMessageToUserByUserId(Long userId, String msg) {
        USER_S.forEach((k, v) -> {
            if (Objects.equals(v.getUserId(), userId)) {
                try {
                    USERS.get(k).getBasicRemote().sendText(msg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
