package nqt.com.ising.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;

import nqt.com.ising.R;

public class CheckNetWorkConnection {

    private Context mContext;

    public CheckNetWorkConnection() {
    }

    public CheckNetWorkConnection(Context context) {
        this.mContext = context;
    }

    /**
     * check connection network
     * @return false if no connection is created
     * @return true if exists connection
     */
    public boolean isConnectNetwork() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (null != networkInfo && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    /**
     * show a dialog to warn state "No internet exsist"
     */
    public void showWarningNoInternet() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(R.string.message_error);
        builder.setMessage(R.string.message_no_connection);
        builder.setPositiveButton(R.string.message_try, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK);
                mContext.startActivity(intent);
            }
        });
        builder.setNegativeButton(R.string.message_exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((Activity) mContext).finish();
            }
        });
        builder.show();
    }


}
