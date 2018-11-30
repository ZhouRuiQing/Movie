package com.bw.movie.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.IView.IPayView;
import com.bw.movie.IView.IShopOrderView;
import com.bw.movie.R;
import com.bw.movie.app.Myapp;
import com.bw.movie.mvp.model.bean.IndentBean;
import com.bw.movie.mvp.model.bean.PayBean;
import com.bw.movie.mvp.present.CinemaInfoPresent;
import com.bw.movie.mvp.present.PayPresent;
import com.bw.movie.mvp.present.ShopOrderPresent;
import com.bw.movie.mvp.view.cancansview.SeatTable;
import com.tencent.mm.sdk.modelpay.PayReq;

import java.math.BigDecimal;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bw.movie.mvp.model.utils.MD5.MD5;

public class BuyTicketActivity extends AppCompatActivity implements IPayView, IShopOrderView {

    @BindView(R.id.jie_suan)
    ImageView jieSuan;
    @BindView(R.id.seatView)
    SeatTable seatView;
    @BindView(R.id.q)
    TextView q;
    @BindView(R.id.seat_price)
    TextView seatPrice;
    @BindView(R.id.qu_xiao)
    ImageView quXiao;
    @BindView(R.id.re)
    RelativeLayout re;
    private CinemaInfoPresent cinemaInfoPresent;
    private SeatTable seatTableView;
    private PayPresent payPresent;
    private String orderId;
    private int code = 1;
    private RadioGroup pay_group;
    private Button but_jiesaun;

    private ArrayList<String> selectedSeat;
    private double fare;
    private double f1;
    private int id;
    private ShopOrderPresent shopOrderPresent;
    private int scheduleId;
    private RadioButton weixin_btn;
    private RadioButton zhifubao_btn;
    private int amount;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
        ButterKnife.bind(this);
        seatTableView = findViewById(R.id.seatView);
        Intent intent = getIntent();
        scheduleId = intent.getIntExtra("paiid", 0);//id
        fare = intent.getDoubleExtra("fare", 0);//价钱
        initData();
        initView();




    }

    private void initView() {

        //支付
        payPresent = new PayPresent(this);

        //购票下单
        shopOrderPresent = new ShopOrderPresent(this);


    }


    //影院选座
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initData() {

        seatTableView.setTransitionName("8号厅荧幕");//设置屏幕名称
        seatTableView.setMaxSelected(5);//设置最多选中

        seatTableView.setSeatChecker(new SeatTable.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
                if (column == 2) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if (row == 6 && column == 6) {
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {

                onClickLisenter();
            }

            @Override
            public void unCheck(int row, int column) {

                onClickLisenter();
            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

        });
        seatTableView.setData(7, 8);

    }


    private void onClickLisenter() {

        selectedSeat = seatTableView.getSelectedSeat();
        if (selectedSeat.size() == 0) {
            seatPrice.setText("0.00");
            f1 = 0;
            return;
        }
        int size = selectedSeat.size();
        double  price = 0;
        for (int i = 0; i < size; i++) {
            price += fare;
        }
        BigDecimal bg = new BigDecimal(price);
        f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        seatPrice.setText(f1 + "");
    }




    @OnClick({R.id.jie_suan, R.id.qu_xiao})
    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.jie_suan:
                if (f1==0){
                    Toast.makeText(this, "亲，您还没有选座哦", Toast.LENGTH_SHORT).show();
                    return;
                }
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.zhifu_layout, null);
                pay_group = view.findViewById(R.id.Pay_Radio_group);
                weixin_btn = view.findViewById(R.id.weixin_btn);
                zhifubao_btn = view.findViewById(R.id.zhifubao_btn);
                but_jiesaun = view.findViewById(R.id.tijiao);

                but_jiesaun.setText("微信支付" + f1 + "元");
                PopupWindow window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 600);
                window.setFocusable(true);

                ColorDrawable dw = new ColorDrawable(0xffffffff);
                window.setBackgroundDrawable(dw);

                window.setAnimationStyle(R.style.PopupAnimation);
                window.showAtLocation(BuyTicketActivity.this.findViewById(R.id.jie_suan), Gravity.BOTTOM, 0, 0);
                window.setBackgroundDrawable(new ColorDrawable(0x00000000));// 设置背景透明
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));




                but_jiesaun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                        int userId = user.getInt("userId", 0);
                        if (userId==0){
                            Toast.makeText(BuyTicketActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        ArrayList<String> selectedSeat = seatTableView.getSelectedSeat();
                        amount = selectedSeat.size();
                        String sourceStr = userId +""+ scheduleId +""+ amount + "movie";
                        final String sign = MD5(sourceStr);


                        if (weixin_btn.isChecked()) {
                            zhifubao_btn.setChecked(false);
                            code=1;
                            but_jiesaun.setText("微信支付" + f1 + "元");
                            shopOrderPresent.getShopOrder(scheduleId,amount,sign);
                            Log.i("message", "onClick: ======"+sign);

                        } else if (zhifubao_btn.isChecked()) {
                            code =2;
                            but_jiesaun.setText("支付宝支付" + f1 + "元");

                            weixin_btn.setChecked(false);
                        }

                    }
                });


                break;

            case R.id.qu_xiao:

                break;

        }

    }


    //购票下单
    @Override
    public void success(IndentBean indentBean) {

        Log.i("message", "success: ===" + indentBean.getMessage());
        orderId = indentBean.getOrderId();
        payPresent.getPay(code,orderId);
    }


    //微信支付
    @Override
    public void success(PayBean payBean) {
        Log.i("message", "WeiPaysuccess: ===="+payBean.getMessage());

        if (payBean.getStatus().equals("0000")) {
            //创建支付请求
            PayReq payReq = new PayReq();

            String appId = payBean.getAppId();//appId
            String partnerId = payBean.getPartnerId();//商户号
            String prepayId = payBean.getPrepayId();//支付凭证
            String nonceStr = payBean.getNonceStr();//随机字符串
            String timeStamp = payBean.getTimeStamp();//时间戳
            String sign = payBean.getSign();//签名
            String packageValue = payBean.getPackageValue();//扩展字段

            payReq.appId = appId;
            payReq.partnerId = partnerId;
            payReq.prepayId = prepayId;
            payReq.nonceStr = nonceStr;
            payReq.timeStamp = timeStamp;
            payReq.sign = sign;
            payReq.packageValue = packageValue;

            Myapp.mWxApi.sendReq(payReq);

        }else{
            Toast.makeText(this, "配置错误", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void Error(String msg) {

    }
}


