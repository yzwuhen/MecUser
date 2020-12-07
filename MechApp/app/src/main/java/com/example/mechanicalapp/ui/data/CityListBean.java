package com.example.mechanicalapp.ui.data;

import java.util.List;

public class CityListBean extends NetData {


    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<List<GroupListBean>> groupList;
        private List<HomeCityData> hotList;

        public List<List<GroupListBean>> getGroupList() {
            return groupList;
        }

        public void setGroupList(List<List<GroupListBean>> groupList) {
            this.groupList = groupList;
        }

        public List<HomeCityData> getHotList() {
            return hotList;
        }

        public void setHotList(List<HomeCityData> hotList) {
            this.hotList = hotList;
        }

        public static class GroupListBean {

            private String key;
            private List<HomeCityData> data;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public List<HomeCityData> getData() {
                return data;
            }

            public void setData(List<HomeCityData> data) {
                this.data = data;
            }
        }

    }
}
