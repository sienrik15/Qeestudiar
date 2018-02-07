package com.example.user.qeestudiar.services;

import com.example.user.qeestudiar.models.Mentor;

import java.util.List;

/**
 * Created by User on 29/11/2017.
 */

public interface QueryCallBack {
    void onSuccess(List<Mentor> mData);
    void onError(String mError);
}
