package com.lzokks04.soapdemo.util.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/*
<?xml version="1.0" encoding="utf-8"?>
<soap12:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:xsd="http://www.w3.org/2001/XMLSchema"
xmlns:soap12="http://www.w3.org/2003/05/soap-envelope">
  <soap12:Body>
    <qqCheckOnlineResponse xmlns="http://WebXml.com.cn/">
      <qqCheckOnlineResult>string</qqCheckOnlineResult>
    </qqCheckOnlineResponse>
  </soap12:Body>
</soap12:Envelope>
*/

/**
 * Created by Liu on 2016/9/11.
 */
@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://www.w3.org/2003/05/soap-envelope", prefix = "soap12")
})
public class ResponseEnvelope {
    //此处不知为何要单独设置成Body，设置成soap12:Body会解析不了
    @Element(name = "Body")
    private ResponseBody body;

    public ResponseBody getBody() {
        return body;
    }

    public void setBody(ResponseBody body) {
        this.body = body;
    }
}
