package hello.core;

import hello.core.item.ItemService;
import hello.core.item.ItemServiceImpl;
import hello.core.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {

    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl(memberService, test());
    }

    private final MemberService memberService;

    public AppComponent(MemberService memberService) {
        this.memberService = memberService;
    }

    public Object test() {
        return "TEST!!!!";
    }

}

