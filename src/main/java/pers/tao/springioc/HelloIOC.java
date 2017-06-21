package pers.tao.springioc;

/**
 * Created by tao on 17-6-20.
 */
public class HelloIOC {
    private String msg;

    public String getMsg() {
        System.out.println("Hello : " + msg);
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
