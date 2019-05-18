package com.bidanet.create_mvvm_file;

import com.bidanet.create_mvvm_file.modelCreate.ActivityApi;
import com.bidanet.create_mvvm_file.modelCreate.Api;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import com.bidanet.create_mvvm_file.modelCreate.ModelApi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateTool {


    protected static Template modelTemp;
    protected static Template xmlTemp;
    protected static Template activityTemp;

    public static void outClassFiles(List<ModelApi> clsList, String xmlPath, String activityPath) throws IOException, TemplateException {
        initTpl();
        for (ModelApi cl : clsList) {
            //创建model
            File filePath = new File(cl.getModelPath());
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            File file = new File(cl.getModelPath(), cl.getModelName() + "Mp.java");
            if (file.exists()) {
                System.out.println(cl.getModelName() + "Mp.java文件已经存在");
                continue;
            } else {
                file.createNewFile();
            }
            HashMap<String, Object> data = new HashMap<>();
            data.put("api", new Api(cl.getBasePackage() + ".model" + cl.getPackageName() + "Mp", cl.getModelName() + "Mp"));
            FileWriter fileWriter = new FileWriter(file);
            modelTemp.process(data, fileWriter);

            System.out.println("成功生成" + cl.getModelName() + "Mp.java文件");

            //创建xml
            File xmlFilePath = new File(xmlPath);
            if (!xmlFilePath.exists()) {
                xmlFilePath.mkdirs();
            }

            File xmlFile = new File(xmlPath, cl.getXmlName() + (cl.getXmlName().endsWith(".xml") ? "" : ".xml"));
            if (xmlFile.exists()) {
                System.out.println(cl.getXmlName() + "文件已经存在");
                continue;
            } else {
                xmlFile.createNewFile();
            }
            HashMap<String, Object> xmlData = new HashMap<>();
            xmlData.put("api", new Api(cl.getBasePackage() + ".model" + cl.getPackageName() + "." + cl.getModelName()+"Mp", cl.getModelName() + "Mp"));
            FileWriter xmlFileWriter = new FileWriter(xmlFile);
            xmlTemp.process(xmlData, xmlFileWriter);
            System.out.println("成功生成" + (cl.getXmlName().endsWith(".xml") ? "" : ".xml") + "文件");

            //创建activity
            File activityFilePath = new File(cl.getActivityPath());
            if (!activityFilePath.exists()) {
                activityFilePath.mkdirs();
            }
            File activityFile = new File(cl.getActivityPath(), cl.getModelName() + "Activity.java");
            if (activityFile.exists()) {
                System.out.println(cl.getModelName() + ".java文件已经存在");
                continue;
            } else {
                activityFile.createNewFile();
            }
            HashMap<String, Object> activityData = new HashMap<>();
            String xmlName = cl.getXmlName().substring(0, cl.getXmlName().length() - 4);
            String bindingName = transform(xmlName) + "Binding";
            bindingName = toUpperCaseFirstOne(bindingName);

            activityData.put("api", new ActivityApi(cl.getBasePackage() ,cl.getBasePackage() + ".activity" + cl.getPackageName() + "." + cl.getModelName()+"Activity" ,
                    cl.getBasePackage() + ".databinding." + bindingName , cl.getBasePackage() + ".model" + cl.getPackageName() + "." +cl.getModelName()+ "Mp" , bindingName , cl.getModelName() , xmlName));
            FileWriter activityFileWriter = new FileWriter(activityFile);
            activityTemp.process(activityData, activityFileWriter);

            System.out.println("成功生成" + cl.getModelName() + "Activity.java文件");
        }
    }


    private static void initTpl() throws IOException {
        // Create your Configuration instance, and specify if up to what FreeMarker
// version (here 2.3.22) do you want to apply the fixes that are not 100%
// backward-compatible. See the Configuration JavaDoc for details.
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

// Specify the source where the template files come from. Here I set a
// plain directory for it, but non-file-system sources are possible too:

//        String path = Main.class.getClassLoader().getResource("tpl").getPath();
//        System.out.println(path);
//        cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir") + "\\app\\src\\main\\assets\\tpl"));
        cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir") + "\\tpl"));

// Set the preferred charset template files are stored in. UTF-8 is
// a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

// Sets how errors will appear.
// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        modelTemp = cfg.getTemplate("model.ftl");
        xmlTemp = cfg.getTemplate("xml.ftl");
        activityTemp = cfg.getTemplate("activity.ftl");
    }


    public static String transform(String str){
        while(str.contains("_")){
            int i = str.indexOf("_");
            if(i+1<str.length()){
                char c = str.charAt(i+1);
                String temp = (c+"").toUpperCase();
                str = str.replace("_"+c, temp);
            }
        }
        return str;
    }

    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
