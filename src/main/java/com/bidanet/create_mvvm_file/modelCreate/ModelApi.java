package com.bidanet.create_mvvm_file.modelCreate;

public class ModelApi {

    private String modelName;

    private String modelPackage;

    private String modelPath;

    private String xmlName;

    public ModelApi() {
    }

    public ModelApi(String modelName, String modelPackage, String modelPath, String xmlName) {
        this.modelName = modelName;
        this.modelPackage = modelPackage;
        this.modelPath = modelPath;
        this.xmlName = xmlName;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
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
