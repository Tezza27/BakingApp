package com.example.android.bakingapp.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.bakingapp.R;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class FragmentExoplayer extends Fragment {
    private SimpleExoPlayer exoPlayer;
    private PlayerView exopPlayerView;
    private String stepVideoUrl;
    private View rootview;

    //Mandatory constructor for instantiating the fragment
    public FragmentExoplayer() {

   }

   //Inflate the fragment layout and set any image resources
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){

try {
    //Inflate the Exoplayerfragment layout
    rootview = inflater.inflate(R.layout.fragment_exoplayer, container, false);

    //unpack the bundle to get data sent from StepDetailActivity
    stepVideoUrl = this.getArguments().getString("STEP_VIDEO_URL");


    //geta a reference to the ImageView in the fragment layout
    exopPlayerView = (PlayerView) rootview.findViewById(R.id.exoplayer_view);
    BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
    TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
    exoPlayer = ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector);
    Uri stepVideoURI = Uri.parse(stepVideoUrl);

    DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
    ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
    MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(stepVideoURI);


    //Set the player to be displayed
    exopPlayerView.setPlayer(exoPlayer);
    exoPlayer.prepare(mediaSource);
    exoPlayer.setPlayWhenReady(true);


    }catch (Exception e) {
        Log.e("FragmentExoplayer", " exoPlayer error " + exoPlayer.toString());
    }

            return rootview;
        }
        }