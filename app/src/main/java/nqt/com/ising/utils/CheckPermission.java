package nqt.com.ising.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public class CheckPermission {

    private Context mContext;

    public CheckPermission() {
    }

    public CheckPermission(Context context) {
        this.mContext = context;
    }

    public boolean checkPermission(String permission) {
        if (ActivityCompat.checkSelfPermission(mContext, permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    public void requestPermission(String permission) {
        ActivityCompat.requestPermissions((Activity) mContext, new String[]{permission}, 100);
    }
}
