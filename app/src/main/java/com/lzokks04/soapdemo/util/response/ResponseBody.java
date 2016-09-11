package com.lzokks04.soapdemo.util.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Liu on 2016/9/11.
 */
@Root(name = "Body")
public class ResponseBody {

    @Element(name = "qqCheckOnlineResponse",required = false)
    private ResponseModel responseModel;

    public ResponseModel getResponseModel() {
        return responseModel;
    }

    public void setResponseModel(ResponseModel responseModel) {
        this.responseModel = responseModel;
    }
}
