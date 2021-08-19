package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
	//predicate >> boolean return하는 test메소드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<String> nEmpty = (String s) -> !s.isEmpty();
		List<String> k = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			k.add(String.valueOf(i));
		}
		List<String> list = filter(k,nEmpty);
		System.out.println(list.size());
	}
//	기본형 특화
//	IntPredicate
//	LongPredicate
//	DoublePredicate
	
//	@FunctionalInterface
//	public interface Predicate<T>{
//		boolean test(T t);
//	}
	
	public static <T> List<T> filter(List<T> list,Predicate<T> p){
		List<T> results = new ArrayList<>();
		for(T t: list) {
			if(p.test(t)) {
				results.add(t);
			}
		}
		return results;
	}
}
