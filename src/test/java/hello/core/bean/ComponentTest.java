package hello.core.bean;

import hello.core.AppComponent;
import hello.core.AppConfig;
import hello.core.item.ItemServiceImpl;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ComponentTest {

    @Test
    @DisplayName("lite mode and full mode ")
    public void componentAnnotated() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class, AppComponent.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        ItemServiceImpl itemService = ac.getBean("itemService", ItemServiceImpl.class);

        assertThat(itemService.getMemberService()).isSameAs(memberService);
    }

    @Test
    public void componentAnnotated2() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class, AppComponent.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName + ", object = " + bean + ", class = " + bean.getClass());
        }


    }
}
