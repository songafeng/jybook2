package com.fo.service.impl;

import com.fo.Utils.JedisConfig;
import com.fo.Utils.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;


/**
 * 一个简单的Redis服务
 *
 * @author liaoqiqi
 * @version 2014-6-17
 */
@Service
@Scope("singleton")
public class SimpleRedisService implements InitializingBean, DisposableBean {

    protected static final Logger LOGGER = LoggerFactory
            .getLogger(SimpleRedisService.class);

    // jedis 实例
    private static Jedis jedis = null;

    /**
     * 分布式配置
     */
    @Autowired
    private JedisConfig jedisConfig;

    /**
     * 关闭
     */
    public void destroy() throws Exception {

        if (jedis != null) {
            jedis.disconnect();
        }
    }

    /**
     * 进行连接
     */
    public void afterPropertiesSet() throws Exception {

        jedis = JedisUtil.createJedis(jedisConfig.getHost(),
                jedisConfig.getPort(),jedisConfig.getPassword());
    }

    /**
     * 更改Jedis
     */
    public void changeJedis() {

//        LOGGER.info("start to change jedis hosts to: " + jedisConfig.getHost() + " : " + jedisConfig.getPort());


        jedis = JedisUtil.createJedis(jedisConfig.getHost(),
                jedisConfig.getPort(),jedisConfig.getPassword());

//        LOGGER.info("change ok.");
    }

    /**
     * 获取一个值
     *
     * @param key
     * @return
     */
    public String getKey(String key) {
        if (jedis != null) {
            return jedis.get(key);
        }

        return null;
    }

    public String setKey(String key,String value){
        if(jedis!=null)
        {
            return jedis.set(key,value);
        }
        else
            return "";
    }
}