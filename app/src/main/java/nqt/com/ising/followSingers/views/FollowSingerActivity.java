package nqt.com.ising.followSingers.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nqt.com.ising.R;
import nqt.com.ising.followSingers.constracts.IFollowSinger;

public class FollowSingerActivity extends AppCompatActivity implements IFollowSinger.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_singer);
    }
}
