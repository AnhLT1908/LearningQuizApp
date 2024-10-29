package vn.edu.fpt.learningquizapp.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.fpt.learningquizapp.R;
import vn.edu.fpt.learningquizapp.chaptertopics.TopicActivity;

public class HomeFragment extends Fragment {

    CardView SDN302;
    CardView PRM392;
    CardView MLN122;
    CardView FER202;
    CardView HCM202;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize CardViews
        SDN302 = view.findViewById(R.id.SDN302);
        PRM392 = view.findViewById(R.id.PRM392);
        MLN122 = view.findViewById(R.id.MLN122);
        FER202 = view.findViewById(R.id.FER202);
        HCM202 = view.findViewById(R.id.HCM202);

        // Set click listeners for each topic, passing data to TopicActivity
        SDN302.setOnClickListener(view1 -> openTopicActivity("SDN302", R.drawable.nodeexpress));
        PRM392.setOnClickListener(view1 -> openTopicActivity("PRM392", R.drawable.androidlogo));
        MLN122.setOnClickListener(view1 -> openTopicActivity("MLN122", R.drawable.maclenin));
        FER202.setOnClickListener(view1 -> openTopicActivity("FER202", R.drawable.reactjs));
        HCM202.setOnClickListener(view1 -> openTopicActivity("HCM202", R.drawable.hochiminh));

        return view;
    }

    private void openTopicActivity(String title, int imageResId) {
        Intent intent = new Intent(getContext(), TopicActivity.class);
        intent.putExtra("TITLE", title);
        intent.putExtra("IMAGE_RES_ID", imageResId);
        startActivity(intent);
    }
}
