package com.pineone.code.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pahnj on 2015-12-06.
 */

@RestController
public class DataController {

    @Autowired
    IUriParsingApi uriParsingApi;

    @RequestMapping(value = "/protocol", method = RequestMethod.POST)
    public String dataProtocalController(@RequestBody String url) {
        return uriParsingApi.getProtocal(url);
    }

    @RequestMapping(value = "/host", method = RequestMethod.POST)
    public String dataHostController(@RequestBody String url) {
        return uriParsingApi.getHost(url);
    }

    @RequestMapping(value = "/port", method = RequestMethod.POST)
    public String dataPortController(@RequestBody String url) {
        return uriParsingApi.getPort(url);
    }

    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    public String dataSubController(@RequestBody String url) {
        return uriParsingApi.getSub(url);
    }

}
