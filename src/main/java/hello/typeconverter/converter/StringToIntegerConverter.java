package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
//String -> Int
public class StringToIntegerConverter implements Converter<String, Integer> {

    //문자를 숫자로 바꿔주는 컨버터
    @Override
    public Integer convert(String source) {
        log.info("convert source={}", source);
        return Integer.valueOf(source);
    }
}
