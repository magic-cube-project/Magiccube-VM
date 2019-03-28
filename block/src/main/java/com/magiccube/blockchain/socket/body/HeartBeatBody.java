package com.magiccube.blockchain.socket.body;

@Deprecated
public class HeartBeatBody extends BaseBody {
    /**
     * text
     */
    private String text;

    public HeartBeatBody() {
        super();
    }

    public HeartBeatBody(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "HeartBeatBody{" +
                "text='" + text + '\'' +
                '}';
    }
}
