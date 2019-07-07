package com.mahak;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.TreeSet;

public class RNGooglePayTezModule extends ReactContextBaseJavaModule {

    // Google Pay (Tez) Android Package
    private static final String GOOGLE_TEZ_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";

    // Current App context
    private final ReactApplicationContext reactContext;

    // Tez Request Code
    private static final int TEZ_REQUEST_CODE = 123;

    // Callback for returning response
    static Callback callBack;

    // Implementing Listener for handling callback for payment response
    private final BaseActivityEventListener mActivityEventListener = new BaseActivityEventListener() {

        @Override
        public void onActivityResult(Activity a, int requestCode, int resultCode, Intent data) {
            JSONObject jsonItem = new JSONObject();
            String transactionStatus = data.getStringExtra("Status");
            String googlePayTezTxnId = data.getStringExtra("txnId");
            String responseCode = data.getStringExtra("responseCode");

            if (requestCode == TEZ_REQUEST_CODE) {
                try {
                    jsonItem.put("validationError", false);
                    jsonItem.put("hasAppInstalled", true);
                    jsonItem.put("transactionStatus" , transactionStatus);
                    jsonItem.put("googlePayTezTxnId" , googlePayTezTxnId);
                    jsonItem.put("responseCode" , responseCode);

                    if(transactionStatus.equals("SUCCESS") && responseCode.equals("0")) {
                        jsonItem.put("message", "Transaction completed");
                    } else {
                        jsonItem.put("message", "Transaction failed");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callBack.invoke(jsonItem.toString());
                return;
            }            
        }
    };

    public RNGooglePayTezModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        reactContext.addActivityEventListener(mActivityEventListener);
    }

    @Override
    public String getName() {
        return "RNGooglePayTez";
    }

    @ReactMethod
    public void GooglePayInit(
            String scheme,
            String authority,
            String merchantUPI,
            String merchantName,
            String merchantCode,
            String transactionId,
            String transactionNote,
            String transactionAmount,
            String transactionCurrency,
            String merchantURL,
            Callback callBack) {

        this.callBack = callBack;
        JSONObject jsonItem = new JSONObject();

        // Handling if app is not installed in user's device
        Intent i = this.reactContext.getPackageManager().getLaunchIntentForPackage(GOOGLE_TEZ_PACKAGE_NAME);
        if (i == null) {
            try {
                jsonItem.put("validationError", false);
                jsonItem.put("hasAppInstalled", false);
                jsonItem.put("message", "Google Pay app is not installed");
                callBack.invoke(jsonItem.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }

        if (scheme == null || scheme.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", false);
                jsonItem.put("message", "Please provide a valid scheme");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }

        if (authority == null || authority.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", false);
                jsonItem.put("message", "Please provide a valid authority");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }

        if (merchantUPI == null || merchantUPI.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", true);
                jsonItem.put("message", "Please provide a valid merchantUPI");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }

        if (merchantName == null || merchantName.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", true);
                jsonItem.put("message", "Please provide a valid merchantName");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }

        if (merchantCode == null || merchantCode.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", true);
                jsonItem.put("message", "Please provide a valid merchantCode");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }

        if (transactionId == null || transactionId.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", true);
                jsonItem.put("message", "Please provide a valid transactionId");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }

        if (transactionNote == null || transactionNote.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", true);
                jsonItem.put("message", "Please provide a valid transactionNote");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }

        if (transactionAmount == null || transactionAmount.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", true);
                jsonItem.put("message", "Please provide a valid transactionAmount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }

        if (transactionCurrency == null || transactionCurrency.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", true);
                jsonItem.put("message", "Please provide a valid transactionCurrency");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }

        if (merchantURL == null || merchantURL.equals("")) {
            try {
                jsonItem.put("validationError", true);
                jsonItem.put("hasAppInstalled", true);
                jsonItem.put("message", "Please provide a valid merchantURL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callBack.invoke(jsonItem.toString());
            return;
        }


        //Preparing URI builder with params
        Uri uri = new Uri.Builder()
                .scheme(scheme) //upi
                .authority(authority) //pay
                .appendQueryParameter("pa", merchantUPI)
                .appendQueryParameter("pn", merchantName)
                .appendQueryParameter("mc", merchantCode)
                .appendQueryParameter("tr", transactionId)
                .appendQueryParameter("tn", transactionNote)
                .appendQueryParameter("am", transactionAmount)
                .appendQueryParameter("cu", transactionCurrency)
                .appendQueryParameter("url", merchantURL)
                .build();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        intent.setPackage(GOOGLE_TEZ_PACKAGE_NAME);
        this.reactContext.startActivityForResult(intent, TEZ_REQUEST_CODE, null);
    }
}