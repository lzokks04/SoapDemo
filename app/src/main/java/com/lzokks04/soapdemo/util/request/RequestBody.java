package com.lzokks04.soapdemo.util.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Liu on 2016/9/11.
 */
//表示<soap12:Envelope> <soap12:Envelope/>中所有的数据
@Root(name = "soap12:Body",strict = false)
public class RequestBody {

    //设置<qqCheckOnline><qqCheckOnline/>
    @Element(name = "qqCheckOnline", required = false)
    private RequestModel qqCheckOnline;

    public RequestModel getQqCheckOnline() {
        return qqCheckOnline;
    }

    public void setQqCheckOnline(RequestModel qqCheckOnline) {
        this.qqCheckOnline = qqCheckOnline;
    }
}
