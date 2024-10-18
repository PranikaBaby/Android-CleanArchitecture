package com.yourpackage.mvp;

import androidx.annotation.NonNull;
import java.util.List;

public interface PlaygroundView extends MvpView {
    void showLoading(boolean refresh);
    void showContent(boolean refresh, List<Playground> playgrounds);
    void showError(boolean refresh, @NonNull String message);
}
