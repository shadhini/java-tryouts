package com.shadhini.java.tryouts.oop.abstraction_n_coupling;

/**
 * Browser class
 */
public class Browser {

    public void navigate(String address) {
        String ip = findIpAddreses(address);
        String html = sendHttpRequest(ip);
        System.out.println(html);
    }

    private String sendHttpRequest(String ip) {
        return "<html></html>";
    }

    private String findIpAddreses(String address) {
        return "127.0.0.1";
    }


}
