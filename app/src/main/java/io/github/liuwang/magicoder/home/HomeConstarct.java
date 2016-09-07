package io.github.liuwang.magicoder.home;


import java.util.List;

import io.github.liuwang.magicoder.BasePresenter;
import io.github.liuwang.magicoder.home.models.Result;

/**
 * Created by LiuWang on 01/09/2016.
 */
public class HomeConstarct {
    public interface IHomeView {
        void fillData(List<Result> mData);
    }

    public interface IHomePresenter extends BasePresenter {
        void loadHomeData();
    }
}
