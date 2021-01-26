import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Test;

import java.awt.*;
import java.util.List;
//测试分词


public class TestAnsj {
    public static void main(String[] args) {
        String str="草多多很惨 "+
                "没有太多的专业技能 "+
                "只有不断努力学习 ";
        List<Term> terms= ToAnalysis.parse(str).getTerms();
        for(Term term:terms){
            System.out.print(term.getName()+"/");
        }
    }
}
