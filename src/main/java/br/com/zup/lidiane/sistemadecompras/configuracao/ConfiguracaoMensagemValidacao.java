package br.com.zup.lidiane.sistemadecompras.configuracao;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Component
public class ConfiguracaoMensagemValidacao {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename( "classpath:MensagensDeValidacao" );
        messageSource.setDefaultEncoding( "UTF-8" );
        return messageSource;
    }

    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource( messageSource() );
        return bean;
    }

}
