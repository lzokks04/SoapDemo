package com.lzokks04.soapdemo.util.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * <qqCode>string</qqCode>
 * Created by Liu on 2016/9/11.
 */

public class RequestModel {
    //制定qqCode的命名空间，手动设置
    @Attribute(name = "xmlns")
    private String qqCodeAttribute;
    //由于这是xml最里面一层所以设置<qqCode><qqCode/>中的值
    @Element(name = "qqCode",required = false)
    private String qqCode;

    public String getQqCodeAttribute() {
        return qqCodeAttribute;
    }

    public void setQqCodeAttribute(String qqCodeAttribute) {
        this.qqCodeAttribute = qqCodeAttribute;
    }

    public String getQqCode() {
        return qqCode;
    }

    public void setQqCode(String qqCode) {
        this.qqCode = qqCode;
    }
}
