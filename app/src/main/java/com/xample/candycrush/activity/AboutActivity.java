package com.xample.candycrush.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.xample.candycrush.R;
import com.xample.candycrush.TextFileDisplayUtil;


/**
 * 关于软件
 *  @author androiddev@163.com,hnjdzy
 */
public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView tx5 = findViewById(R.id.textView5);
        tx5.setText("VersionCode ： "+getVersionCode(this));
        findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextFileDisplayUtil.displayTextFile(AboutActivity.this, "re.txt");
            }
        });
    }





    private int getVersionCode(Context context) {
        int versionCode = -1;
        try {
            // 获取包管理器
            PackageManager manager = context.getPackageManager();
            // 获取包信息
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            // 从包信息中获取版本号
            versionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // 这个异常理论上不应该发生
            e.printStackTrace();
        }
        return versionCode;
    }
}
