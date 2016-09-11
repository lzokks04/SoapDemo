package com.lzokks04.soapdemo.util.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**此类代表XML中<soap12:Envelope> </soap12:Envelope>中所有的信息
 * 包括头，命名空间等
 * 此xml定义好后会POST到目标服务器
 * Created by Liu on 2016/9/11.
 */

/*
请求xml格式
<?xml version="1.0" encoding="utf-8"?>
<soap12:Envelope
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:xsd="http://www.w3.org/2001/XMLSchema"
xmlns:soap12="http://www.w3.org/2003/05/soap-envelope">
  <soap12:Body>
    <qqCheckOnline xmlns="http://WebXml.com.cn/">
      <qqCode>string</qqCode>
    </qqCheckOnline>
  </soap12:Body>
</soap12:Envelope>
*/


//此注解表示注释中对应字符
@Root(name = "soap12:Envelope")
//此处对应soap12:Envelope这个xml的命名空间
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://www.w3.org/2003/05/soap-envelope", prefix = "soap12")
})

public class RequestEnvelope {

    //设置<soap12:Body><soap12:Body/>
    @Element(name = "soap12:Body", required = false)
    private RequestBody body;

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }
}
