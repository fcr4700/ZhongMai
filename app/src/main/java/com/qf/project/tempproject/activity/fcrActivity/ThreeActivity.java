package com.qf.project.tempproject.activity.fcrActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.qf.project.tempproject.R;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class ThreeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup mRadioGroup;
    public static final int RESULT_LOAD_IMAGE = 200;
    private static final int REQUEST_IMAGE = 100;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fcr_activity_three);
        initView();
    }

    private void initView() {
        mRadioGroup= (RadioGroup) findViewById(R.id.fcr_three_rg);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Intent intent;
        switch (checkedId){
            case R.id.fcr_three_radioImage:
                intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,RESULT_LOAD_IMAGE);
                break;
            case R.id.fcr_three_camera:
                intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_IMAGE);
                break;
        }
    }
}
