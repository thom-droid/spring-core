package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) // 의존성이 없으면 호출 자체가 안됨
        public void setNoBean1(Member member) {
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member) { // 호출은 되나 빈이 없는 경우 null이 들어감
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member) { // 빈이 없는 경우 Optional.empty()가 실행
            System.out.println("member = " + member);
        }
    }

}
