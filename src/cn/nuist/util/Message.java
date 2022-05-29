package cn.nuist.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author whb
 */
public class Message {
    private String state;
    private String detail;
    private Object data;

    public Message(String state, String detail, Object data) {
        this.state = state;
        this.detail = detail;
        this.data = data;
    }

    public Message() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getJSON(){
        JSONObject object = new JSONObject();
        object.put("state", this.state);
        object.put("detail",this.detail);
        object.put("data", this.data);
        return object.toString();
    }
}
