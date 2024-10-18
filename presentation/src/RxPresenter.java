package com.yourpackage.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class RxPresenter<V extends MvpView> {
    private V view;
    private CompositeDisposable disposables = new CompositeDisposable();

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        disposables.clear();
        view = null;
    }

    protected V getView() {
        return view;
    }

    protected void addSubscription(Disposable disposable) {
        disposables.add(disposable);
    }
    
    // Method to bind to lifecycle if using a lifecycle-aware component
    // e.g., using LiveData or similar
}
