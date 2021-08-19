package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerTest {
	//Consumer >> void return 하는 accept 메소드
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		forEach(Arrays.asList(1,2,3,4,5),(Integer i) -> System.out.println(i));
	}
//	기본형 특화
//	IntConsumer
//	LongConsumer
//	DoubleConsumer
 	
//	@FunctionalInterface
//	public interface Comsumer<T>{
//		void accept(T t);
//	}
	
	public static <T> void forEach(List<T> list,Consumer<T> p){
		List<T> results = new ArrayList<>();
		for(T t: list) {
			p.accept(t);
		}
	}
}
