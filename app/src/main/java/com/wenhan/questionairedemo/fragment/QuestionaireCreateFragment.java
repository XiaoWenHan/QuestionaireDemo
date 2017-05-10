package com.wenhan.questionairedemo.fragment;

import com.wenhan.questionairedemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */
public class QuestionaireCreateFragment extends Fragment {

    private View contentView;

    private FloatingActionButton addSingleQuestionFab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_create, container, false);
        return contentView;
    }

}
