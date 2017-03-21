package kh.edu.rupp.fe.ruppmad;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * RUPPMAD
 * Created by leapkh on 7/3/17.
 */

public class DocumentsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_documents, container, false);
        return fragmentView;
    }

}
