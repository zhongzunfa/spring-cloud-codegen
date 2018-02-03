package cn.springcloud.codegen.engine;

import cn.springcloud.codegen.engine.constants.CodeGenConstants;
import cn.springcloud.codegen.engine.entity.InputParams;
import cn.springcloud.codegen.engine.eureka.EurekaPomXmlGenerator;
import cn.springcloud.codegen.engine.eureka.java.EurekaJavaClassGenerator;
import cn.springcloud.codegen.engine.eureka.resources.EurekaResourcesClassGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2018/1/21
 * @time: 0:47
 * @description : 使用全输出参数试生成， 不是很好适应
 */
public class EurekaCodeGenTest {

    public static void main(String[] args) {

        try {

            // 生成主类
            new EurekaJavaClassGenerator(getEurekaClassParams()).genrator();

            // 资源文件生成
            new EurekaResourcesClassGenerator(getEurekaResourcesParams()).genrator();

            // pom 文件生成
            new EurekaPomXmlGenerator(getEurekaPomParams()).genrator();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取输入参数
     * @return
     */
    private static InputParams getEurekaClassParams(){

        InputParams in = new InputParams();
        in.setDynamicOutPath("D:\\spring-cloud-codegene-test");
        in.setFileType("java");
        in.setFileName("EurekaApplication");
        in.setTemplateName("EurekaApplication.java.ftl");

        // 模板路径
        String fileDir =  EurekaCodeGenTest.class.getResource("/").getPath() + "templates/eureka/java/";
        System.out.println(" 文件路径 ： " + fileDir);

        in.setTemplateDir(fileDir);
        in.setModuleName("eureka-server");
        in.setPackageName("cn.springcloud.codegen.component.eureka");
        in.setTemplateConfigEncode(CodeGenConstants.DEFAULT_ENCODE);

        return in;
    }


    /**
     * 获取输入参数
     * @return
     */
    private static InputParams getEurekaResourcesParams(){

        InputParams in = new InputParams();
        in.setDynamicOutPath("D:\\spring-cloud-codegene-test");
        in.setFileType("properties");
        in.setFileName("application");
        in.setTemplateName("application.properties.ftl");

        // 模板路径
        String fileDir =  EurekaCodeGenTest.class.getResource("/").getPath() + "templates/eureka/resources";
        System.out.println(" 文件路径 ： " + fileDir);

        in.setTemplateDir(fileDir);
        in.setModuleName("eureka-server");
        //in.setPackageName("resources");
        in.setTemplateConfigEncode(CodeGenConstants.DEFAULT_ENCODE);

        return in;
    }


    /**
     * 获取输入参数
     * @return
     */
    private static InputParams getEurekaPomParams(){

        InputParams in = new InputParams();
        in.setDynamicOutPath("D:\\spring-cloud-codegene-test");
        in.setFileType("xml");
        in.setFileName("pom");
        in.setTemplateName("pom.xml.ftl");

        // 模板路径
        String fileDir =  EurekaCodeGenTest.class.getResource("/").getPath() + "templates/eureka/";
        System.out.println(" 文件路径 ： " + fileDir);

        in.setTemplateDir(fileDir);
        in.setModuleName("eureka-server");
        // pom 文件给根目录下， 不需要添加packageName
//        in.setPackageName("cn.springcloud.codegen.component.eureka");
        in.setTemplateConfigEncode(CodeGenConstants.DEFAULT_ENCODE);

        return in;
    }
}
