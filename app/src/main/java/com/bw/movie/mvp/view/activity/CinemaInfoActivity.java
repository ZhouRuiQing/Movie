package com.bw.movie.mvp.view.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.ByCinemaBean;
import com.bw.movie.mvp.model.bean.CinemaInfoBean;
import com.bw.movie.mvp.model.bean.CommentBean;
import com.bw.movie.mvp.model.bean.MovieFindinfo;
import com.bw.movie.mvp.model.bean.ScheduleBean;
import com.bw.movie.mvp.present.ByCinemaPresent;
import com.bw.movie.mvp.present.CinemaInfoPresent;
import com.bw.movie.mvp.present.CommentPresent;
import com.bw.movie.mvp.present.FindPresent;
import com.bw.movie.mvp.present.SchedulePresent;
import com.bw.movie.IView.IByCinmeaView;
import com.bw.movie.IView.ICineminInfo;
import com.bw.movie.IView.ICommentView;
import com.bw.movie.IView.IFindView;
import com.bw.movie.IView.IMovieSchedule;
import com.bw.movie.mvp.view.apdater.CinemaApdater;
import com.bw.movie.mvp.view.apdater.CommentAdapter;
import com.bw.movie.mvp.view.apdater.SchduleApdater;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

public class CinemaInfoActivity extends AppCompatActivity implements ICineminInfo, IFindView, ICommentView, IMovieSchedule,IByCinmeaView {

    @BindView(R.id.iv_cinema_image)
    ImageView ivCinemaImage;
    @BindView(R.id.tv_cinema_name)
    TextView tvCinemaName;
    @BindView(R.id.tv_cinema_title)
    TextView tvCinemaTitle;
    @BindView(R.id.cinemas_RecyclerCover_Flow)
    RecyclerCoverFlow mlist;
    @BindView(R.id.cinemas_back)
    ImageView cinemasBack;
    @BindView(R.id.cinema_Relative_Layout)
    RelativeLayout cinemaRelativeLayout;
    @BindView(R.id.Schedule_recylcer_View)
    RecyclerView ScheduleRecylcerView;
    private CinemaInfoPresent cinemaInfoPresent;
    private String TAG = new String();
    private FindPresent findPresent;
    private TabLayout tab_cinemainfo;
    private ViewPager vp_cinemainfo;

