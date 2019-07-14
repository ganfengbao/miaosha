package com.junbao.miaosha.redis;

/**
 * @author 小笨蛋
 */
public abstract class BasePrefix implements KeyPrefix {

    private int expireSencods;

    private String prefix;

    public BasePrefix( String prefix) {
        this.expireSencods = 0;
        this.prefix = prefix;
    }

    public BasePrefix(int expireSencods, String prefix) {
        this.expireSencods = expireSencods;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() { // 默认0代表永不过期
        return expireSencods;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + prefix;
    }
}
