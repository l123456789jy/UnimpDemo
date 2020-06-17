package com.example.unimpdemo;

import android.app.Application;
import android.util.Log;

import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

import java.util.ArrayList;
import java.util.List;

import io.dcloud.feature.sdk.DCSDKInitConfig;
import io.dcloud.feature.sdk.DCUniMPSDK;
import io.dcloud.feature.sdk.MenuActionSheetItem;
import io.dcloud.uniplugin.MyLayoutView;
import io.dcloud.uniplugin.TestModule;
import io.dcloud.uniplugin.TestText;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            //注册组件
            WXSDKEngine.registerModule("TestModule", TestModule.class);
            WXSDKEngine.registerComponent("myText", TestText.class);
            WXSDKEngine.registerComponent("MyLayoutView", MyLayoutView.class);
        } catch (WXException e) {
            e.printStackTrace();
            Log.e("onCreate",e.getMessage());
        }
        //初始化 uni小程序SDK ----start----------
        MenuActionSheetItem item = new MenuActionSheetItem("关于", "gy");
        MenuActionSheetItem item1 = new MenuActionSheetItem("获取当前页面url", "hqdqym");
        MenuActionSheetItem item2 = new MenuActionSheetItem("跳转到宿主原生测试页面", "gotoTestPage");
        List<MenuActionSheetItem> sheetItems = new ArrayList<>();
        sheetItems.add(item);
        sheetItems.add(item1);
        sheetItems.add(item2);
        DCSDKInitConfig config = new DCSDKInitConfig.Builder()
                .setCapsule(true)
                .setMenuDefFontSize("16px")
                .setMenuDefFontColor("#ff00ff")
                .setMenuDefFontWeight("normal")
                .setMenuActionSheetItems(sheetItems)
                .build();
        DCUniMPSDK.getInstance().initialize(this, config, new DCUniMPSDK.IDCUNIMPPreInitCallback() {
            @Override
            public void onInitFinished(boolean b) {
                Log.i("unimp","onInitFinished----"+b);
            }
        });
        //初始化 uni小程序SDK ----end----------
    }
}
