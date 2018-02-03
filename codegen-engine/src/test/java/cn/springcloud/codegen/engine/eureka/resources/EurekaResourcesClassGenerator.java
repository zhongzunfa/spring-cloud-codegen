package cn.springcloud.codegen.engine.eureka.resources;

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
 * @time: 0:35
 * @description : eureka 资源文件的生成
 */
public class EurekaResourcesClassGenerator extends CodeGenForFileGenerator{

    public EurekaResourcesClassGenerator(InputParams inputParams) {
        super(inputParams);
    }

    /**
     * 模板里面需要的参数， 其他的不要在这里添加。
     * @return
     */
    @Override
    public Map<String, Object> getTemplateData() {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("serviceName", "eureka-server");
        return params;
    }

    @Override
    public CodeOutType isJavaOrResourcesOrOtherCode() {
        return CodeOutType.RESOURCES;
    }
}
