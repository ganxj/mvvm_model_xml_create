package com.bidanet.create_mvvm_file.modelCreate;

public class ModelApi {

    private String modelName;

    private String basePackage;

    private String packageName;

    private String modelPath;

    private String xmlName;

    private String activityPath;

    public ModelApi() {
    }

    public ModelApi(String modelName, String basePackage, String packageName, String modelPath, String xmlName, String activityPath) {
        this.modelName = modelName;
        this.basePackage = basePackage;
        this.packageName = packageName;
        this.modelPath = modelPath;
        this.xmlName = xmlName;
        this.activityPath = activityPath;
    }

    public String getActivityPath() {
        return activityPath;
    }

    public void setActivityPath(String activityPath) {
        this.activityPath = activityPath;
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    public String getXmlName() {
        return xmlName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }
}
