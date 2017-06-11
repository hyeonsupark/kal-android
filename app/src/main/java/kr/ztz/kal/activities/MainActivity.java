package kr.ztz.kal.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import kr.ztz.kal.R;
import kr.ztz.kal.fragments.RoomListFragment;
import kr.ztz.kal.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements RoomListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, new RoomListFragment());
        ft.commit();

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d("kal", "TEST");
    }
}
