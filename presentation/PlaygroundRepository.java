package com.yourpackage.mvp;

import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Observable;
import java.util.List;

@Singleton
public class PlaygroundRepository extends Repository {

    @Inject
    public PlaygroundRepository() {
    }

    public Observable<List<Playground>> getPlaygrounds(boolean refresh) {
        if (refresh) {
            return fetchPlaygroundsFromNetwork();
        } else {
            return fetchPlaygroundsFromCache();
        }
    }

    private Observable<List<Playground>> fetchPlaygroundsFromNetwork() {
        // Implementation for fetching from network
        // Return an Observable with data
        return Observable.just(List.of(new Playground("Park"), new Playground("Playground"))); // Example data
    }

    private Observable<List<Playground>> fetchPlaygroundsFromCache() {
        // Implementation for fetching from cache
        // Return an Observable with data
        return Observable.just(List.of(new Playground("Cached Park"), new Playground("Cached Playground"))); // Example data
    }
}
