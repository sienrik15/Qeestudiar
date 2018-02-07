package com.example.user.qeestudiar.services;

import com.example.user.qeestudiar.models.Mentor;
import com.github.florent37.okgraphql.OkGraphql;
import com.github.florent37.okgraphql.converter.GsonConverter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by User on 29/11/2017.
 */

public class ServicesGraphql {

    OkHttpClient okHttpClient;
    OkGraphql okGraphql;
    private JSONObject mJsonMentors;
    private JSONArray mArrayMentos;
    public ServicesGraphql(){
        okHttpClient = new OkHttpClient().newBuilder()
                            .retryOnConnectionFailure(false)
                            .connectTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .build();
        okGraphql = new OkGraphql.Builder()
                        .okClient(okHttpClient)
                        .baseUrl("http://api.qeestudiar.com/v1/")
                        .converter(new GsonConverter(new Gson()))
                        .build();
    }

    public void QueryMentors(QueryCallBack mQueryCallBack){

        okGraphql.query("{" +
                         " mentors {" +
                         "      edges {" +
                         "          id" +
                         "          name" +
                         "          specialization" +
                         "          social_media" +
                         "          link_project" +
                         "          photo_path" +
                         "          about"+
                         "          experiences {" +
                         "              id" +
                         "              title" +
                         "              achievement"+
                         "              }" +
                         "          question_about_decision" +
                         "          }"+
                         "      }"+
                         "}").enqueue(modelMentors -> {
                            //play with your responseString
                                    try {
                                        JSONObject data = new JSONObject(modelMentors);
                                        mJsonMentors = data.getJSONObject("data");
                                        List<Mentor> mMentors = new ArrayList<>();
                                        Mentor mMentor;
                                        mJsonMentors = mJsonMentors.getJSONObject("mentors");
                                        mArrayMentos = mJsonMentors.getJSONArray("edges");
                                        for (int i=0; i < mArrayMentos.length(); i++) {
                                            mMentor = new Mentor();
                                            mMentor.setId(mArrayMentos.getJSONObject(i).getString("id"));
                                            mMentor.setName(mArrayMentos.getJSONObject(i).getString("name"));
                                            mMentor.setSpecialization(mArrayMentos.getJSONObject(i).getString("specialization"));
                                            mMentor.setPhotoPath(mArrayMentos.getJSONObject(i).getString("photo_path"));
                                            //mMentor.setCareer(mArrayMentos.getJSONObject(i).getString("career"));
                                            mMentors.add(mMentor);
                                        }
                                        mQueryCallBack.onSuccess(mMentors);
                                    } catch (JSONException e) {
                                        mQueryCallBack.onError(e.getMessage());
                                        e.printStackTrace();
                                    }catch (Exception e){
                                        e.getMessage();
                                    }
                                }, error -> {
                                   mQueryCallBack.onError(error.getMessage());
                                //display the error
                                });
    }

}
