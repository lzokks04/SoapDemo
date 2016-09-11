package com.lzokks04.soapdemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lzokks04.soapdemo.R;
import com.lzokks04.soapdemo.util.SoapRetrofitGenerator;
import com.lzokks04.soapdemo.util.request.RequestBody;
import com.lzokks04.soapdemo.util.request.RequestEnvelope;
import com.lzokks04.soapdemo.util.request.RequestModel;
import com.lzokks04.soapdemo.util.response.ResponseEnvelope;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_input)
    EditText etInput;
    @BindView(R.id.btn_seacrh)
    Button btnSeacrh;
    @BindView(R.id.tv_result)
    TextView tvResult;
    private RequestEnvelope requestEnvelop;
    private RequestBody requestBody;
    private RequestModel requestModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("QQ在线检测(SOAP)");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        init();
    }

    private void init() {
        requestEnvelop = new RequestEnvelope();
        requestBody = new RequestBody();
        requestModel = new RequestModel();
    }

    @OnClick(R.id.btn_seacrh)
    public void onClick() {
        etInput.setText("");
        if (TextUtils.isEmpty(etInput.getText().toString())) {
            Toast.makeText(this, "请输入QQ号码！", Toast.LENGTH_SHORT).show();
        } else {
            getWebServiceData();
            etInput.setText("");
        }

    }

    private void getWebServiceData() {

        requestModel.setQqCode(etInput.getText().toString());
        requestModel.setQqCodeAttribute("http://WebXml.com.cn/");

        requestBody.setQqCheckOnline(requestModel);
        requestEnvelop.setBody(requestBody);

        Call<ResponseEnvelope> call = SoapRetrofitGenerator.getInterfaceFun().getdata(requestEnvelop);
        call.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                if (response.body().getBody().getResponseModel().getQqCheckOnlineResult().equals("Y")) {
                    tvResult.setText("在线");
                } else if (response.body().getBody().getResponseModel().getQqCheckOnlineResult().equals("N")) {
                    tvResult.setText("离线");
                } else {
                    tvResult.setText("未知错误");
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                tvResult.setText("error!");
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }


}
