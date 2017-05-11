package com.wenhan.questionairedemo.fragment;

import com.wenhan.questionairedemo.QuestionaireActivity;
import com.wenhan.questionairedemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */
public class QuestionaireCreateFragment extends Fragment {

    private View contentView;

    private FloatingActionButton addSingleQuestionFab, addChooseQuestionFab, addEssayQuestionFab;

    private LinearLayout addSingleQuestionTypeLl;

    private ScrollView contentSv;

    private QuestionaireActivity parentActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_create, container, false);
        findView();
        setListener();
        initData();
        return contentView;
    }

    private void initData() {
        parentActivity = (QuestionaireActivity) getActivity();
    }

    private void setListener() {
        //问卷整个内容部分
        contentSv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //触摸整个内容区域，添加问题按钮消失
                    hideSubMenuButton();
                }
                return false;
            }
        });
        //添加单个问题按钮
        addSingleQuestionFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addSingleQuestionTypeLl.getVisibility() == View.VISIBLE) {
                    hideSubMenuButton();
                } else if (addSingleQuestionTypeLl.getVisibility() == View.INVISIBLE
                    || addSingleQuestionTypeLl.getVisibility() == View.GONE) {
                    showSubMenuButton();
                }
            }
        });
        //添加单个选择题
        addChooseQuestionFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSubMenuButton();
            }
        });
        //添加单个问答题
        addEssayQuestionFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSubMenuButton();
            }
        });
    }

    private void findView() {
        contentSv = (ScrollView) contentView
            .findViewById(R.id.fragment_create_questionaire_content_sv);
        addSingleQuestionTypeLl = (LinearLayout) contentView
            .findViewById(R.id.fragment_create_questionaire_add_single_question_type_ll);
        addSingleQuestionFab = (FloatingActionButton) contentView
            .findViewById(R.id.fragment_create_add_single_question_fab);
        addChooseQuestionFab = (FloatingActionButton) contentView
            .findViewById(R.id.fragment_create_add_choose_question_fab);
        addEssayQuestionFab = (FloatingActionButton) contentView
            .findViewById(R.id.fragment_create_add_essay_question_fab);
    }

    private void showSubMenuButton() {
        addSingleQuestionFab.setImageResource(R.drawable.icon_common_add_floating_button_close);
        addSingleQuestionTypeLl.setVisibility(View.VISIBLE);
        addSingleQuestionTypeLl.startAnimation(
            AnimationUtils.loadAnimation(parentActivity, android.R.anim.fade_in));
        addChooseQuestionFab.setEnabled(true);
        addEssayQuestionFab.setEnabled(true);
    }

    /**
     * 收起子菜单
     */
    public void hideSubMenuButton() {
        addSingleQuestionFab.setImageResource(R.drawable.icon_common_add_floating_button);
        addSingleQuestionTypeLl.setVisibility(View.INVISIBLE);
        addSingleQuestionTypeLl.startAnimation(
            AnimationUtils.loadAnimation(parentActivity, android.R.anim.fade_out));
        addChooseQuestionFab.setEnabled(false);
        addEssayQuestionFab.setEnabled(false);
    }

    /**
     * 获取子菜单打开状态
     */
    public int getSubMenuStatus() {
        return addSingleQuestionTypeLl.getVisibility();
    }

}
