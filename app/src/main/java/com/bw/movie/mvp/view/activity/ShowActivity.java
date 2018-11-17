package com.bw.movie.mvp.view.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.mvp.view.apdater.FilmApdater;
import com.bw.movie.mvp.view.apdater.MyForseApdater;
import com.bw.movie.mvp.view.apdater.MyStageApdater;
import com.bw.movie.mvp.model.bean.DetailMovie;
import com.bw.movie.mvp.model.bean.FilmBean;
import com.bw.movie.mvp.present.DetaPresent;
import com.bw.movie.mvp.present.FilmPresent;
import com.bw.movie.mvp.view.IView.IDetaView;
import com.bw.movie.mvp.view.IView.IFilmView;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import io.reactivex.annotations.Nullable;

public class ShowActivity extends AppCompatActivity implements IDetaView, IFilmView {

    @BindView(R.id.iv_deta_image)
    SimpleDraweeView ivDetaImage;
    @BindView(R.id.movie_name)
    TextView movieName;
    @BindView(R.id.tv_deta_name)
    TextView tvDetaName;
    @BindView(R.id.iv_deta_heart)
    ImageView ivDetaHeart;
    @Nullable
    @BindView(R.id.Film_Recylcer_View)
    RecyclerView FilmRecylcerView;
    @BindView(R.id.frament)
    FrameLayout frament;
    private DetaPresent detaPresent;
    private PopupWindow popupWindow;
    private SimpleDraweeView simp_xView;
    private TextView text_biaoaction;
    private TextView text_leiaction;
    private TextView text_daoaction;
    private TextView text_timeaction;
    private TextView text_addressaction;
    private TextView text_jianjie;
    private TextView text_nameaction;
    private RecyclerView rece_phont;
    private DetailMovie.ResultBean bean;
    private RecyclerView StagePecylcerView;
    private RecyclerView forse_Recycler_View;
    private boolean guanzhu = false;
    private String TAG = new String();
    private List<FilmBean.ResultBean> filmBeanResult;
    private FilmPresent filmPresent;
    //private List<DetailMovie.ResultBean> list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);

        //EventBus.getDefault().register(this);
        inidData();


