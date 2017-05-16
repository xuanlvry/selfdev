package com.my.test.ssoserver;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Chengfei.Sun on 17/01/22.
 */
@Component
public class TokenUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    //存储临时令牌到redis中，存活期60秒
    //token存在的有效期不能过长，这是处于安全的角度。
    public void setToken(String tokenId, TokenInfo tokenInfo) {
        // TODO: 17/01/23 hash存储优化
        BoundHashOperations<String, String, String> hashOperations = redisTemplate.boundHashOps(tokenId);
        Map<String, Object> map = new BeanMap(tokenInfo);

        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == null || "class".equals(entry.getKey())
                    || entry.getValue() == "") {
                continue;
            }
            // 按类型存储
            if (entry.getValue() instanceof Date) {
                Date date = (Date) entry.getValue();
                hashOperations.put(entry.getKey().toString(), date.getTime() + "");
            } else {
                hashOperations.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }

        redisTemplate.expire(tokenId, 60, TimeUnit.SECONDS);
    }

    //根据token键取TokenInfo
    public TokenInfo getToken(String tokenId) {
        BoundHashOperations<String, String, String> hashOperations = redisTemplate.boundHashOps(tokenId);

        TokenInfo tokenInfo = new TokenInfo();
        try {
            BeanUtils.populate(tokenInfo, hashOperations.entries());

            //只能使用一次
            this.delToken(tokenId);

            return tokenInfo;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除Token
    public void delToken(String tokenId) {
        redisTemplate.delete(tokenId);
    }


}
