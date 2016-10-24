package com.example.jingbin.designpattern.emtag;

import android.graphics.Color;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Toast;

import com.example.jingbin.designpattern.app.PatternApplication;

import org.xml.sax.XMLReader;

/**
 * Created by jingbin on 2016/10/24.
 */

public class GameTagHandler implements Html.TagHandler {
    private int startIndex = 0;
    private int stopIndex = 0;

    @Override
    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
        if (tag.toLowerCase().equals("light")) {
            if (opening) {
                startGame(tag, output, xmlReader);
            } else {
                endGame(tag, output, xmlReader);
            }
        }
    }

    private void startGame(String tag, Editable output, XMLReader xmlReader) {
        startIndex = output.length();
    }

    private void endGame(String tag, Editable output, XMLReader xmlReader) {
        stopIndex = output.length();
        output.setSpan(new ForegroundColorSpan(Color.parseColor("#22c283")), startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        output.setSpan(new GameSpan(), startIndex, stopIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    private class GameSpan extends ClickableSpan implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // 跳转某页面
            Toast.makeText(PatternApplication.getInstance(), "click_game", Toast.LENGTH_SHORT).show();
        }
    }

}
