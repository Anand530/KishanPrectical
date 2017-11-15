package app.kishan.prectical.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.kishan.prectical.DialogLoder;
import app.kishan.prectical.MainAdapter;
import app.kishan.prectical.Models.Contect;
import app.kishan.prectical.R;


/**
 * Created by Administrator on 7/3/2017.
 */
public class ContactsFragemt extends Fragment {

    private View moView;
    private MainAdapter moMainAdapter;
    private RecyclerView moRcvMain;
    private List<Contect> moContactList;
    private ProgressDialog progressDialog;
    private ProgressDialog progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moView = view;
        init();
    }

    private void init() {
       /* progressBar = new ProgressDialog(getActivity(), R.style.AppCompatAlertDialogStyle);
        progressBar.setCancelable(true);
        progressBar.setMessage("Please wait ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();*/

        moRcvMain = (RecyclerView) moView.findViewById(R.id.rcvMain);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        moRcvMain.setLayoutManager(mLayoutManager);

        final JSONObject object = new JSONObject();
        try {
            object.put("mynumber", "09512468722");
            object.put("apikey", "TEST");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://jyapi.togglewave.com/rcci.svc/getcontacts", object,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                      //  progressBar.dismiss();
                        moContactList = new ArrayList<>();
                        Log.d("JD", "gjgds = " + response.toString());
                        JSONObject object1 = null;
                        try {
                            object1 = new JSONObject(response.toString());
                            JSONObject object2 = object1.getJSONObject("getcontactsResult");
                            JSONArray jsonArray = object2.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Contect contect = new Contect();
                                Log.d("JD", "gjgds = " + jsonObject.getString("caption"));
                                contect.setCaption(jsonObject.getString("caption"));
                                contect.setContryCode(jsonObject.getString("country_code"));
                                contect.setImageLink(jsonObject.getString("imagebase64"));
                                contect.setNumber(jsonObject.getString("international_number"));
                                contect.setShared(jsonObject.getBoolean("isLineShared"));
                                moContactList.add(contect);
                            }
                            moMainAdapter = new MainAdapter(getActivity(), moContactList);
                            moRcvMain.setAdapter(moMainAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("JD", "gjgds = " + error.getMessage());
            }
        });
        Volley.newRequestQueue(getActivity()).add(jsonObjectRequest);


    }

}
