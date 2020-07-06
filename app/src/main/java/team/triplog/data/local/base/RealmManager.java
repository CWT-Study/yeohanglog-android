package team.triplog.data.local.base;

import android.content.Context;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class RealmManager {
    private static long VERSION = 1L;

    static RealmMigration migration = (realm, oldVersion, newVersion) -> {
        RealmSchema schema = realm.getSchema();
    };

    public static void setRealmConfig(Context context) {
        Realm.init(context);

        RealmConfiguration.Builder realmConfiguration = new RealmConfiguration.Builder();
        realmConfiguration.schemaVersion(VERSION);

        // TEST 시에 Realm 정보가 변경되도 에러가 나지 않도록 하는 설정.
        // Release 시에 아래 사용.
        
        realmConfiguration.deleteRealmIfMigrationNeeded();
//        realmConfiguration.migration(migration);

        Realm.setDefaultConfiguration(realmConfiguration.build());
        Log.v("::::", "Realm.setRealmConfiguration : " + VERSION);
    }
}
