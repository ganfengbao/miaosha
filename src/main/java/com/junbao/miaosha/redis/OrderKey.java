package com.junbao.miaosha.redis;

/**
 * @author 小笨蛋
 */
public class OrderKey extends BasePrefix {
    public OrderKey(int expireSencods, String prefix) {
        super(expireSencods, prefix);
    }
}
