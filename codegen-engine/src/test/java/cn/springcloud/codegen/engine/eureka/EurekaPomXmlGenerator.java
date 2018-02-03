package cn.springcloud.codegen.engine.eureka;

import cn.springcloud.codegen.engine.entity.CodeOutType;
import cn.springcloud.codegen.engine.entity.InputParams;
import cn.springcloud.codegen.engine.generator.CodeGenForFileGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2018/1/21
 * @time: 0:36
 * @description : eureka pom文件的生成
 */
public class EurekaPomXmlGenerator extends CodeGenForFileGenerator{

    public EurekaPomXmlGenerator(InputParams inputParams) {
        super(inputParams);
    }

    /**
     * 模板里面需要的参数， 其他的不要在这里添加， 从输入参数中添加
     * @return
     */
    @Override
    public Map<String, Object> getTemplateData() {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pomArtifactId", "eureka-server");
        params.put("pomName", "eureka-server");
        params.put("springBootVersion", "1.5.9");
        params.put("javaVersion", "1.8");

        return params;
    }

    @Override
    public CodeOutType isJavaOrResourcesOrOtherCode() {
        return CodeOutType.NONE;
    }
}
