package com.bidanet.create_mvvm_file;

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

    public static void outClassFiles(List<ModelApi> clsList, String xmlPath) throws IOException, TemplateException {
        initTpl();
        for (ModelApi cl : clsList) {
            File filePath = new File(cl.getModelPath());
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            File file = new File(cl.getModelPath(), cl.getModelName() + ".java");
            if (file.exists()) {
                System.out.println(cl.getModelName() + ".java文件已经存在");
                continue;
            } else {
                file.createNewFile();
            }
            HashMap<String, Object> data = new HashMap<>();
            data.put("api", new Api(cl.getModelPackage(), cl.getModelName()));
            FileWriter fileWriter = new FileWriter(file);
            modelTemp.process(data, fileWriter);

            System.out.println("成功生成" + cl.getModelName() + ".java文件");

            File xmlFilePath = new File(xmlPath);
            if (!xmlFilePath.exists()) {
                xmlFilePath.mkdirs();
            }

            File xmlFile = new File(xmlPath, cl.getXmlName() + (cl.getXmlName().endsWith(".xml") ? "" : ".xml"));
            if (xmlFile.exists()) {
                continue;
            } else {
                xmlFile.createNewFile();
            }
            HashMap<String, Object> xmlData = new HashMap<>();
            xmlData.put("api", new Api(cl.getModelPackage() + "." + cl.getModelName(), cl.getModelName()));
            FileWriter xmlFileWriter = new FileWriter(xmlFile);
            xmlTemp.process(xmlData, xmlFileWriter);
            System.out.println("成功生成" + (cl.getXmlName().endsWith(".xml") ? "" : ".xml") + "文件");
        }
    }


    private static void initTpl() throws IOException {
        // Create your Configuration instance, and specify if up to what FreeMarker
// version (here 2.3.22) do you want to apply the fixes that are not 100%
// backward-compatible. See the Configuration JavaDoc for details.
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

// Specify the source where the template files come from. Here I set a
// plain directory for it, but non-file-system sources are possible too:
        cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\tpl"));

// Set the preferred charset template files are stored in. UTF-8 is
// a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

// Sets how errors will appear.
// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        modelTemp = cfg.getTemplate("model.ftl");
        xmlTemp = cfg.getTemplate("xml.ftl");
    }


}
