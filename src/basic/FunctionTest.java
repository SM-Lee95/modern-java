package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
	//Function >> R return 하는 apply 메소드
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = map(Arrays.asList("lambdas","in","action"),(String s) -> s.length());
		System.out.println(l.get(0));
 	}
	
// 	기본형 특화
// 	IntFunction
// 	IntToDoubleFunction
// 	IntToLongFunction
// 	LongFunction
// 	LongToDoubleFunction
// 	LongToIntFunction
// 	DoubleFunction
// 	DoubleToIntFunction
// 	DoubleToLongFunction
// 	ToIntFunction
// 	ToDoubleFunction
// 	ToLongFunction
 	
//	@FunctionalInterface
//	public interface Function<T, R>{
//		R apply(T t);
//	}
	
	public static <T,R> List<R> map(List<T> list,Function<T,R> f){
		List<R> results = new ArrayList<>();
		for(T t: list) {
			results.add(f.apply(t));
		}
		return results;
	}
}
