package com.example.jeffg.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.example.jeffg.interfaces.AsynTaskCompleteListeningMovie;
import com.example.jeffg.model.Movie;
import com.example.jeffg.popularmoviesapp.MainActivity;

import com.example.jeffg.popularmoviesapp.R;


import java.net.URL;

import static com.example.jeffg.popularmoviesapp.MainActivity.tv_error;

import static com.example.jeffg.popularmoviesapp.MainActivity.btn_retry;

public class FetchMyDataTask extends AsyncTask<String, Void, Movie[]> {



    @SuppressLint("StaticFieldLeak")
    private Context mContext;
    private AsynTaskCompleteListeningMovie mListener;



    public FetchMyDataTask(Context context, MainActivity.MovieFetchTaskCompleteListener listener){
        this.mContext =context;
        this.mListener = listener;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        MainActivity.preExecute();
    }
    @Override
    protected Movie[] doInBackground(String... strings) {
        Movie[] mMovie = null;
        if (!isOnline()) {
            MainActivity.errorNetworkApi();
            return null;
        }
        if (MovieUrlUtils.API_KEY.equals("")) {
            MainActivity.errorNetworkApi();
            tv_error.setText(R.string.missing_api_key);
            tv_error.setTextColor(ContextCompat.getColor(mContext, R.color.secondary_text));
            btn_retry.setVisibility(View.INVISIBLE);
            return null;
        }
        URL movieUrl = MovieUrlUtils.buildUrl(strings[0]);

        String movieResponse;
        try {
            movieResponse = MovieUrlUtils.getResponseFromHttp(movieUrl);
            mMovie = MovieJsonUtils.parseJsonMovieForMain(movieResponse);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return mMovie;
    }

    @Override
    protected void onPostExecute(Movie[] movies) {
        super.onPostExecute(movies);
        mListener.onTaskComplete(movies);

    }



    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


}
