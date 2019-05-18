package com.bidanet.create_mvvm_file;

import com.bidanet.create_mvvm_file.modelCreate.ModelApi;
import com.mashape.unirest.http.exceptions.UnirestException;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    protected static Template modelTemp;
    protected static Template xmlTemp;


    public static void main(String[] arg) throws IOException, UnirestException, TemplateException {
//        initTpl();
//        ApiBean apiBean = getApiData();
//        HashMap<String, List<Api>> clsMap = buildClsMap(apiBean);
//        clsMap = classClean(clsMap);
        String dir = System.getProperty("user.dir") + "\\out\\sde\\java\\";

        String xmlPath = System.getProperty("user.dir") + "\\out\\sde\\res\\layout";

        String activityPath = System.getProperty("user.dir") + "\\out\\sde\\java\\";
        List<ModelApi> list = new ArrayList<>();
        String basePackUri = "com.bidanet.sdewallet";
        list.add(new ModelApi("Login", basePackUri, ".login", dir + "model\\login", "activity_login.xml",dir + "activity\\login"));
        list.add(new ModelApi("Register", basePackUri, ".login", dir + "model\\login", "activity_register.xml",dir + "activity\\login"));
        list.add(new ModelApi("CreateWalletFirst", basePackUri, ".createWall", dir + "model\\createWall", "activity_create_wallet_first.xml",dir + "activity\\createWall"));
        list.add(new ModelApi("CreateWalletEdit", basePackUri, ".createWall", dir + "model\\createWall", "activity_create_wallet_edit.xml",dir + "activity\\createWall"));
        list.add(new ModelApi("CreateWalletTip", basePackUri, ".createWall", dir + "model\\createWall", "activity_create_wallet_tip.xml",dir + "activity\\createWall"));
        list.add(new ModelApi("CreateWalletWord", basePackUri, ".createWall", dir + "model\\createWall", "activity_create_wallet_word.xml",dir + "activity\\createWall"));
        list.add(new ModelApi("CreateWalletWordConfirm", basePackUri, ".createWall", dir + "model\\createWall", "activity_create_wallet_word_confirm.xml",dir + "activity\\createWall"));

        list.add(new ModelApi("Main", basePackUri, "", dir + "model", "activity_main.xml", dir + "activity"));

        list.add(new ModelApi("HomeFg", basePackUri, ".home", dir + "model\\home", "fragment_home.xml",dir + "activity\\home"));
        list.add(new ModelApi("LockPositionFg", basePackUri, ".lockPosition", dir + "model\\lockPosition", "fragment_lock_position.xml",dir + "activity\\lockPosition"));
        list.add(new ModelApi("NewsFg", basePackUri, ".news", dir + "model\\news", "fragment_news.xml",dir + "activity\\news"));
        list.add(new ModelApi("MyFg", basePackUri, ".my", dir + "model\\my", "fragment_my.xml",dir + "activity\\my"));

        list.add(new ModelApi("Wallet", basePackUri, ".wallet", dir + "model\\wallet", "activity_wallet.xml",dir + "activity\\wallet"));
        list.add(new ModelApi("TransferAccounts", basePackUri, ".wallet", dir + "model\\wallet", "activity_transfer_account.xml",dir + "activity\\wallet"));
        list.add(new ModelApi("Receivables", basePackUri, ".wallet", dir + "model\\wallet", "activity_receivables.xml",dir + "activity\\wallet"));
        list.add(new ModelApi("TransactionRecord", basePackUri, ".wallet", dir + "model\\wallet", "activity_transaction_record.xml",dir + "activity\\wallet"));

        list.add(new ModelApi("NewsDetail", basePackUri, ".news", dir + "model\\news", "activity_news_detail.xml",dir + "activity\\news"));

        list.add(new ModelApi("UserInfo", basePackUri, ".my", dir + "model\\my", "activity_user_info.xml",dir + "activity\\my"));
        list.add(new ModelApi("Message", basePackUri, ".my", dir + "model\\my", "activity_message.xml",dir + "activity\\my"));
        list.add(new ModelApi("WalletList", basePackUri, ".walletManage", dir + "model\\walletManage", "activity_wallet_list.xml",dir + "activity\\walletManage"));
        list.add(new ModelApi("WalletManage", basePackUri, ".walletManage", dir + "model\\walletManage", "activity_wallet_manage.xml",dir + "activity\\walletManage"));
        list.add(new ModelApi("WalletDetail", basePackUri, ".walletManage", dir + "model\\walletManage", "activity_wallet_detail.xml",dir + "activity\\walletManage"));


        CreateTool.outClassFiles(list, xmlPath ,activityPath);
//        String path = Main.class.getResource("").getPath();
//        Main.class.getClassLoader().getResourceAsStream(path);

    }

//
//    private static void outClassFiles(List<ModelApi> clsList, String xmlPath) throws IOException, TemplateException {
//        for (ModelApi cl : clsList) {
//            File filePath = new File(cl.getModelPath());
//            if (!filePath.exists()) {
//                filePath.mkdirs();
//            }
//            File file = new File(cl.getModelPath(), cl.getModelName() + ".java");
//            if (file.exists()) {
//                System.out.println(cl.getModelName() + ".java文件已经存在");
//                continue;
//            } else {
//                file.createNewFile();
//            }
//            HashMap<String, Object> data = new HashMap<>();
//            data.put("api", new Api(cl.getModelPackage(), cl.getModelName()));
//            FileWriter fileWriter = new FileWriter(file);
//            modelTemp.process(data, fileWriter);
//
//
//            File xmlFilePath = new File(xmlPath);
//            if (!xmlFilePath.exists()) {
//                xmlFilePath.mkdirs();
//            }
//            File xmlFile = new File(xmlPath, cl.getXmlName() + ".xml");
//            if (xmlFile.exists()) {
//                continue;
//            } else {
//                xmlFile.createNewFile();
//            }
//            HashMap<String, Object> xmlData = new HashMap<>();
//            xmlData.put("api", new Api(cl.getModelPackage() + "." + cl.getModelName(), cl.getModelName()));
//            FileWriter xmlFileWriter = new FileWriter(xmlFile);
//            xmlTemp.process(xmlData, xmlFileWriter);
//
//
//        }
//    }
//
//
//    private static void initTpl() throws IOException {
//        // Create your Configuration instance, and specify if up to what FreeMarker
//// version (here 2.3.22) do you want to apply the fixes that are not 100%
//// backward-compatible. See the Configuration JavaDoc for details.
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
//
//// Specify the source where the template files come from. Here I set a
//// plain directory for it, but non-file-system sources are possible too:
//        cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir") + "\\com.bidanet.create_mvvm_file.tpl"));
//
//// Set the preferred charset template files are stored in. UTF-8 is
//// a good choice in most applications:
//        cfg.setDefaultEncoding("UTF-8");
//
//// Sets how errors will appear.
//// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
//        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//
//        modelTemp = cfg.getTemplate("model.ftl");
//        xmlTemp = cfg.getTemplate("xml.ftl");
//    }


}
