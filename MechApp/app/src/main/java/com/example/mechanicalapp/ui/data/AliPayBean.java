package com.example.mechanicalapp.ui.data;

public class AliPayBean extends NetData {

    /**
     * success : true
     * result : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2021002113624775&biz_content=%7B%22body%22%3A%22%E6%88%91%E6%98%AF%E6%B5%8B%E8%AF%95%E6%95%B0%E6%8D%AE%22%2C%22out_trade_no%22%3A%22020210106102801240826%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22App%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95Java%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&sign=BzYoABHU5LkL6DEZ0WEVBy17fv241KBhKJdNWDZUXnN00o%2F4oidasjgURT3CnS4CL9vrT%2FhANiswtO3J0IpX78HZUMl605aIynIBzzdP3kqeN%2BmMLpozhR%2BOuP77iGnPNzGeUNATukAi1Dm8hPkL7rZeFTHMaOkQM2FWMpNmWLXyeX2WJ5WmcY1POfC0e04PrMzNVyRf%2F2Ki0dKw2vPQW3hjTvWhExEh2FeAxcjnwAz7umbBdOtzDebxVEGVX5HNfhTNI8LQCNZZAQ3OsClrpxdZh3n0usYojccDRKkHkqAhnS3uuUDHF%2FLFF4yylysXC6U81YFpkCKKpwu7bXA%2FDg%3D%3D&sign_type=RSA2&timestamp=2021-01-06+11%3A20%3A55&version=1.0&sign=BzYoABHU5LkL6DEZ0WEVBy17fv241KBhKJdNWDZUXnN00o%2F4oidasjgURT3CnS4CL9vrT%2FhANiswtO3J0IpX78HZUMl605aIynIBzzdP3kqeN%2BmMLpozhR%2BOuP77iGnPNzGeUNATukAi1Dm8hPkL7rZeFTHMaOkQM2FWMpNmWLXyeX2WJ5WmcY1POfC0e04PrMzNVyRf%2F2Ki0dKw2vPQW3hjTvWhExEh2FeAxcjnwAz7umbBdOtzDebxVEGVX5HNfhTNI8LQCNZZAQ3OsClrpxdZh3n0usYojccDRKkHkqAhnS3uuUDHF%2FLFF4yylysXC6U81YFpkCKKpwu7bXA%2FDg%3D%3D
     * timestamp : 1609903255454
     */

    private boolean success;
    private String result;
    private long timestamp;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
