package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.Joking;
import com.example.mahmoud.bigger.backend.myApi.MyApi;
import com.example.mahmoud.telljokesandroidlib.TellJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Mahmoud on 12/05/2017.
 */

public class EndpointAsyncTask extends AsyncTask<String, String, String> {
    MyApi.Builder builder;
    private static MyApi myApiService = null;

    Context mcontext;

    public EndpointAsyncTask(Context context) {

        mcontext = context;


    }

    @Override
    protected String doInBackground(String... params) {
        if (myApiService == null) {
            builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null).setRootUrl("http://192.168.1.5:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();

        }
        try {

            return myApiService.sayHi().execute().getData();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPreExecute() {

    }


    @Override
    protected void onPostExecute(String aVoid) {

        if (aVoid != null) {

            Intent intent = new Intent(mcontext, TellJokeActivity.class);
            intent.putExtra(mcontext.getString(R.string.const_joke), aVoid);
            mcontext.startActivity(intent);

        } else {

            Toast.makeText(mcontext, "Cann't load jokes", Toast.LENGTH_SHORT).show();

        }

    }
}
