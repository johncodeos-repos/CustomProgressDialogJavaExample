package com.example.customprogressdialogjavaexample;

import android.app.Dialog;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

public class CustomProgressBar {

    Dialog dialog;

    final Dialog show(Context context) {
        return this.show(context, null);
    }


    Dialog show(Context context, String title) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.progress_bar, null, false);
        TextView cpTitle = view.findViewById(R.id.cp_title);
        if (title != null) {
            cpTitle.setText(title);
        }

        ConstraintLayout cpBgView = view.findViewById(R.id.cp_bg_view);
        CardView cpCardview = view.findViewById(R.id.cp_cardview);


        cpBgView.setBackgroundColor(Color.parseColor("#60000000"));
        cpCardview.setCardBackgroundColor(Color.parseColor("#70000000"));

        ProgressBar cpBar = view.findViewById(R.id.cp_pbar);
        this.setColorFilter(cpBar.getIndeterminateDrawable(), ResourcesCompat.getColor(context.getResources(), R.color.colorPrimary, null));  //Progress Bar Color
        cpTitle.setTextColor(Color.WHITE);

        this.dialog = new Dialog(context, R.style.CustomProgressBarTheme);
        dialog.setContentView(view);
        dialog.show();

        return dialog;
    }


    private void setColorFilter(Drawable drawable, int color) {
        if (Build.VERSION.SDK_INT >= 29) {
            drawable.setColorFilter(new BlendModeColorFilter(color, BlendMode.SRC_ATOP));
        } else {
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }

    }
}
