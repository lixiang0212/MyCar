package com.lx.abcdemo.aliplay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.PayTask;
import java.util.Map;

/**
 * Created by lixiang on 2017/3/10.
 */
public class AliPay {
    private Context context;
    private Activity activity;
    public AliPay(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    /** 支付宝支付业务：入参app_id */
    public static final String APPID = "2017030906136688";
    /** 支付宝账户登录授权业务：入参pid值 */
    public static final String PID = "2088802781840684";
    /** 支付宝账户登录授权业务：入参target_id值 */
    public static final String TARGET_ID = "18157130965";
    /** 商户私钥，pkcs8格式 */
    /** 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个 */
    /** 如果商户两个都设置了，优先使用 RSA2_PRIVATE */
    /** RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议使用 RSA2_PRIVATE */
    /** 获取 RSA2_PRIVATE，建议使用支付宝提供的公私钥生成工具生成， */
    /** 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1 */
    public static final String RSA2_PRIVATE = "";
    public static final String RSA_PRIVATE ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCU+" +
            "nREuO8DGGMkM2fO3yzVMby1CbzLuEIyX4X2poIMgeUwAPn6gpjS6jGkvSsLITQKeA5/KyZ8LR7aKN3tw41nKaFN" +
            "JtdY5gH9UalN2/90FV1TQjmxxo8uaXlKJqZXPceF84mKhlJj9xYi2yYe2NX7rTcQi5nbHCf/0I//WvCs5jahC/1" +
            "pZhjRxoGam6X6tvdtigg2C6fjbGNYfxLKltoKnzszAnmtWu/avg47Q9YGbPt8rSDy1ysZuLNNMruyeV9v/ibYpG" +
            "b9ksrp3DpYYCDH1EqzuAKDLFgbb5qwKJ1jyTlEKvQjh82dIcY9bSmQ7bi1ja/FocIfP62z5ySUdH/xAgMBAAECg" +
            "gEACD6wLpl5iNdRrVA2/4j0ZzwgcHiAfVnOOBF3TYY7jkumDnkPXKDbqliRtMdPWYdV5Ppt+vW9ZIPuwC4g0ibP" +
            "bZUtOyLaKi5Yj9d0Ij35rkf8aT4yCTeu9ueZcdQfwpZFs5Ed3I/AgY3MKNOuEWj4trwIXx8KvciaIhs9zOkQhtE" +
            "EpypDjqRf4TYsMm/AUzlGW3lsZZtovldw/FOydGVr2i4PgmHA/NS9wTeA61wYCzRsB4nSeNQxNle8s1gNGjLEda" +
            "bXru1V3PeaZHT4WacsSxDQwZQ5VZDT5X51Zd7dxRnwlpNo1tzoGLZKH8AnxtBCWW6OOa1z5HwpJTzLZjOkfQKBg" +
            "QD1m+2EEJS7W3uhTCpBPNFHjMzikU7Oh3OA6E2UnSFXJvocsNBH10PycxFuTWDaAUx6HEax27Q7EpKfdhcIX0pz" +
            "YWKrUR53W3R9NeXiQyErrxsV1/pLY6ynU2bnVfw5ujdlg2R1Wu/XfidaIS7+O5SAD7Od/aDPI71P2eZ412HV6wK" +
            "BgQCbR/dACowofAGDTqiI4aPLEc8DaMHD2XQY34Xsj5OPw2UxrPM1rVAMlUB73yJWoDuXnNQeBD6IPCjBrWlzOB" +
            "bOqlwlpc0q+J5iTwE6LtSGIA5pRdOsIIvMSRpaiYPdjzFLEgPfP+UKH1/cHue9cJcuOTu1TX8b7JzcYGT+P7d+k" +
            "wKBgEAjGeE020IZ36z9UMN8eEIw+Ifp3iR8pqLxBuFaLwytNv8rBRjdk/bKKbEeL75+PFRe8e8cKnKKpRNTKSyc" +
            "hbqfob6PDl+o2ECiRIfTc+QOdAo+PjRVsQ547xRWFemVQUYXC7LBroQdg3U72SO2t07ByuvlAYtWD+e8RT0lMX1" +
            "FAoGBAIDHAy9SUAB3Lw4FmtHCR4Nu5n7OTvusiJLkNP4F6HuusWqsIxtd+2gkE1FnsOOkiSdogaXPIUj8k1RkC3" +
            "LpjkigkkEKqwc7HqcrHDpzgf8l8K2voic66pVl/vwc1YZWbavzadCo/bsSX/5+hvPdvxMvlev7NDIlXcWKD9enY" +
            "fcPAoGADFnwZhTelpfHH93431j1m+P9qCBnqYrDKFFqgedwIulY51kLKLh+0bPAlQBHVS1uuYjp78QCoVnBJ421" +
            "1diuJup71WYavYORUf1vNOWARElRbEB/Fmkz1Br16mnQSQYw3qUaQgsgLUSuwYAUmZWQPzBda93SkKqYLUlCzL6" +
            "V18s=";
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知*/
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(context, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(context, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();
                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value// 传入，则支付账户为该授权账户
                        Toast.makeText(context, "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(context, "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };
    /*** 支付宝账户支付业务** @param v*/
    public void payV2() {
        if (TextUtils.isEmpty(APPID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))) {
            new AlertDialog.Builder(context).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                     //       finish();
                        }
                    }).show();
            return;
        }

        /**
         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
         *
         * orderInfo的获取必须来自服务端；
         */
        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /*** 支付宝账户授权业务** @param v*/
    public void authV2() {
        if (TextUtils.isEmpty(PID) || TextUtils.isEmpty(APPID)
                || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))
                || TextUtils.isEmpty(TARGET_ID)) {
            new AlertDialog.Builder(context).setTitle("警告").setMessage("需要配置PARTNER |APP_ID| RSA_PRIVATE| TARGET_ID")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                        }
                    }).show();
            return;
        }
        /**
         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
         *
         * authInfo的获取必须来自服务端；
         */
        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
        Map<String, String> authInfoMap = OrderInfoUtil2_0.buildAuthInfoMap(PID, APPID, TARGET_ID, rsa2);
        String info = OrderInfoUtil2_0.buildOrderParam(authInfoMap);

        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(authInfoMap, privateKey, rsa2);
        final String authInfo = info + "&" + sign;
        Runnable authRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造AuthTask 对象
                AuthTask authTask = new AuthTask(activity);
                // 调用授权接口，获取授权结果
                Map<String, String> result = authTask.authV2(authInfo, true);

                Message msg = new Message();
                msg.what = SDK_AUTH_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread authThread = new Thread(authRunnable);
        authThread.start();
    }

    /*** get the sdk version. 获取SDK版本号**/
    public void getSDKVersion() {
        PayTask payTask = new PayTask(activity);
        String version = payTask.getVersion();
        Toast.makeText(context, version, Toast.LENGTH_SHORT).show();
    }

}
