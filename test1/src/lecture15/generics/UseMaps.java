package lecture15.generics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UseMaps {
	public static void main(final String[] args) {
		Map<String, String> map = new HashMap<>(10);
		map.put("Lebedev", "8 950 135 14 52");
		map.put("Ivanov", "8 921 251 23 23");
		map.put("Petrov", "8 950 423 41 94");

		System.out.println(map.get("Lebedev"));
		
		Map<Integer, List<String>> groups = new HashMap<>(10);
		groups.put(10, new LinkedList<String>(){
			{
				add("Ivanov");
				add("Petrov");
				add("Sidorov");
			}
		});

		groups.put(20, new LinkedList<String>(){
			{
				add("John");
				add("Bill");
				add("Jove");
			}
		});
		
		groups.put(40, Arrays.asList("qwe", "asd", "", "zxc"));
		
		System.out.println(groups.get(40));
		
	}
}
