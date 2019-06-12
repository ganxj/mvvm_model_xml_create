<#-- @ftlvariable name="api" type="ActivityApi" -->
package ${api.packageName};

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import ${api.basePackage}.activity.MyBaseActivity;
import ${api.basePackage}.R;
import ${api.basePackage}.BR;
import ${api.bindingPath};
import ${api.modelPath};



@Route(path = "/activity/${api.modelName}")
public class ${api.modelName}Activity extends MyBaseActivity<${api.bindingName} , ${api.modelName}Mp> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
    return R.layout.${api.layoutName};
    }

    @Override
    public int initVariableId() {
    return BR.mp;
    }
}
