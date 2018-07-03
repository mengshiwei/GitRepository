package com.meng.tom.whiskerman.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meng.tom.whiskerman.Activities.BannerDetailActivity;
import com.meng.tom.whiskerman.Daos.DaoHome;
import com.meng.tom.whiskerman.R;
import com.meng.tom.whiskerman.Views.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

public class MyviewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View inflate;
    private Banner banner;

    public MyviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyviewFragment newInstance(String param1, String param2) {
        MyviewFragment fragment = new MyviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_myview, container, false);
        banner = (Banner) inflate.findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                getActivity().startActivity(new Intent(getActivity(), BannerDetailActivity.class));
            }
        });
        banner.setImages(DaoHome.getInstance(getActivity()).getImageUrls()).setImageLoader(new GlideImageLoader()).setBannerTitles(DaoHome.getInstance(getActivity()).getBannerTitles()).start();
        return inflate;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
