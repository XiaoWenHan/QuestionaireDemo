package com.wenhan.questionairedemo;

import com.wenhan.questionairedemo.fragment.ConfirmDetailListFragment;
import com.wenhan.questionairedemo.fragment.EssayViewDetailListFragment;
import com.wenhan.questionairedemo.fragment.QuestionaireCreateFragment;
import com.wenhan.questionairedemo.fragment.QuestionaireInputFragment;
import com.wenhan.questionairedemo.fragment.QuestionaireViewFragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

public class QuestionaireActivity extends AppCompatActivity {

    private final String TAG = "QuestionaireActivity";

    private FragmentManager fragmentManager;

    public final static String INTENT_LAUNCH_TYPE = "launch_type";

    public final static int INTENT_LAUNCH_TYPE_CREATE = 0x01;

    public final static int INTENT_LAUNCH_TYPE_VIEW = 0x02;

    private int currentPos;

    private final int POS_CONFIRM_LIST = 0x01;

    private final int POS_CREATE = 0x02;

    private final int POS_VIEW = 0x03;

    private final int POS_ESSAY_LIST = 0x04;

    private QuestionaireCreateFragment mQuestionaireCreateFragment;

    private QuestionaireInputFragment mQuestionaireInputFragment;

    private QuestionaireViewFragment mQuestionaireViewFragment;

    private EssayViewDetailListFragment mEssayViewDetailListFragment;

    private ConfirmDetailListFragment mConfirmDetailListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire);
        findView();
        init();
    }

    private void findView() {
    }

    private void init() {
        initFragment();
    }

    private void initFragment() {
        fragmentManager = getFragmentManager();
        if (getIntent().getIntExtra(INTENT_LAUNCH_TYPE, -1) == INTENT_LAUNCH_TYPE_CREATE) {
            jumpToCreateFragment();
        }
        if (getIntent().getIntExtra(INTENT_LAUNCH_TYPE, -1) == INTENT_LAUNCH_TYPE_VIEW) {
            jumpToViewFragment();
        }
    }

    /**
     * 跳转到创建问卷界面
     */
    public void jumpToCreateFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (mQuestionaireCreateFragment == null) {
            mQuestionaireCreateFragment = new QuestionaireCreateFragment();
        }
        transaction.replace(R.id.activity_questionaire_container_fl,
            mQuestionaireCreateFragment);
        transaction.commit();
        currentPos = POS_CREATE;
    }

    /**
     * 跳转到查看确认详情界面
     */
    public void jumpToSeeConfirmDetail() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (mConfirmDetailListFragment == null) {
            mConfirmDetailListFragment = new ConfirmDetailListFragment();
        }
        transaction.replace(R.id.activity_questionaire_container_fl,
            mConfirmDetailListFragment);
        transaction.commit();
        currentPos = POS_CONFIRM_LIST;
    }


    /**
     * 跳转到查看问卷回答详情界面
     */
    public void jumpToSeeEssayListDetail() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (mEssayViewDetailListFragment == null) {
            mEssayViewDetailListFragment = new EssayViewDetailListFragment();
        }
        transaction.replace(R.id.activity_questionaire_container_fl,
            mEssayViewDetailListFragment);
        transaction.commit();
        currentPos = POS_ESSAY_LIST;
    }

    /**
     * 跳转到查看问卷界面
     */
    public void jumpToViewFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (mQuestionaireViewFragment == null) {
            mQuestionaireViewFragment = new QuestionaireViewFragment();
        }
        transaction.replace(R.id.activity_questionaire_container_fl,
            mQuestionaireViewFragment);
        transaction.commit();
        currentPos = POS_VIEW;
    }

    /**
     * 跳转到回答问卷界面
     */
    public void jumpToInputFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (mQuestionaireInputFragment == null) {
            mQuestionaireInputFragment = new QuestionaireInputFragment();
        }
        transaction.replace(R.id.activity_questionaire_container_fl,
            mQuestionaireInputFragment);
        transaction.commit();
        currentPos = POS_VIEW;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            switch (currentPos) {
                case POS_CONFIRM_LIST:
                case POS_ESSAY_LIST:
                    jumpToViewFragment();
                    break;
                default:
                    return super.onKeyDown(keyCode, event);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
