package io.dcloud.uniplugin;

import android.content.Context;
import android.view.View;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;

import io.dcloud.uniplugin.component.R;


//自己定义view
public class MyLayoutView extends WXComponent<View> {

    public MyLayoutView(WXSDKInstance instance, WXVContainer parent, BasicComponentData basicComponentData) {
        super(instance, parent, basicComponentData);
    }

    @Override
    protected View initComponentHostView(Context context) {

        return View.inflate(context, R.layout.main, null);
    }


    @Override
    public void onActivityResume() {
        super.onActivityResume();
    }

    @Override
    public void onActivityPause() {
        super.onActivityPause();
    }

    @Override
    public void onActivityDestroy() {
        super.onActivityDestroy();
    }
}
