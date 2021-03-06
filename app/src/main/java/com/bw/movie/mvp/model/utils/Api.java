package com.bw.movie.mvp.model.utils;


import com.bw.movie.mvp.model.bean.AddConmmentBean;
import com.bw.movie.mvp.model.bean.AllCinemasBean;
import com.bw.movie.mvp.model.bean.AttenBean;
import com.bw.movie.mvp.model.bean.AttenCinemaBean;
import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.mvp.model.bean.ByCinemaBean;
import com.bw.movie.mvp.model.bean.ChageTouBean;
import com.bw.movie.mvp.model.bean.CinemaInfoBean;
import com.bw.movie.mvp.model.bean.ComingMovie;
import com.bw.movie.mvp.model.bean.CommentBean;
import com.bw.movie.mvp.model.bean.DetailMovie;
import com.bw.movie.mvp.model.bean.FeedBackBean;
import com.bw.movie.mvp.model.bean.FilmBean;
import com.bw.movie.mvp.model.bean.FindCinemesBean;
import com.bw.movie.mvp.model.bean.IndentBean;
import com.bw.movie.mvp.model.bean.ModifyPwdBean;
import com.bw.movie.mvp.model.bean.MovieFindinfo;
import com.bw.movie.mvp.model.bean.Movieinfo;
import com.bw.movie.mvp.model.bean.PayBean;
import com.bw.movie.mvp.model.bean.RegBean;
import com.bw.movie.mvp.model.bean.ScheduleBean;
import com.bw.movie.mvp.model.bean.UnflowwBean;
import com.bw.movie.mvp.model.bean.UserBean;
import com.bw.movie.mvp.model.bean.UserBuyTicketBean;
import com.bw.movie.mvp.model.bean.WeEBean;
import com.facebook.cache.disk.DefaultDiskStorage;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
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
    Observable<CommentBean> getComment(@Query("cinemaId") int cinemaId,@Query("page") int page,@Query("count") int count);    //添加用户评论
    @POST("movieApi/movie/v1/verify/movieComment")
    Observable<AddConmmentBean> getAddConmment(@Field("movieId") int movieId, @Field("commentContent") String commentContent);
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

    //修改密码
    @FormUrlEncoded
    @POST("movieApi/user/v1/verify/modifyUserPwd")
    Observable<ModifyPwdBean> getModifyPwd(@FieldMap HashMap<String, String> map);

    //上传头像
    @FormUrlEncoded
    @POST("http://172.17.8.100/movieApi/user/v1/verify/uploadHeadPic")
    Observable<ChageTouBean> getChageTou(@DefaultDiskStorage.FileType MultipartBody.Part file);


//    //用户购票记录查询列表
//    @GET("movieApi/user/v1/verify/findUserBuyTicketRecordList")
//    Observable<UserBuyBean> getUserBuy(@Query("page") int page,@Query("count") int count);

    //关注电影
    @GET("movieApi/movie/v1/verify/followMovie")
    Observable<AttenBean> getAtten(@Query("movieId") int movieId);

    //取消关注电影
    @GET("http://172.17.8.100/movieApi/movie/v1/verify/cancelFollowMovie")
    Observable<UnflowwBean> getUnfloww(@Query("movieId") int movieId);

    //我的关注电影
    @GET("movieApi/movie/v1/verify/findMoviePageList")
    Observable<AttenMovieBean> getAttenMovie(@Query("page") int page,@Query("count") int count);

    //关注影院
    @GET("movieApi/cinema/v1/verify/followCinema")
    Observable<AttenBean> getAttenCinema(@Query("cinemaId") int cinemaId);

    //取消关注影院
    @GET("movieApi/cinema/v1/verify/cancelFollowCinema")
    Observable<AttenMovieBean> getUnAttenCinema(@Query("cinemaId") int cinemaId);

    //关注的影院
    //取消关注影院
    @GET("movieApi/cinema/v1/verify/findCinemaPageList")
    Observable<AttenCinemaBean> getCinemaAtten(@Query("page") int page,@Query("count") int count);

    //微信登录
    @FormUrlEncoded
    @POST("movieApi/user/v1/weChatBindingLogin")
    Observable<WeEBean> getWeiE(@Field("code") String code);

    //微信支付
    @FormUrlEncoded
    @POST("movieApi/movie/v1/verify/pay")
    Observable<PayBean> getPay(@Field("payType") int payType,@Field("orderId") String orderId);

    //购票下单
    @FormUrlEncoded
    @POST("movieApi/movie/v1/verify/buyMovieTicket")
    Observable<IndentBean> getShopOrder(@Field("scheduleId") int scheduleId, @Field("amount") int amount, @Field("sign") String sign);

   //用户购票记录查询
    @GET("movieApi/user/v1/verify/findUserBuyTicketRecordList")
    Observable<UserBuyTicketBean> getUserBuyTicket(@Query("page") int page, @Query("count") int count);

    //意见反馈
    @FormUrlEncoded
    @POST("movieApi/tool/v1/verify/recordFeedBack")
    Observable<FeedBackBean> getfeedback(@Field("content") String content);
}
