import java.util.ArrayList;

public class Member {

    private final String name;
    private final ArrayList<Member> children;

    public Member(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public ArrayList<Member> getChildren() {
        return children;
    }

    public String getName() {
        return this.name;
    }

    public void addChildren(Member member) {
        this.children.add(member);
    }
}
