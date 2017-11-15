package app.kishan.prectical;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import app.kishan.prectical.Models.Contect;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 7/3/2017.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Contect> moContcatList = new LinkedList<>();
    private Context moContext;

    public MainAdapter(Context foContext, List<Contect> foContactList) {
        this.moContcatList = foContactList;
        this.moContext = foContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact, viewGroup, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView loIvProfile, loIvShare;
        TextView loTvName, loTvNumber, loTvCode;

        public ViewHolder(View foView) {
            super(foView);
            loIvProfile = (ImageView) foView.findViewById(R.id.ivProfile);
            loIvShare = (ImageView) foView.findViewById(R.id.ivShare);
            loTvName = (TextView) foView.findViewById(R.id.tvName);
            loTvNumber = (TextView) foView.findViewById(R.id.tvNumber);
            loTvCode = (TextView) foView.findViewById(R.id.tvCode);

        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder foHolder, final int position) {

        if (moContcatList.get(position).getImageLink().length() == 0) {
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(String.valueOf(moContcatList.get(position).getCaption().charAt(0)), Color.GRAY);
            foHolder.loIvProfile.setImageDrawable(drawable);
        } else {
            Uri loUri = Uri.parse(moContcatList.get(position).getImageLink());
            Picasso.with(moContext).load(loUri)
                    .transform(new CropCircleTransformation()).into(foHolder.loIvProfile);
        }
        if (!moContcatList.get(position).isShared()) {
            foHolder.loIvShare.setVisibility(View.GONE);
        }
        Log.d("JD", "getCaption = " + moContcatList.get(position).getCaption());
        foHolder.loTvName.setText(moContcatList.get(position).getCaption());
        foHolder.loTvNumber.setText(moContcatList.get(position).getNumber());
        foHolder.loTvCode.setText(moContcatList.get(position).getContryCode());

        foHolder.loIvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(moContext);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialog_view);
                ImageView image = (ImageView) dialog.findViewById(R.id.ivZoom);
                if (moContcatList.get(position).getImageLink().length() == 0) {
                    TextDrawable drawable = TextDrawable.builder()
                            .buildRect(String.valueOf(moContcatList.get(position).getCaption().charAt(0)), Color.GRAY);
                    image.setImageDrawable(drawable);
                } else {
                    Uri loUri = Uri.parse(moContcatList.get(position).getImageLink());
                    Picasso.with(moContext).load(loUri).into(image);
                }
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return moContcatList.size();
    }
}
