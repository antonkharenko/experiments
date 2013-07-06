package guava;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

public class GuavaTest {
	
	public static void main(String[] args) {
		// 1. Joiner
		String joinedString = Joiner.on(", ").skipNulls().join("one", null, "two", "three");
		System.out.println(joinedString);
		
		// 2. Splitter
		Iterable<String> splitterString = Splitter.on("|").omitEmptyStrings().split("|Harry|Ron|||Herminone ||");
		System.out.println(splitterString);
		
		// 3. CharMatcher (Utility Object pattern)
		String input = "_34-425==";
		String sanitized = CharMatcher.anyOf("-=_").removeFrom(input);
		System.out.println(sanitized);
		CharMatcher cm = CharMatcher.WHITESPACE;
		
		// 4. Optional
		Optional<String> nickname = Optional.of("Barry");
		nickname = Optional.absent();
		nickname = null;
		if (nickname.isPresent()) {
			//has name
		} else {
			//no nickname
		}
		
		// 5. Stopwatch
		Stopwatch watch = new Stopwatch().start();
		//do some operation
		long micros = watch.elapsed(TimeUnit.MICROSECONDS);
		
		// 6. Multiset
		Collection<String> ms = HashMultiset.create();
		
		// 7. Multimap
		Multimap<String,String> mm = HashMultimap.create();
		
		// 8. Immutable set
		ImmutableSet<Integer> nums = ImmutableSet.of(4, 8, 1222);
		System.out.println(nums);
		
		// 9. FluentIterable
		FluentIterable<String> things = FluentIterable.from(ms);
		FluentIterable<String> filteredThings = 
				things.skip(4).cycle().filter(Predicates.containsPattern("abs"));
		ImmutableList<String> il = filteredThings.toList();
		
		// 10. ComparisonChain
		ComparisonChain.start().compare(1, 2);
		
		// 11. Ordering
		Ordering<String> order = Ordering.natural();
		
		// 12. Utilities for dealing with primitives
		
		// 13. Concurrency libraries
		//e.g. CheckedFuture, Service, ServiceManager, RateLimiter etc.
		
		// 14. Caching
		Cache<String, Object> cache = CacheBuilder.newBuilder()
				.maximumSize(50000)
				.expireAfterWrite(33,  TimeUnit.MINUTES)
				.removalListener(null)
				.build();
		
		// 15. Hashing API
		HashCode hash = Hashing.murmur3_128().newHasher().putInt(123).putString("Test").hash();
		
		// etc.
	}
}
