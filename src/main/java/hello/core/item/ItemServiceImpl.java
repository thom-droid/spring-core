package hello.core.item;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class ItemServiceImpl implements ItemService {

    private final MemberService memberService;
    private final Object arg1;

    public ItemServiceImpl(MemberService memberService, Object arg1) {
        this.memberService = memberService;
        this.arg1 = arg1;
    }

    @Override
    public String getItem(Member member) {
        Member foundMember = memberService.findMember(member.getId());

        if (foundMember.getGrade() == Grade.VIP) {
            return "VIP_ITEM";
        }
        return "NORMAL_ITEM";
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public Object getArg1() {
        return arg1;
    }
}
