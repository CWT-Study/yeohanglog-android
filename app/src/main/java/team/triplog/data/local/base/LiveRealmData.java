package team.triplog.data.local.base;

import androidx.lifecycle.LiveData;

import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import io.realm.RealmResults;

public class LiveRealmData<T extends RealmModel> extends LiveData<RealmResults<T>> {

    private RealmResults<T> results;

    private final RealmChangeListener<RealmResults<T>> listener = this::setValue;

    public LiveRealmData(RealmResults<T> realmResults) {
        results = realmResults;
        setValue(realmResults);
    }

    @Override
    protected void onActive() {
        System.out.println("LiveRealmData.onActive(): " + results);
        results.addChangeListener(listener);
    }

    @Override
    protected void onInactive() {
        System.out.println("LiveRealmData.onInactive()");
        results.removeChangeListener(listener);
    }
}