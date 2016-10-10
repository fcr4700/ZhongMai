package com.qf.project.tempproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.qf.project.tempproject.activity.fcrActivity.FiveActivity;
import com.qf.project.tempproject.activity.fcrActivity.FourActivity;
import com.qf.project.tempproject.activity.fcrActivity.ThreeActivity;
import com.qf.project.tempproject.activity.fcrActivity.TwoActivity;
import com.qf.project.tempproject.fragment.oneFragment.OneFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Fragment fragment1,fragment2,fragment3,fragment4,fragment5;

    LinearLayout mLayout1,mLayout2,mLayout3,mLayout4,mLayout5;
    FragmentManager mManager;
    FragmentTransaction mTransaction;
    public static final int RESULT_LOAD_IMAGE = 200;
    String FIVE_URL_STING="http://v.jmtopapp.cn/zmsjv3/api/h5subjectlist.php?page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

        //mRadioGroup.setOnCheckedChangeListener(this);
        mManager=getSupportFragmentManager();
        mTransaction=mManager.beginTransaction();
        mTransaction.add(R.id.fragmentId,fragment1);
        mTransaction.commit();

    }

    private void initData() {
        fragment1=new OneFragment();
        //TODO
    }

    private void initView() {
        mLayout1= (LinearLayout) findViewById(R.id.radioBtn_one);
        mLayout2= (LinearLayout) findViewById(R.id.radioBtn_two);
        mLayout3= (LinearLayout) findViewById(R.id.radioBtn_three);
        mLayout4= (LinearLayout) findViewById(R.id.radioBtn_four);
        mLayout5= (LinearLayout) findViewById(R.id.radioBtn_five);

        mLayout1.setOnClickListener(this);
        mLayout2.setOnClickListener(this);
        mLayout3.setOnClickListener(this);
        mLayout4.setOnClickListener(this);
        mLayout5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){

            case R.id.radioBtn_one:
                Fragment OneFrag=fragment1;
                mTransaction=mManager.beginTransaction();
                mTransaction.replace(R.id.fragmentId,OneFrag);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                break;
            case R.id.radioBtn_two:
                intent=new Intent(this, TwoActivity.class);
                startActivity(intent);
                break;
            case R.id.radioBtn_three:
                //intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // startActivityForResult(intent,RESULT_LOAD_IMAGE);
                intent=new Intent(this, ThreeActivity.class);
                startActivity(intent);
                break;
            case R.id.radioBtn_four:
                intent=new Intent(this, FourActivity.class);
                startActivity(intent);
                break;
            case R.id.radioBtn_five:
                intent=new Intent(this, FiveActivity.class);
                intent.putExtra("fiveUrl",FIVE_URL_STING);
                startActivity(intent);
                break;
        }
    }
}
