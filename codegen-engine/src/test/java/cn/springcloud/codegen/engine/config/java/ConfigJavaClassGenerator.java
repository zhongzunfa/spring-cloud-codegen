package cn.springcloud.codegen.engine.config.java;

import cn.springcloud.codegen.engine.entity.CodeOutType;
import cn.springcloud.codegen.engine.entity.InputParams;
import cn.springcloud.codegen.engine.entity.InputParamsContext;
import cn.springcloud.codegen.engine.generator.CodeGenForFileGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2018/1/21
 * @time: 17:29
 * @description : config java 类的生成, 使用缩减版模式
 */
public class ConfigJavaClassGenerator extends CodeGenForFileGenerator{

    public ConfigJavaClassGenerator(InputParamsContext paramsContext) {
        super(paramsContext);
    }

    /**
     * 模板里面需要的参数， 其他的不要在这里添加。
     * @return
     */
    @Override
    public Map<String, Object> getTemplateData() {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("packageName", "cn.springcloud.codegen");
        return params;
    }

    @Override
    public CodeOutType isJavaOrResourcesOrOtherCode() {
        return CodeOutType.JAVA;
    }
}
