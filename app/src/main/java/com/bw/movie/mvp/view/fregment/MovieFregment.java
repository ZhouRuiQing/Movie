package com.bw.movie.mvp.view.fregment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.mvp.view.apdater.ComingApdater;
import com.bw.movie.mvp.view.apdater.MovieApdater;
import com.bw.movie.mvp.view.apdater.MovieFindApdater;
import com.bw.movie.mvp.view.apdater.MyApdater;
import com.bw.movie.mvp.model.bean.ComingMovie;
import com.bw.movie.mvp.model.bean.MovieFindinfo;
import com.bw.movie.mvp.model.bean.Movieinfo;
import com.bw.movie.mvp.present.ComingPresent;
import com.bw.movie.mvp.present.FindPresent;
import com.bw.movie.mvp.present.HotMoviePresent;
import com.bw.movie.mvp.view.IView.IComingView;
import com.bw.movie.mvp.view.IView.IFindView;
import com.bw.movie.mvp.view.IView.IHotMvoieView;
import com.bw.movie.mvp.view.activity.MapActivity;
import com.bw.movie.mvp.view.activity.TablayoutActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFregment extends Fragment implements IHotMvoieView, IFindView, IComingView {


    /*  @BindView(R.id.simp_viewgs)
      SimpleDraweeView simpViewgs;
      @BindView(R.id.view_pagerone)
      ViewPager viewPagerone;*/
  /*  @BindView(R.id.linLayout)
    RelativeLayout linLayout;*/
    Unbinder unbinder;
    @BindView(R.id.hot_Recycler_View)
    RecyclerView hotRecyclerView;
    @BindView(R.id.find_Recycler_View)
    RecyclerView findRecyclerView;
    @BindView(R.id.Coming_Recycler_View)
    RecyclerView ComingRecyclerView;
    @BindView(R.id.map)
    ImageView map;
    @BindView(R.id.list)
    RecyclerCoverFlow list;
    @BindView(R.id.linLayout)
    RelativeLayout linLayout;
    @BindView(R.id.tv_movie_hot)
    TextView tvMovieHot;
    @BindView(R.id.tv_movie_find)
    TextView tvMovieFind;
    @BindView(R.id.tv_movie_Coming)
    TextView tvMovieComing;
    @BindView(R.id.tv_city)
    TextView tvCity;
    private HotMoviePresent present;
    private FindPresent findPresent;
    private ComingPresent comingPresent;
    private RecyclerCoverFlow mList;
    private MovieFindApdater findapdater;
    private List<String> slist = new ArrayList<>();
    private int page=0;

    public MovieFregment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_movie_fregment, container, false);
        initData();
        mList = inflate.findViewById(R.id.list);
        unbinder = ButterKnife.bind(this, inflate);
        //进入地图
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MapActivity.class);
                startActivity(intent);
            }
        });
        //进入热门电影
        tvMovieHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TablayoutActivity.class));
            }
        });
        //进入正在上映
        tvMovieFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TablayoutActivity.class));
                if(page==0){
                    EventBus.getDefault().post(page);
                }

            }
        });
        //进入即将上映
        tvMovieComing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TablayoutActivity.class));
            }
        });
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        EventBus.getDefault().register(this);
    }

    //初始化数据
    private void initData() {
        //热门电影
        present = new HotMoviePresent(this);
        present.getHoMovie(1, 20);
        //正在上映
        findPresent = new FindPresent(this);
        findPresent.getFindMovie(1, 20);
        //即将上映
        comingPresent = new ComingPresent(this);
        comingPresent.getComingMovie(1, 20);


    }



    @Override//热门电影
    public void success(Movieinfo movieinfo) {

        List<Movieinfo.ResultBean> list = movieinfo.getResult();
        // oneViewger(list);
        HotMovie(list);


    }

    private void HotMovie(List<Movieinfo.ResultBean> list) {

     /*   for (Movieinfo.ResultBean resultBean : list) {
            String imageUrl = resultBean.getImageUrl();
            slist.add(imageUrl);
        }*/

        final MovieApdater movieApdater = new MovieApdater(getActivity(), list);
        mList.setAdapter(movieApdater);
        mList.scrollToPosition(294);
        movieApdater.setListener(new MovieFindApdater.RecyclerItemListener() {
            @Override
            public void onClick(int position) {
                mList.scrollToPosition(position);
            }
        });
        mList.getSelectedPos();

        inithot(list);
    }

    private void inithot(List<Movieinfo.ResultBean> list) {
        MyApdater apdater = new MyApdater(getActivity(), list);
        hotRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1, LinearLayoutManager.HORIZONTAL, false));
        hotRecyclerView.setAdapter(apdater);
    }

   /* private void oneViewger(final List<Movieinfo.ResultBean> list) {
        viewPagerone.setAdapter(new MyHuaAdapter(list, getActivity()));
        viewPagerone.setPageMargin(20);
        viewPagerone.setOffscreenPageLimit(list.size());
        //设置画廊模式
        viewPagerone.setPageTransformer(true, new ViewpageTransformer());
        //左右都有图
        viewPagerone.setCurrentItem(list.size());

        //viewpager左右两边滑动无效的处理
        linLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPagerone.dispatchTouchEvent(event);
            }
        });

        String imageUrl = list.get(0).getImageUrl();
        showUrlBlur(imageUrl);
        viewPagerone.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                String imageUrl = list.get(position).getImageUrl();
                showUrlBlur(imageUrl);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }*/

    /**
     * @param imageUrl 高斯模糊
     */
   /* private void showUrlBlur(String imageUrl) {
        try {
            Uri uri = Uri.parse(imageUrl);
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                    .setPostprocessor(new IterativeBoxBlurPostProcessor(2, 30))
                    .build();
            AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setOldController(simpViewgs.getController())
                    .setImageRequest(request)
                    .build();

            simpViewgs.setController(controller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    //正在上映
    @Override
    public void success(MovieFindinfo movieFindinfo) {
        final List<MovieFindinfo.ResultBean> list = movieFindinfo.getResult();
       /* for (MovieFindinfo.ResultBean resultBean : list) {
            String imageUrl = resultBean.getImageUrl();
            slist.add(imageUrl);
        }*/
        // mList.setFlatFlow(true); //平面滚动



       /*findapdater.setListener(new MovieFindApdater.RecyclerItemListener() {
            @Override
            public void onClick(int position) {
                mList.scrollToPosition(position);
            }
        });*/
        initfind(list);

    }

    private void initfind(List<MovieFindinfo.ResultBean> list) {
        findapdater = new MovieFindApdater(getActivity(), list);
        findRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1, LinearLayoutManager.HORIZONTAL, false));
        findRecyclerView.setAdapter(findapdater);
    }

    //即将上映
    @Override
    public void Sueecss(ComingMovie comingMovie) {
        List<ComingMovie.ResultBean> list = comingMovie.getResult();
        initComing(list);
    }

    private void initComing(List<ComingMovie.ResultBean> list) {
        ComingApdater apdater = new ComingApdater(getActivity(), list);
        ComingRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1, LinearLayoutManager.HORIZONTAL, false));
        ComingRecyclerView.setAdapter(apdater);
    }

    @Override
    public void Error(String msg) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(String city) {

        tvCity.setText(city);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

}
