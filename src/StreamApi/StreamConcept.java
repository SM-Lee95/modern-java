package StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamConcept {
	private static String[] name = { "밥", "국", "찌개" };

	public static void main(String[] args) {
		// StreamAPI는 선언형으로 컬렉션 데이터를 처리할 수 있는 기능을 가지고 있다.
		// 멀티쓰레드 구현없이 투명한 병렬 처리가 가능하다.
		List<menu> menuList = new ArrayList<>();
		for (int i = 0; i < name.length; i++) {
			menuList.add(new menu(i, name[i]));
		}
		menuList.stream()
				// filter >> 특정 요소 필터링 >> 인수 : Predicate<T> >> 디스크럽터 : T -> boolean
				.filter(d -> d.getCal() < 2)
				// map >> 한 요소를 다른 요소로 변환하거나 정보를 추출 >> 인수 : Function<T,R> >> 디스크럽터 : T -> R
				// limit >> 정해진 개수 이상의 요소가 스트림에 저장되지 못하게 스트림 크기를 축소(truncate)
				// sorted >> 정렬 연산 >> 인수 : Comparator<T,R> >> 디스크럽터 : T -> R
				.sorted((g,k) -> k.getCal() - g.getCal())
				.map(menu::getName)
				// collect >> 스트림을 다른 형식으로 변환
				.collect(Collectors.toList())
				.forEach(System.out::println);

	}

	public static class menu {
		int cal;
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public menu(int cal, String name) {
			super();
			this.cal = cal;
			this.name = name;
		}

		public menu(int cal) {
			super();
			this.cal = cal;
		}

		public int getCal() {
			return cal;
		}

		public void setCal(int cal) {
			this.cal = cal;
		}

	}
}
