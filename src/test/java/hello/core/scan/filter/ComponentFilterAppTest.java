package hello.core.scan.filter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.context.annotation.ComponentScan.Filter;

public class ComponentFilterAppTest {

    @Test
    @DisplayName("BeanA is detected whereas B is not")
    void filterScan() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        BeanA beanA = ctx.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();

        assertThrows(NoSuchBeanDefinitionException.class, () -> ctx.getBean("beanB", BeanB.class));
    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = IncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = ExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }
}
