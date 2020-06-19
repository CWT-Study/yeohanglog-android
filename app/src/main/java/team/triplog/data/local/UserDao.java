package team.triplog.data.local;

import io.realm.Realm;
import team.triplog.data.local.base.BaseDao;

public class UserDao extends BaseDao<User> {
    public UserDao(Realm realm) {
        super(realm);
    }
}
