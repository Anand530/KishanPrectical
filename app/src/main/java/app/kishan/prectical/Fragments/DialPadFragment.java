package app.kishan.prectical.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.kishan.prectical.R;

/**
 * Created by Administrator on 7/3/2017.
 */
public class DialPadFragment extends Fragment {

    TextView moTvHead;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_common, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moTvHead = (TextView) view.findViewById(R.id.tvHead);
        moTvHead.setText("DialPad");
    }
}
