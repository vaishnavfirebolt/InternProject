package com.example.internproject.ui.courses;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internproject.R;
import com.example.internproject.adapters.ChildRecyclerAdapter;
import com.example.internproject.adapters.MainRecyclerAdapter;
import com.example.internproject.models.mainRVModel;
import com.example.internproject.models.videoDetails;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.*;

public class CoursesFragment extends Fragment implements ChildRecyclerAdapter.ChildAdapterEvents {

    private  List<mainRVModel> mainRVModelList ;
    private RecyclerView mainRecyclerView ;
    private YouTubePlayerView youTubePlayerView;
    private videoDetails v;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courses, container, false);

        initData();

        mainRecyclerView = root.findViewById(R.id.rvParent);
        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(mainRVModelList , this);
        mainRecyclerView.setAdapter(mainRecyclerAdapter);

        youTubePlayerView = root.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.getYouTubePlayerWhenReady(new YouTubePlayerCallback() {
            @Override
            public void onYouTubePlayer(YouTubePlayer youTubePlayer) {
                youTubePlayer.cueVideo("LmkKFCfmnhQ", 0);
            }
        });

        return root;
    }

    private void initData(){
        mainRVModelList = new ArrayList<>();

        String module1 = "BeginnerModule";
        List<videoDetails> videoDetailsList1 = new ArrayList<>();
        videoDetailsList1.add(new videoDetails("Video 1" , "LmkKFCfmnhQ"));
        videoDetailsList1.add(new videoDetails("video 2" , "U5BwfqBpiWU"));
        videoDetailsList1.add(new videoDetails("video 3" , "SMOhl9RK0BA"));
        videoDetailsList1.add(new videoDetails("video 4" , "r8U5Rtcr5UU"));
        videoDetailsList1.add(new videoDetails("video 5" , "7p22cSzniBM"));
        videoDetailsList1.add(new videoDetails("video 6" , "r_19VZ0xRO8"));

        String module2 = "Intermediate Module";
        List<videoDetails> videoDetailsList2 = new ArrayList<>();
        videoDetailsList2.add(new videoDetails("Module 2 Video 1" , "LmkKFCfmnhQ"));
        videoDetailsList2.add(new videoDetails("Module 2 Video 2" , "U5BwfqBpiWU"));
        videoDetailsList2.add(new videoDetails("Module 2 video 3" , "SMOhl9RK0BA"));
        videoDetailsList2.add(new videoDetails("Module 2 video 4" , "r8U5Rtcr5UU"));
        videoDetailsList2.add(new videoDetails("Module 2 video 5" , "7p22cSzniBM"));
        videoDetailsList2.add(new videoDetails("Module 2 video 6" , "r_19VZ0xRO8"));

        mainRVModelList.add(new mainRVModel(module1 , videoDetailsList1));
        mainRVModelList.add(new mainRVModel(module2 , videoDetailsList2));

    }

    @Override
    public void onCourseClicked(videoDetails vd) {
        v = vd;
        Toast.makeText(getContext() , "Video will be loaded shortly" , Toast.LENGTH_SHORT).show();
        youTubePlayerView.getYouTubePlayerWhenReady(new YouTubePlayerCallback() {
            @Override
            public void onYouTubePlayer(YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(v.getVideoID(), 0);
            }
        });
    }
}