package lecture19.Bus;

import java.util.ArrayList;
import java.util.List;

public class Bus {
	List<Member> _member = new ArrayList<>();

	public void addMember(final Member m) {
		_member.add(m);
	}

	public void removeMember(final Member m) {
		_member.remove(m);
	}

	void broadcast(final Command c) {
		for (Member member : _member) {
			member.accept(c);
		}
	}

}
