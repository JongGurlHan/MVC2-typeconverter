package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //converter의 확장된 기능
    //스프링은 내부에서 ConversionService를 제공한다.
    //WebMvcConfigurere가 제공ㅎ아는 addFormatters를 사용해서 추가하고 싶은 컨버터를 등록한다.
    //이렇게 하면 스프링은 내부에서 사용하는 ConversionService에 컨버터를 추가해준다.
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
    }

    //StringToIntegerConverter를 등록하기 이전에 이미 코드는 잘수행된다.
    // 스프링 내부에 수 많은 기본 컨버터들이 제공되기 때문
    ///컨버터를 추가하면 추구한 컨버터가 기본 컨버터보다 높은 우선순위를 가진다.
}
