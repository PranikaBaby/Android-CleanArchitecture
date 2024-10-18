package com.yourpackage.mvp;

import javax.inject.Inject;
import io.reactivex.Observable;
import java.util.List;

public class GetPlaygrounds extends BaseUseCase {
    private final PlaygroundRepository mPlaygroundRepository;

    @Inject
    public GetPlaygrounds(@NonNull PlaygroundRepository playgroundRepository) {
        mPlaygroundRepository = playgroundRepository;
    }

    public Observable<List<Playground>> execute(boolean refresh) {
        return mPlaygroundRepository.getPlaygrounds(refresh)
                .compose(applySchedulers());
    }
}
