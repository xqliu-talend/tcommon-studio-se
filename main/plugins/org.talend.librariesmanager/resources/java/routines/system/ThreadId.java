package routines.system;

import java.util.UUID;

public class ThreadId {

	private static final ThreadLocal<String> threadId = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return UUID.randomUUID().toString();
		}
	};

	public static String get() {
		return threadId.get();
	}
	
}
