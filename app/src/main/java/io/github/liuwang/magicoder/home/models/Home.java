package io.github.liuwang.magicoder.home.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuWang on 12/08/2016.
 */
public class Home {
    private Boolean error;
    private List<Result> results = new ArrayList<>();

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
