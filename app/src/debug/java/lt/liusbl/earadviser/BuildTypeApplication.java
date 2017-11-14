package lt.liusbl.earadviser;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.timber.StethoTree;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

public class BuildTypeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
        Timber.plant(new Timber.DebugTree());
        Timber.plant(new StethoTree());

        LeakCanary.install(this);
    }
}
