package cn.springcloud.codegen.engine.config.resources;

import cn.springcloud.codegen.engine.entity.CodeOutType;
import cn.springcloud.codegen.engine.entity.InputParamsContext;
import cn.springcloud.codegen.engine.generator.CodeGenForFileGenerator;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2018/1/21
 * @time: 17:29
 * @description : config properties 配置文件的生成, 使用缩减版模式
 */
public class ConfigResourcesGenerator extends CodeGenForFileGenerator{

    public ConfigResourcesGenerator(InputParamsContext paramsContext) {
        super(paramsContext);
    }

    /**
     * 模板里面需要的参数， 其他的不要在这里添加。
     * @return
     */
    @Override
    public Map<String, Object> getTemplateData() {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("serviceName", "spring-cloud-config");
        return params;
    }

    @Override
    public CodeOutType isJavaOrResourcesOrOtherCode() {
        return CodeOutType.RESOURCES;
    }

    /**
     * 需要多级目录可以重写， 或者在InputParamContext 里面的packageName  属性值， 这个会变成添加目录
     * @return
     */
    @Override
    public String getPackageName() {
        return StringUtils.isNotBlank(super.getPackageName()) ? super.getPackageName() + "myconfig" : "myconfig";

    }
}
