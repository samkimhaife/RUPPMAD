package kh.edu.rupp.fe.ruppmad;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * RUPPMAD
 * Created by leapkh on 1/3/17.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    private DocumentsFragment documentsFragment;
    private boolean isFragmentShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        findViewById(R.id.img_logout).setOnClickListener(this);
        findViewById(R.id.lyt_documents).setOnClickListener(this);

        addFragments();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_logout:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.lyt_documents:
                onDocumentsClick();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (isFragmentShowing) {
            showFragment(null);
        } else {
            super.onBackPressed();
        }
    }

    private void showFragment(Fragment fragment) {
        if (fragment == null) {
            isFragmentShowing = false;
            findViewById(R.id.lyt_menus).setVisibility(View.VISIBLE);
            findViewById(R.id.lyt_fragments).setVisibility(View.GONE);
        } else {
            isFragmentShowing = true;
            findViewById(R.id.lyt_menus).setVisibility(View.GONE);
            findViewById(R.id.lyt_fragments).setVisibility(View.VISIBLE);
        }
    }

    private void onDocumentsClick() {
        showFragment(documentsFragment);
    }

    private void addFragments() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        documentsFragment = new DocumentsFragment();
        fragmentTransaction.add(R.id.lyt_fragments, documentsFragment);
        fragmentTransaction.commit();
    }

}
