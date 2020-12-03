package com.javatech.tdd.configs;

import com.google.common.base.Optional;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.bean.validators.plugins.Validators;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

import javax.validation.constraints.Email;

import static springfox.bean.validators.plugins.Validators.annotationFromBean;

/**
 * 设置针对email字段更好提示
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class EmailAnnotationPlugin implements ModelPropertyBuilderPlugin {
    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }

    @Override
    public void apply(ModelPropertyContext context) {
        Optional<Email> email = annotationFromBean(context, Email.class);
        if (email.isPresent()) {
            context.getBuilder().pattern(email.get().regexp());
            context.getBuilder().example("email@email.com");
        }
    }
}
