package jadx.tests.internal.generics;

import jadx.api.InternalJadxTest;
import jadx.core.dex.nodes.ClassNode;

import java.util.List;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class TestGenerics extends InternalJadxTest {

	public static class TestCls {
		class A {
		}

		public static void mthWildcard(List<?> list) {
		}

		public static void mthExtends(List<? extends A> list) {
		}

		public static void mthSuper(List<? super A> list) {
		}
	}

	@Test
	public void test() {
		ClassNode cls = getClassNode(TestCls.class);
		String code = cls.getCode().toString();
		System.out.println(code);

		assertThat(code, containsString("mthWildcard(List<?> list)"));
		assertThat(code, containsString("mthExtends(List<? extends A> list)"));
		assertThat(code, containsString("mthSuper(List<? super A> list)"));
	}
}
