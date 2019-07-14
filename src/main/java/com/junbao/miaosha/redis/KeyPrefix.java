package com.junbao.miaosha.redis;

/**
 * @author 小笨蛋
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
