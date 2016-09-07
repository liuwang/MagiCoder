package io.github.liuwang.magicoder.inter;

import io.github.liuwang.magicoder.home.models.Home;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by LiuWang on 12/08/2016.
 */
public interface MagiCoderApi {
    String BASE_URL = "http://gank.io/api/";

    Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MagiCoderApi.BASE_URL)
            .build();

    /**
     * @param count
     * @return 请求主页数据
     */
    @GET("history/content/{count}/{page}")
    Observable<Home> getHomeData(@Path("count") int count, @Path("page") int page);
}
