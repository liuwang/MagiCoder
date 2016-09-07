package io.github.liuwang.magicoder.home;


import io.github.liuwang.magicoder.home.models.Home;
import io.github.liuwang.magicoder.inter.MagiCoderApi;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LiuWang on 01/09/2016.
 */
public class IHomePresenterImpl implements HomeConstarct.IHomePresenter{
    private HomeConstarct.IHomeView homeView;

    public IHomePresenterImpl(HomeConstarct.IHomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void loadHomeData() {
        MagiCoderApi service = MagiCoderApi.retrofit.create(MagiCoderApi.class);
        Observable<Home> home = service.getHomeData(5,1);
        home.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Home>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Home home) {
                        homeView.fillData(home.getResults());
                    }
                });
    }

    @Override
    public void onDestroy() {
        homeView = null;
    }
}
