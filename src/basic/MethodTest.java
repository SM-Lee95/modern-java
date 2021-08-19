package basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

//메소드 참조와 생성자 참조 Test
public class MethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		methodTest();
		createTest();

	}

	public static void methodTest() {
		List<String> list = Arrays.asList("이성무", "이성무2", "이성무3");

		// method 참조 >> 람다의 축약형
		list.sort((s1, s2) -> s2.compareToIgnoreCase(s1));
		list.sort(String::compareToIgnoreCase);

		for (String k : list)
			System.out.println(k);
	}

	public static void createTest() {
		Function<Integer, apple> c1 = apple::new;
		apple a2 = c1.apply(4);
		System.out.println(a2.color);
	}

	public static class apple {
		int color;

		public apple(int color) {
			this.color = color;
		}

	}
}
