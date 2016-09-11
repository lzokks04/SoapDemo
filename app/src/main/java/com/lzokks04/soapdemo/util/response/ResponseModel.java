package com.lzokks04.soapdemo.util.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Liu on 2016/9/11.
 */
@Root(name = "qqCheckOnlineResult")
@Namespace(reference = "http://WebXml.com.cn/")
public class ResponseModel {
    @Element(name = "qqCheckOnlineResult")
    private String qqCheckOnlineResult;

    public String getQqCheckOnlineResult() {
        return qqCheckOnlineResult;
    }

    public void setQqCheckOnlineResult(String qqCheckOnlineResult) {
        this.qqCheckOnlineResult = qqCheckOnlineResult;
    }
}
