package com.pineone.code.study;

/**
 * Created by pahnj on 2015-12-06.
 */
public interface IUriParsingApi {

    String getProtocal(String url);

    String getHost(String url);

    String getPort(String url);

    String getSub(String url);

}
