package cn.springcloud.codegen.engine.eureka.java;

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
 * @time: 0:29
 * @description : eureka java 类的生成
 */
public class EurekaJavaClassGenerator extends CodeGenForFileGenerator{

    public EurekaJavaClassGenerator(InputParams inputParams) {
        super(inputParams);
    }

    /**
     * 模板里面需要的参数， 其他的不要在这里添加。
     * @return
     */
    @Override
    public Map<String, Object> getTemplateData() {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("packageName", "cn.springcloud.codegen.component.eureka");
        return params;
    }

    @Override
    public CodeOutType isJavaOrResourcesOrOtherCode() {
        return CodeOutType.JAVA;
    }
}