    private RadioButton rb2Cinemainfo;
    private RadioButton rb1Cinemainfo;
    private RadioGroup radio_group;
    private FrameLayout frament;
    private PopupWindow mPopWindow;
    private TextView tv1, tv2, tv3, two, one;
    private String phone, addr, lu;
    private LinearLayout lin_one, lin_two;
    private ImageView one_img, two_img;
    private RecyclerView recycler_view;
    private LinearLayoutManager linearLayoutManager;
    private CommentAdapter commentAdapter;
    private int id;
    private List<CommentBean.ResultBean> list;
    private CommentPresent commentPresent;
    private SchedulePresent schedulePresent;
    private int movieid=4;
    private ByCinemaPresent byCinemaPresent;
    private List<ByCinemaBean.ResultBean> byCinemalist=new ArrayList<>();
    private double fare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_info);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        initView();
        initData();
    }


    private void initData() {

        /**
         * 点击返回
         * */
        cinemasBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        /**
         * 点击弹出popupwindow
         * */
        cinemaRelativeLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                //创建布局
                View contentView = LayoutInflater.from(CinemaInfoActivity.this).inflate(R.layout.popwindow, null);
                mPopWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, 700, true);
                mPopWindow.setAnimationStyle(R.style.PopupAnimation);
                //设置各个控件的点击响应
                tv1 = contentView.findViewById(R.id.juti_dizi);
                tv2 = contentView.findViewById(R.id.juti_dainhua);
                tv3 = contentView.findViewById(R.id.juti_chengcheluxian);
                one = contentView.findViewById(R.id.one);
                lin_one = contentView.findViewById(R.id.lin_one);
                lin_two = contentView.findViewById(R.id.lin_two);
                one_img = contentView.findViewById(R.id.one_img);
                two_img = contentView.findViewById(R.id.two_img);

                commentAdapter = new CommentAdapter(CinemaInfoActivity.this, list);
                linearLayoutManager = new LinearLayoutManager(CinemaInfoActivity.this, LinearLayoutManager.VERTICAL, false);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recycler_view = contentView.findViewById(R.id.recycler_view);
                recycler_view.setLayoutManager(linearLayoutManager);
                recycler_view.setAdapter(commentAdapter);


                two = contentView.findViewById(R.id.two);
                two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        one_img.setVisibility(View.GONE);
                        two_img.setVisibility(View.VISIBLE);
                        lin_one.setVisibility(View.GONE);
                        lin_two.setVisibility(View.VISIBLE);
                    }
                });
                one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        two_img.setVisibility(View.GONE);
                        one_img.setVisibility(View.VISIBLE);
                        lin_one.setVisibility(View.VISIBLE);
                        lin_two.setVisibility(View.GONE);
                    }
                });
                tv1.setText(addr);
                tv2.setText(phone);
                tv3.setText(lu);
                //当点击popwindow以外的地方关闭窗口
                mPopWindow.setBackgroundDrawable(new BitmapDrawable());
                mPopWindow.setOutsideTouchable(true);
                //本activity的布局
                View rootview = LayoutInflater.from(CinemaInfoActivity.this).inflate(R.layout.activity_cinema_info, null);
                //显示的位置
                mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);

            /*    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.popwindow,null);


                PopupWindow window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 800);
                window.setFocusable(true);

                ColorDrawable dw = new ColorDrawable(0xffffffff);
                window.setBackgroundDrawable(dw);

                window.setAnimationStyle(R.style.PopupAnimation);
                window.showAtLocation(CinemaInfoActivity.this.findViewById(R.id.cinema_Relative_Layout), Gravity.BOTTOM, 0, 0);

                radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId){

                            case R.id.rb_1_cinemainfo:
                                Changpager(new DetailsFragment());
                                break;
                            case R.id.rb_2_cinemainfo:
                                Changpager(new ReViewFragment());
                                break;

                        }

                    }
                });
                Changpager(new DetailsFragment());*/
            }
        });
    }

    private void Changpager(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.frament, fragment).commit();

    }

    private void initView() {

         //影院详情
        cinemaInfoPresent = new CinemaInfoPresent(this);
        cinemaInfoPresent.getCinmeas(id);


        //影院评论
        commentPresent = new CommentPresent(this);
        commentPresent.getCinmeas(id, 1, 55);


        findPresent = new FindPresent(this);
        findPresent.getFindMovie(1, 20);

        //电影票
        schedulePresent = new SchedulePresent(this);



        //根据影院ID查询该影院当前排期的电影列表
        byCinemaPresent = new ByCinemaPresent(this);
        byCinemaPresent.getBycinemas(id);
    }

    /**
     * @param cinemaInfoBean //影院详情
     */

    @Override
    public void success(CinemaInfoBean cinemaInfoBean) {

        Log.i(TAG, "success: ====" + cinemaInfoBean.getResult().getAddress());
        CinemaInfoBean.ResultBean bean =  cinemaInfoBean.getResult();

        Glide.with(this)
                .load(bean.getLogo())
                .into(ivCinemaImage);
        tvCinemaName.setText(bean.getName());
        tvCinemaTitle.setText(bean.getAddress());

        phone = cinemaInfoBean.getResult().getPhone();
        addr = cinemaInfoBean.getResult().getAddress();
        lu = cinemaInfoBean.getResult().getVehicleRoute();
    }

    /**
     * @param正在上映
     */

    @Override
    public void success(MovieFindinfo movieFindinfo) {

    }

    @Override
    public void success(CommentBean commentBean) {


        if(commentBean.getResult()==null){
            Toast.makeText(this, "该影院没有上映的电影", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            list = commentBean.getResult();
        }
        //Log.i("CommentBean", "success: ==="+commentBean.getResult().size());
    }


    //电影票的价格及时间
    @Override
    public void success(ScheduleBean scheduleBean) {

        List<ScheduleBean.ResultBean> list = scheduleBean.getResult();
        ScheduleRecylcerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ScheduleRecylcerView.setAdapter(new SchduleApdater(this,list,fare));

    }

    @Override
    public void success(ByCinemaBean byCinemaBean) {

        byCinemalist = byCinemaBean.getResult();
        //Log.i("IBysuccess", "IBysuccess: ====="+byCinemalist.size());

        if(byCinemalist==null){
            Toast.makeText(this, "该影院没有上映的电影", Toast.LENGTH_SHORT).show();
            finish();
        }else {

            //
            CinemaApdater cinemapdater = new CinemaApdater(this,byCinemalist);
            mlist.scrollToPosition(3);
            fare = byCinemalist.get(0).getFare();
            schedulePresent.getAllCinemas(id,16);
            mlist.getSelectedPos();
            mlist.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
                @Override
                public void onItemSelected(int position) {
                    int movieidd = byCinemalist.get(position).getId();
                    Log.i("movieid", "onClick: ====="+movieidd);
                    schedulePresent.getAllCinemas(id,movieidd);
                    fare = byCinemalist.get(position).getFare();
                }
            });
            mlist.setAdapter(cinemapdater);

            cinemapdater.notifyDataSetChanged();
        }

    }

    @Override
    public void Error(String msg) {

    }
}
