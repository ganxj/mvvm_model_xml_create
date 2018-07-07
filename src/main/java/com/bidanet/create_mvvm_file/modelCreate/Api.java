package com.bidanet.create_mvvm_file.modelCreate;

public class Api {

    private String packPath;

    private String className;

    public Api() {
    }

    public Api(String packPath, String className) {
        this.packPath = packPath;
        this.className = className;
    }

    public String getPackPath() {
        return packPath;
    }

    public void setPackPath(String packPath) {
        this.packPath = packPath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
