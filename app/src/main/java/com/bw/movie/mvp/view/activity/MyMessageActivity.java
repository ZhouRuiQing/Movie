package com.bw.movie.mvp.view.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.IView.IChageView;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.ChageTouBean;
import com.bw.movie.mvp.model.utils.imageutils.ImageUtils;
import com.bw.movie.mvp.present.MineMessPresenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyMessageActivity extends AppCompatActivity implements IChageView {

    @BindView(R.id.iv_my_icon)
    ImageView ivMyIcon;
    @BindView(R.id.tv_my_name)
    TextView tvMyName;
    @BindView(R.id.tv_my_sex)
    TextView tvMySex;
    @BindView(R.id.tv_my_borhity)
    TextView tvMyBorhity;
    @BindView(R.id.tv_my_phone)
    TextView tvMyPhone;
    @BindView(R.id.reset_pwd)
    TextView resetPwd;
    @BindView(R.id.but_tui)
    Button butTui;
    private SharedPreferences user;
    private MineMessPresenter mineMessPresenter;

    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    private Uri tempUri;
    private static String path = "/sdcard/myHead/";// sd路径
    private Bitmap head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message);
        ButterKnife.bind(this);

        initData();
        initView();

        /*//由于模拟器图库的刷新问题，采用如下打开方式，实际开发请采用上面这种
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,ToolUtils.SCAN_OPEN_PHONE);
*/
        //头像上传
        ivMyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showChoosePicDialog();
            }
        });

        //修改密码
        resetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MyMessageActivity.this, ResetPwdActivity.class));
            }
        });

        //退出登录
        butTui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLogin = user.getBoolean("isLogin", true);
                if(isLogin){
                    SharedPreferences.Editor edit = user.edit();
                    edit.putBoolean("isLogin",false).commit();
                    finish();
                }
            }
        });

    }

    /**
     * 显示修改头像的对话框
     */
    protected void showChoosePicDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置头像");
        String[] items = { "选择本地照片", "拍照" };
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                        intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                        startActivityForResult(intent1, 1);
                        dialog.dismiss();
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        intent2.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(new File (Environment.getExternalStorageDirectory(), "head.jpg")));
                        startActivityForResult(intent2, 2);// 采用ForResult打开
                        dialog.dismiss();
                        break;
                }
            }
        });
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    if (resultCode == RESULT_OK) {
                        cropPhoto(data.getData());// 裁剪图片
                    }// 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    if (resultCode == RESULT_OK) {
                        File temp = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                        cropPhoto(Uri.fromFile(temp));// 裁剪图片
                    }
                    // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        Bundle extras = data.getExtras();
                        head = extras.getParcelable("data");
                        if (head != null) {
                            /**
                             * 上传服务器代码
                             */
                            setPicToView(head);// 保存在SD卡中
                            ivMyIcon.setImageBitmap(head);// 用ImageView显示出来
                        }
                    }
                    break;
            }
        }
    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    /**
     * 调用系统的裁剪功能
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }

    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState ();
        if (!sdStatus.equals (Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File (path);
        file.mkdirs ();// 创建文件夹
        String fileName = path + "head.jpg";// 图片名字
        try {
            b = new FileOutputStream (fileName);
            mBitmap.compress (Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } finally {
            try {
                // 关闭流
                b.flush ();
                b.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     *
     * @param picdata
     */
  /*  protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            mBitmap = extras.getParcelable("data");
            //这里图片是方形的，可以用一个工具类处理成圆形（很多头像都是圆形，这种工具类网上很多不再详述）
            ivMyIcon.setImageBitmap(mBitmap);//显示图片
            //在这个地方可以写上上传该图片到服务器的代码，后期将单独写一篇这方面的博客，敬请期待...
        }
    }*/

/*
    private void uploadPic(Bitmap bitmap) {
        // 上传至服务器
        // ... 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了

        String imagePath = ImageUtils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.e("imagePath", imagePath+"");
        if(imagePath != null){
            // 拿着imagePath上传了
            // ...
        }
    }
*/


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        } else {
            // 没有获取 到权限，从新请求，或者关闭app
            Toast.makeText(this, "需要存储权限", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {

        mineMessPresenter = new MineMessPresenter(this);

    }


    /**
     * 日期选择器
     */
    private void initData() {

        tvMyBorhity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MyMessageActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvMyBorhity.setText(String.format("%d-%d-%d", year, monthOfYear + 1, dayOfMonth));
                    }
                }, 2000, 1, 2).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        user = this.getSharedPreferences("user", Context.MODE_PRIVATE);

        boolean isLogin = user.getBoolean("isLogin", true);

        if (isLogin) {

            String touicon = user.getString("touicon", "");
            String name = user.getString("name", "");
            int sex = user.getInt("sex", 0);
            long birthday = user.getLong("birthday", 0);
            String phone = user.getString("phone", "");

            if (sex == 1) {
                tvMySex.setText("男");
            } else {
                tvMySex.setText("女");
            }


            Date date = new Date(birthday);
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            String databirthday = sd.format(date);

            Log.i("phone", "onResume:======= " + phone);

            Glide.with(this).load(touicon).into(ivMyIcon);
            tvMyName.setText(name);
            tvMyBorhity.setText(databirthday);
            tvMyPhone.setText(phone);


        } else {

            Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * 把毫秒转化成日期
     *
     * @param dateFormat(日期格式，例如：MM/ dd/yyyy HH:mm:ss)
     * @param millSec(毫秒数)
     * @return
     */

    private String transferLongToDate(String dateFormat, Long millSec) {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        Date date = new Date(millSec);

        return sdf.format(date);

    }


    @Override
    public void success(ChageTouBean chageTouBean) {

        Log.i("success", "success: ==="+chageTouBean.getMessage());
        if (chageTouBean.getStatus().equalsIgnoreCase("0000") && chageTouBean.getMessage().equals("上传成功")) {
            ivMyIcon.setImageURI(Uri.parse(chageTouBean.getHeadPath()));
            Toast.makeText(this, chageTouBean.getMessage(), Toast.LENGTH_SHORT).show();
            //utTui.getInstance(MyMessageActivity.this).getData().setHeadPic(chageTouBean.getHeadPath());
        } else {
            Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void Error(String msg) {

    }
}
