package com.bw.movie.mvp.model.utils;


import com.bw.movie.mvp.model.bean.AllCinemasBean;
import com.bw.movie.mvp.model.bean.AttenBean;
import com.bw.movie.mvp.model.bean.ByCinemaBean;
import com.bw.movie.mvp.model.bean.CinemaInfoBean;
import com.bw.movie.mvp.model.bean.ComingMovie;
import com.bw.movie.mvp.model.bean.CommentBean;
import com.bw.movie.mvp.model.bean.DetailMovie;
import com.bw.movie.mvp.model.bean.FilmBean;
import com.bw.movie.mvp.model.bean.FindCinemesBean;
import com.bw.movie.mvp.model.bean.MovieFindinfo;
import com.bw.movie.mvp.model.bean.Movieinfo;
import com.bw.movie.mvp.model.bean.RegBean;
import com.bw.movie.mvp.model.bean.ScheduleBean;
import com.bw.movie.mvp.model.bean.UnflowwBean;
import com.bw.movie.mvp.model.bean.UserBean;
import com.bw.movie.mvp.model.bean.UserBuyBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    //热门影院
    @GET("movieApi/movie/v1/findHotMovieList")
    Observable<Movieinfo> getHotMovie(@Query("page") int page, @Query("count") int count);
    //正在上映
    @GET("movieApi/movie/v1/findReleaseMovieList")
    Observable<MovieFindinfo> getFindMovie(@Query("page") int page, @Query("count") int count);
    //即将上映
    @GET("movieApi/movie/v1/findComingSoonMovieList")
    Observable<ComingMovie> getComingMovie(@Query("page") int page, @Query("count") int count);
    //电影详情
    @GET("movieApi/movie/v1/findMoviesDetail")
    Observable<DetailMovie> getDetail(@Query("movieId") int movieid);

    //查询影评
    @GET("movieApi/movie/v1/findAllMovieComment")
    Observable<FilmBean> getFlim(@Query("movieId") int movieId,@Query("page") int page,@Query("count") int count);


    //附近影院
    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<FindCinemesBean> getCinemes(@Query("page") int page, @Query("count") int count);

    //所有影院
    @GET("movieApi/cinema/v1/findAllCinemas")
    Observable<AllCinemasBean> getAllCinemeas(@Query("page") int page, @Query("count") int count);


    //影院信息详情
    @GET("movieApi/cinema/v1/findCinemaInfo")
    Observable<CinemaInfoBean> getCinemaInfo(@Query("cinemaId") int cinemaId);

    //影院详情评论
    @GET("movieApi/cinema/v1/findAllCinemaComment")
    Observable<CommentBean> getComment(@Query("cinemaId") int cinemaId,@Query("page") int page,@Query("count") int count);

    //根据影院ID查询该影院当前排期的电影列表
    @GET("http://172.17.8.100/movieApi/movie/v1/findMovieListByCinemaId")
    Observable<ByCinemaBean> getByCinemaId(@Query("cinemaId") int cinemaId);

    //影院上映的时间
    @GET("movieApi/movie/v1/findMovieScheduleList")
    Observable<ScheduleBean> getSchedule(@Query("cinemasId") int cinemasId,@Query("movieId") int movieId);

    //注册
    //, @Field("pwd2") String pwd2, @Field("sex") int sex, @Field("birthday") String birthday, @Field("email") String email
    @FormUrlEncoded
    @POST("movieApi/user/v1/registerUser")
    Observable<UserBean> getUser(@FieldMap HashMap<String, String> map);

    //登录
    @FormUrlEncoded
    @POST("movieApi/user/v1/login")
    Observable<RegBean> getReg(@FieldMap HashMap<String, String> map);

    //用户购票记录查询列表
    @GET("movieApi/user/v1/verify/findUserBuyTicketRecordList")
    Observable<UserBuyBean> getUserBuy(@Query("page") int page,@Query("count") int count);

    //关注
    @GET("movieApi/movie/v1/verify/followMovie")
    Observable<AttenBean> getAtten(@Query("movieId") int movieId);

    //取消关注
    @GET("http://172.17.8.100/movieApi/movie/v1/verify/cancelFollowMovie")
    Observable<UnflowwBean> getUnfloww(@Query("movieId") int movieId);
}
