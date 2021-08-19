package basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CombinationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compare();
		System.out.println("------------------");
		predicate();
		function();

	}

	// comparator 조합 Test
	public static void compare() {
		List<apple> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new apple(i, i * -1));
		}
		for (int i = 0; i < 10; i++) {
			list.add(new apple(i, i * 1));
		}
		// 역정렬과 comparator 연결
		// 색상 역순 랭크 역순
		list.sort(Comparator.comparing(apple::getColor).reversed().thenComparing(apple::getRank).reversed());
		for (apple k : list) {
			System.out.println(k.getColor() + " " + k.getRank());
		}
	}

	// predicate 조합 Test
	public static void predicate() {
		List<apple> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new apple(i, i * -1));
		}
		// negate() 메소드를 통해 특정 프레디케이트 반전
		// and() 메소드를 통해 조합
		// or() 메소드를 통해 조합
		Predicate<apple> five = apple::ltFive;
		Predicate<apple> notFive = five.and(apple::notFive).negate().or(five);
		List<apple> filt = filter(list, notFive);
		for (apple k : filt) {
			System.out.println(k.getColor() + " " + k.getRank());
		}
	}

	// function 조합 Test
	public static void function() {
		List<apple> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new apple(i, i * -1));
		}
		// andThen() 메소드를 통해 주어진 함수를 먼저 적용한 결과를 다른 함수의 입력으로 전달하는 함수 반환
		// compose() 메소드를 통해 인수로 주어진 함수를 먼저 실행한 다음에 그 결과를 외부 함수의 인수로 제공
		Function<apple, Integer> five = apple::colorCom;
		Function<apple, Integer> and = five.andThen(apple::rankCom);
		
		Function<Integer, Integer> and2 = apple::rankCom;
		Function<apple, Integer> compose = and2.compose(five);
		
		List<Integer> filt = map(list, compose);
		for (Integer k : filt) {
			System.out.println(k);
		}
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> results = new ArrayList<>();
		for (T t : list) {
			results.add(f.apply(t));
		}
		return results;
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T t : list) {
			if (p.test(t)) {
				results.add(t);
			}
		}
		return results;
	}

	public static class apple {
		int color, rank;

		public apple(int color) {
			this.color = color;
		}

		public static Integer colorCom(apple k) {
			return k.color;
		}

		public static Integer rankCom(Integer k) {
			return --k;
		}

		public static boolean ltFive(apple k) {
			return k.color < 5;
		}

		public static boolean notFive(apple k) {
			return k.rank != 5;
		}

		public int getColor() {
			return color;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public apple(int color, int rank) {
			super();
			this.color = color;
			this.rank = rank;
		}

		public void setColor(int color) {
			this.color = color;
		}

	}
}
