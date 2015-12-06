package com.pineone.code.study;

import org.springframework.stereotype.Service;

/**
 * Created by pahnj on 2015-12-06.
 */

@Service
public class UriParsing implements IUriParsingApi {


    public String getProtocal(String url) {
        if (url == null || url.length() == 0) {
            return "no data";
        } else {
            return url.substring(0, url.indexOf(":"));
        }
    }

    public String getHost(String url) {
        if (url == null || url.length() == 0) {
            return "no data";
        }

        int prefixData = 3;

        if(url.indexOf("://") != -1){
            prefixData = 3;
        } else if(url.indexOf(":") != -1){
            prefixData = 1;
        }

        String host = url.substring(url.indexOf(":") + prefixData, url.length());

        if (host.indexOf(":") != -1) {
            return host.substring(0, host.indexOf(":"));
        } else if (host.indexOf("/") != -1) {
            return host.substring(0, host.indexOf("/"));
        } else {
            return host;
        }

    }

    public String getPort(String url) {

        String port = url.substring(url.indexOf(":") + 3, url.length());

        if (port.indexOf(":") == -1) {
            return "8080";
        } else if (port.indexOf("/") != -1) {
            return port.substring(port.indexOf(":") + 1, port.indexOf("/"));
        } else {
            return port.substring(port.indexOf(":") + 1, port.length());
        }

    }

    public String getSub(String url) {

        String sub = "";

        if (url == null || url.length() == 0) {
            return "no data";
        }


        int startSubindex = getProtocal(url).length() + getHost(url).length() + 1;
        sub = url.substring(startSubindex, url.length());

        if (sub.indexOf("/") == -1) {
            return "no sub data";
        }

        startSubindex = sub.indexOf("/");
        sub = sub.substring(startSubindex + 1, sub.length());
        if(sub.length() == 0){
            return "no sub data";
        }
        return sub;
    }
}