        /**
         * 关注
         *
         * */
        ivDetaHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == ivDetaHeart) {
                    if (guanzhu) {

                        ivDetaHeart.setImageResource(R.drawable.guanzhu);
                    } else {
                        ivDetaHeart.setImageResource(R.drawable.guanzhu1);
                    }

                    guanzhu = !guanzhu;
                }
            }
        });

    }

    /**
     * 详情
     */
    @Override
    public void success(DetailMovie detailMovie) {

        bean = detailMovie.getResult();
        ivDetaImage.setImageURI(bean.getImageUrl());
        movieName.setText(bean.getName());

    }

    @Override
    public void onBackPressed() {

        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    /**
     * EventBus的接收方法
     *
     * @param context 传递类
     */
  /*  @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getEvent(DetailMovie detailMovie){

        Log.i("aaa",detailMovie.getResult().getId()+"eventid");
    }*/
    private void inidData() {
        int id = getIntent().getIntExtra("id", 0);

        detaPresent = new DetaPresent(this);
        detaPresent.getDetaMovie(id);

        filmPresent = new FilmPresent(this);
        filmPresent.getFilm(1, 1, 15);
    }

    @OnClick({R.id.deta_rb_1, R.id.deta_rb_2, R.id.deta_rb_3, R.id.deta_rb_4, R.id.back, R.id.shop_buytick})
    public void onClickView(View v) {

        switch (v.getId()) {
            case R.id.deta_rb_1:
                showPopwindow();//详情
               /*if(popupWindow==null){
                   Log.i("aaa","initDeta()");
                }else {
                    Toast.makeText(this, "没有popupWindow", Toast.LENGTH_SHORT).show();
                }*/
                break;
            case R.id.deta_rb_2:
                initForesShwo();//预告
                break;
            case R.id.deta_rb_3:

                showStagePhoto();//剧照
                break;
            case R.id.deta_rb_4:

                initfilm();//影评
                break;
            case R.id.back:
                finish();
                break;
            case R.id.shop_buytick:
                break;
        }
    }

    /**
     * 影评
     */
    private void initfilm() {

        Log.i("initfilm", "initfilm: ===" + filmBeanResult.size());

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.show_pop_film, null);

        FilmRecylcerView=view.findViewById(R.id.Film_Recylcer_View);
        FilmRecylcerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        FilmRecylcerView.setAdapter(new FilmApdater(this, filmBeanResult));
        PopupWindow window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 1000);
        window.setFocusable(true);

        ColorDrawable dw = new ColorDrawable(0xffffffff);
        window.setBackgroundDrawable(dw);

        window.setAnimationStyle(R.style.PopupAnimation);
        window.showAtLocation(ShowActivity.this.findViewById(R.id.deta_rb_1), Gravity.BOTTOM, 0, 0);

    }

    private void initForesShwo() {

        List<DetailMovie.ResultBean.ShortFilmListBean> shortFilmList = bean.getShortFilmList();
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.show_fores, null);
        forse_Recycler_View = view.findViewById(R.id.forse_Recycler_View);

        forse_Recycler_View.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        forse_Recycler_View.setAdapter(new MyForseApdater(this, shortFilmList));

        PopupWindow window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 1000);
        window.setFocusable(true);

        ColorDrawable dw = new ColorDrawable(0xffffffff);
        window.setBackgroundDrawable(dw);

        window.setAnimationStyle(R.style.PopupAnimation);
        window.showAtLocation(ShowActivity.this.findViewById(R.id.deta_rb_1), Gravity.BOTTOM, 0, 0);
    }

    private void showStagePhoto() {
        List<String> posterList = bean.getPosterList();
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popu_deta_stagephoto, null);

        StagePecylcerView = view.findViewById(R.id.Stage_Pecylcer_View);
        StagePecylcerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        StagePecylcerView.setAdapter(new MyStageApdater(ShowActivity.this, posterList));

        PopupWindow window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 1000);
        window.setFocusable(true);

        ColorDrawable dw = new ColorDrawable(0xffffffff);
        window.setBackgroundDrawable(dw);

        window.setAnimationStyle(R.style.PopupAnimation);
        window.showAtLocation(ShowActivity.this.findViewById(R.id.deta_rb_1), Gravity.BOTTOM, 0, 0);


    }


    boolean mIsShowing = false;

    /**
     * 详情
     */
    private void showPopwindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popu_deta, null);
        simp_xView = view.findViewById(R.id.simp_xView);
        text_biaoaction = view.findViewById(R.id.text_biaoaction);
        text_leiaction = view.findViewById(R.id.text_leiaction);
        text_daoaction = view.findViewById(R.id.text_daoaction);
        text_timeaction = view.findViewById(R.id.text_timeaction);
        text_addressaction = view.findViewById(R.id.text_addressaction);
        text_jianjie = view.findViewById(R.id.text_jianjie);
        text_nameaction = view.findViewById(R.id.text_nameaction);
        PopupWindow window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 1200);
        window.setFocusable(true);

        ColorDrawable dw = new ColorDrawable(0xffffffff);
        window.setBackgroundDrawable(dw);

        window.setAnimationStyle(R.style.PopupAnimation);
        window.showAtLocation(ShowActivity.this.findViewById(R.id.deta_rb_1), Gravity.BOTTOM, 0, 0);

        String[] spls = bean.getImageUrl().split("\\|");
        Uri parse1 = Uri.parse(spls[0]);
        simp_xView.setImageURI(parse1);

        tvDetaName.setText(bean.getName());

        text_biaoaction.setText(bean.getName());
        text_leiaction.setText("类型：" + bean.getMovieTypes());

        text_daoaction.setText("导演：" + bean.getDirector());
        text_timeaction.setText("时长：" + bean.getDuration());
        text_addressaction.setText("产地：" + bean.getPlaceOrigin());
        text_jianjie.setText(bean.getSummary());
        text_nameaction.setText(bean.getStarring());
    }


    private void initDeta() {

        View inflate = View.inflate(this, R.layout.popu_deta, null);
        popupWindow = new PopupWindow(inflate, 200, 300);
        popupWindow.setContentView(inflate);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);

        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));

        popupWindow.setAnimationStyle(R.animator.menu_bottombar_in);
        mIsShowing = false;
    }


    /**
     * @param filmBean 影评
     */
    @Override
    public void success(FilmBean filmBean) {

        filmBeanResult = filmBean.getResult();
        Log.i("aaa", "success: ====" + filmBeanResult.size());
    }

    @Override
    public void Error(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
