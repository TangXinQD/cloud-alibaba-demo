package com.gateway.test;

import java.util.regex.Pattern;

/**
 * @author TX
 * @version 1.0
 * @description DemoTest
 * @date 2020/9/29 10:25 上午
 */
public class DemoTest {
    public static void main(String[] args) {
        String permissionResource = ":demo:naming/gateway";
        String permissionSelf = ":.*:.*";

        boolean matches = Pattern.matches(permissionSelf, permissionResource);
        System.out.println(matches);
    }
}
