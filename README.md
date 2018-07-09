# mvvm_model_xml_create
android MVVM创建model和xml

# 使用方法


[![](https://jitpack.io/v/ganxj/mvvm_model_xml_create.svg)](https://jitpack.io/#ganxj/mvvm_model_xml_create)

## 1	导入依赖
   ``` 
   allprojects {
    	    	repositories {
    	       	   	maven { url 'https://jitpack.io' }
    	    	}
    }
```
```
	dependencies {
	        implementation 'com.github.ganxj:mvvm_model_xml_create:daaeb63a71'
	}
```
## 2 复制文件

复制根目录下的tpl文件夹到assets 目录下


## 3 使用
```
        public static void main(String[] arg) throws IOException, TemplateException {
    
            String dir = System.getProperty("user.dir") + "\\app\\src\\main\\java\\com\\bidanet\\kotlintest\\";
    
            String xmlPath = System.getProperty("user.dir") + "\\app\\src\\main\\res\\layout";
            List<ModelApi> list = new ArrayList<>();
            String basePackUri = "com.bidanet.kotlintest";
            list.add(new ModelApi("Home", basePackUri + ".model.home", dir + "model\\home", "activity_home.xml"));
            list.add(new ModelApi("Login", basePackUri + ".model.login", dir + "model\\login", "activity_login.xml"));
    
            CreateTool.outClassFiles(list, xmlPath);
        }

```
