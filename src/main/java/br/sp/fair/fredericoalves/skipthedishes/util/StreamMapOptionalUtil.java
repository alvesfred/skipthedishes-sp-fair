package br.sp.fair.fredericoalves.skipthedishes.util;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Stream and Maps util class
 *
 * @author frederico.alves
 *
 */
public class StreamMapOptionalUtil {
	/**
	 * Convert List to a map without duplicates
	 * Sample: Map<Long, Item> itemById = toMapByUnique(item, Item::getId);
	 *
	 * @param list
	 * @param mapper Function
	 * @return
	 */
	public static <K, T> Map<K, T> toMapByUnique(List<T> list,
	        Function<? super T, ? extends K> mapper) {

		return list.parallelStream().collect(Collectors.toMap(mapper, Function.identity(), (o,n) -> o));
	}

	/**
	 * Convert a list to map
	 *
	 * @param list
	 * @param mapper Function
	 * @return
	 * @throws IllegalStateException
	 */
	public static <K, T> Map<K, T> toMap(List<T> list,
	        Function<? super T, ? extends K> mapper) {

		return list.parallelStream().collect(Collectors.toMap(mapper, Function.identity()));
	}

	/**
	 * Null Safety
	 *
	 * @param resolver
	 * @return
	 */
	public static <T> Optional<T> resolve(Supplier<T> resolver) {
	    try {
	        T result = resolver.get();
	        return Optional.ofNullable(result);
	    }
	    catch (NullPointerException e) {
	        return Optional.empty();
	    }
	}

	/**
	 * Null Safety
	 *
	 * @param resolver
	 * @return
	 */
	public static <T, R> Optional<R> resolve(Function<T, R> func, T value) {
	    try {
	    	Supplier<R> resolver = new Supplier<R>() {
				@Override
				public R get() {
					return func.apply(value);
				}
			};

	        R result = resolver.get();
	        return Optional.ofNullable(result);
	    }
	    catch (NullPointerException e) {
	        return Optional.empty();
	    }
	}
}
