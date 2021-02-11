package com.example.mad_lab02_ex01;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    // Create a LiveData with a String
    private MutableLiveData<Integer> count;

    public MutableLiveData<Integer> getCurrentName() {
        if (count == null) {
            count = new MutableLiveData<Integer>();
        }
        return count;
    }
}