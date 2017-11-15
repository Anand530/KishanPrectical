package app.kishan.prectical;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Administrator on 8/19/2017.
 */
public class DialogLoder {

    public static Dialog dialog;
    public static LayoutInflater m_inflater;
    public static View m_view;
    public static TextView tvMessage;
    static boolean isCancelable;

    public static void showLoderDialog(final Activity activity, boolean lbCancel) {

        try {

            isCancelable = lbCancel;
            dialog = new Dialog(activity, R.style.AppCompatLoderDialogStyle);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            if (lbCancel) {
                dialog.setCancelable(true);
            } else {
                dialog.setCancelable(false);
            }

            m_inflater = LayoutInflater.from(activity);
            m_view = DialogLoder.m_inflater.inflate(R.layout.dlg_loder, null);


            dialog.setContentView(m_view);
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dismisLoderDialog() {
        try {
            if (dialog.isShowing())
                dialog.dismiss();

        } catch (Exception e) {
            Log.e("DialogLoder", "Crash DialogLoder");
            e.printStackTrace();
        }

    }
}

