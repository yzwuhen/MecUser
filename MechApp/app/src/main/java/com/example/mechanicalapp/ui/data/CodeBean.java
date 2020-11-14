package com.example.mechanicalapp.ui.data;

import java.util.List;

public class CodeBean extends NetData{


    /**
     * success : true
     * result : [{"itemText":"3000-5000/月","itemValue":"1"},{"itemText":"5000-8000/月","itemValue":"2"},{"itemText":"8000-15000/月","itemValue":"3"},{"itemText":"15000以上/月","itemValue":"4"},{"itemText":"面议","itemValue":"5"}]
     * timestamp : 1605367459647
     */

    private List<CodeData> result;



    public List<CodeData> getResult() {
        return result;
    }

    public void setResult(List<CodeData> result) {
        this.result = result;
    }

}
