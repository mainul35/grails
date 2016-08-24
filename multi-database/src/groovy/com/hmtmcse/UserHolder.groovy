package com.hmtmcse


class UserHolder {
    public static Integer DEFAULT = 2;
    private static final ThreadLocal contextHolder = new ThreadLocal();
    public static String DS_PREFIX = "dataSource_";
    public static String DS_POSTFIX = "User";

    static void setEnvironment(Map environment) {
        contextHolder.set(environment);
    }

    static getEnvironment() {
        return contextHolder.get();
    }

    static void clear() {
        contextHolder.remove();
    }
}
