<#-- @ftlvariable name="api" type="Api" -->
package ${api.packPath};

import android.app.Application;
import android.support.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class ${api.className} extends BaseViewModel{


    public ${api.className}(@NonNull Application application) {
        super(application);
    }

}