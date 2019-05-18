package com.bidanet.create_mvvm_file.modelCreate;

public class ActivityApi {

    private String basePackage;

    private String packageName;

    private String bindingPath;

    private String modelPath;

    private String bindingName;

    private String modelName;

    private String layoutName;

    public ActivityApi(String basePackage, String packageName, String bindingPath, String modelPath, String bindingName, String modelName, String layoutName) {
        this.basePackage = basePackage;
        this.packageName = packageName;
        this.bindingPath = bindingPath;
        this.modelPath = modelPath;
        this.bindingName = bindingName;
        this.modelName = modelName;
        this.layoutName = layoutName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getBindingPath() {
        return bindingPath;
    }

    public void setBindingPath(String bindingPath) {
        this.bindingPath = bindingPath;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    public String getBindingName() {
        return bindingName;
    }

    public void setBindingName(String bindingName) {
        this.bindingName = bindingName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }
}
