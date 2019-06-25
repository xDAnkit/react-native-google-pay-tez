package com.mahak;
// Copyright (c) Facebook, Inc. and its affiliates.

// This source code is licensed under the MIT license found in the
// LICENSE file in the root directory of this source tree.


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.react.bridge.ActivityEventListener;


/**
 * An empty implementation of {@link }
 */
public class BaseActivityEventListener implements ActivityEventListener {

    /**
     * @deprecated use {@link #onActivityResult(Activity, int, int, Intent)} instead.
     */
    @Deprecated
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) { }

    public void onNewIntent(Intent intent) { }

}