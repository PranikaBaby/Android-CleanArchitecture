package com.yourpackage.mvp;

import javax.inject.Inject;

public class PlaygroundPresenter extends RxPresenter<PlaygroundView> {
    private final GetPlaygrounds mGetPlaygrounds;

    @Inject
    public PlaygroundPresenter(@NonNull GetPlaygrounds getPlaygrounds) {
        mGetPlaygrounds = getPlaygrounds;
    }

    public void loadPlaygrounds(boolean refresh) {
        getView().showLoading(refresh);
        mGetPlaygrounds.execute(refresh)
                .compose(bindToLifecycle())
                .subscribe(playgrounds -> {
                    getView().showContent(refresh, playgrounds);
                }, error -> {
                    Logger.e(error, "Get playgrounds failed.");
                    getView().showError(refresh, error.getMessage());
                });
    }
}
