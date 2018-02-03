package cn.springcloud.codegen.engine;

import cn.springcloud.codegen.engine.config.ConfigPomXmlGenerator;
import cn.springcloud.codegen.engine.config.java.ConfigJavaClassGenerator;
import cn.springcloud.codegen.engine.config.resources.ConfigResourcesGenerator;
import cn.springcloud.codegen.engine.entity.InputParamsContext;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2018/1/22
 * @time: 13:19
 * @description : 生成config 使用缩减版模式
 */
public class ConfigCodeGenTest {

    public static void main(String[] args) {

        try {


            new ConfigJavaClassGenerator(getClassParamContext()).genrator();

            new ConfigResourcesGenerator(getApplicationParamContext()).genrator();

            new ConfigPomXmlGenerator(getPomParamContext()).genrator();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * 类需要的参数
     * @return
     */
    private static InputParamsContext getClassParamContext(){


        // 也可以理解成模板目录， 但是不一样的是， 不使用绝对路径的形式
        String prefixTemplatePath = "templates/config/java/";
        Class clazz = ConfigJavaClassGenerator.class;
        InputParamsContext in = new InputParamsContext(prefixTemplatePath, clazz);

        /**
         *  三个必要设置的参数
         *  moduleName 模块名称
         *  TemplateName 模板名称
         *  dynamicOutPath 输出路径
          */
        in.setDynamicOutPath("D:\\spring-cloud-codegene-test");
        in.setModuleName("spring-cloud-config");
        // 必须，如果不设置模板名称， 默认为， 类名 + 模板后缀（ConfigJavaClassGenerator.java.ftl）
        in.setTemplateName("ConfigApplication.java.ftl");

        return in;
    }

    /**
     * 资源文件
     * @return
     */
    private static InputParamsContext getApplicationParamContext(){

        // 也可以理解成模板目录， 但是不一样的是， 不使用绝对路径的形式
        String prefixTemplatePath = "templates/config/resources/";
        Class clazz = ConfigResourcesGenerator.class;
        InputParamsContext in = new InputParamsContext(prefixTemplatePath, clazz);

        /**
         *  三个必要设置的参数
         *  moduleName 模块名称
         *  TemplateName 模板名称
         *  dynamicOutPath 输出路径
         */
        in.setDynamicOutPath("D:\\spring-cloud-codegene-test");
        in.setModuleName("spring-cloud-config");

        // 必须，如果不设置模板名称， 默认为， 类名 + 模板后缀（ConfigJavaClassGenerator.java.ftl）
        in.setTemplateName("application.properties.ftl");

        return in;
    }

    /**
     * pom 参数
     * @return
     */
    private static InputParamsContext getPomParamContext(){

        // 也可以理解成模板目录， 但是不一样的是， 不使用绝对路径的形式
        String prefixTemplatePath = "templates/config/";
        Class clazz = ConfigPomXmlGenerator.class;
        InputParamsContext in = new InputParamsContext(prefixTemplatePath, clazz);

        /**
         *  三个必要设置的参数
         *  moduleName 模块名称
         *  TemplateName 模板名称
         *  dynamicOutPath 输出路径
         */
        in.setDynamicOutPath("D:\\spring-cloud-codegene-test");
        in.setModuleName("spring-cloud-config");
        in.setTemplateName("pom.xml.ftl");

        return in;
    }
}
