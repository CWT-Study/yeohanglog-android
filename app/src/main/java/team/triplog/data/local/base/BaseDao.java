package team.triplog.data.local.base;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;

public class BaseDao<T extends RealmModel> {
    protected Realm realm;

    public BaseDao(Realm realm) {
        this.realm = realm;
    }

    protected LiveRealmData<T> asLiveData(RealmResults<T> data) {
        return new LiveRealmData<>(data);
    }

}