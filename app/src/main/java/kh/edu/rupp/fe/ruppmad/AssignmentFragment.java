package kh.edu.rupp.fe.ruppmad;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.fe.ruppmad.adapter.Assignment;
import kh.edu.rupp.fe.ruppmad.adapter.AssignmentsAdapter;
import kh.edu.rupp.fe.ruppmad.adapter.RecyclerViewItemClickListener;
import kh.edu.rupp.fe.ruppmad.db.DBHelper;

/**
 * Created by KIMvHAI on 5/9/2017.
 */

public class AssignmentFragment extends Fragment implements RecyclerViewItemClickListener {

    private RecyclerView rclDocuments;
    private AssignmentsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_documents, container, false);

        // Reference to RecyclerView
        rclDocuments = (RecyclerView) fragmentView.findViewById(R.id.rcl_documents);

        // Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rclDocuments.setLayoutManager(layoutManager);

        // Adapter
        adapter = new AssignmentsAdapter(loadAssignments());
        adapter.setRecyclerViewItemClickListener(this);
        rclDocuments.setAdapter(adapter);

        return fragmentView;
    }

    // Temporary List of Documents
    private Assignment[] loadAssignments() {
        DBHelper dbHelper = new DBHelper(getActivity());
        return dbHelper.getAllAssignments();
    }

    @Override
    public void onRecyclerViewItemClick(int position) {
        Log.d("rupp", "Recycler item click: " + position);
    }
}
