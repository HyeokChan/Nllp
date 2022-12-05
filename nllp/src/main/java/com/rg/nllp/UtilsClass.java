package com.rg.nllp;

import org.springframework.stereotype.Component;

/**
 * packageName    : com.rg.nllp
 * fileName       : UtilsClass
 * author         : hyeokchan
 * date           : 2022/12/05
 * description    : 로직처리를 위한 유틸 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/05        hyeokchan       최초 생성
 */
@Component
public class UtilsClass {
    public String nvl(Object o, String value){
        if(o == null){
            return value;
        }
        return (String) o;
    }
    public String blankConcat(String s1, String s2){
        if(!"".equals(s2)){
            return s1.concat(" ").concat(s2);
        }
        return s1;
    }

}
