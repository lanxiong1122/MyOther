package com.xample.candycrush;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextFileDisplayUtil {

    private static final String TAG = "TextFileDisplayUtil";

    public static void displayTextFile(Activity activity, String fileName) {
        // 从 assets 文件夹中读取文件
        StringBuilder fileContent = new StringBuilder();
        try (InputStream is = activity.getAssets().open(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 创建并显示 AlertDialog
        createAndShowDialog(activity, fileContent.toString());
    }

    private static void createAndShowDialog(final Activity activity, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(""); // 设置对话框标题为空

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_text_view, null);

        TextView textView = view.findViewById(R.id.text_view);
        textView.setText(content);
        AlertDialog dialog = builder.setView(view).create();
        // 设置返回按钮的点击事件
        TextView returnButton = view.findViewById(R.id.text_view_return);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取当前显示的对话框并关闭它
                 dialog.dismiss();
            }
        });

//        builder.setView(view)
//                .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });

        // 显示对话框
        dialog.show();
    }
}
