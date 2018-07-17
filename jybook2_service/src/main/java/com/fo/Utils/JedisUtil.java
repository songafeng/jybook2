package com.fo.Utils;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * Created by jdd on 2018/7/11.
 */
public class JedisUtil {

    public static Jedis createJedis() {
        Jedis jedis = new Jedis("127.0.0.1");
        return jedis;
    }

    public static Jedis createJedis(String host, int port) {
        Jedis jedis = new Jedis(host, port);

        return jedis;
    }

    public static Jedis createJedis(String host, int port, String password) {
        System.out.println("createJedis host:"+host+";port:"+port);
        Jedis jedis = new Jedis(host, port);
        jedis.auth(password);
//        if (!StringUtils.isNotBlank(password)) {
//            jedis.auth(password);
//        }

        return jedis;
    }
}