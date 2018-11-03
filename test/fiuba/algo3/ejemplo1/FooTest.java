package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;
import org.junit.Test;

public class FooTest {

	@Test
	public void doFooShouldReturnFoo(){
        Foo foo = new Foo();
        String result = foo.doFoo();
        assertEquals("Foo", result);
	}
	
	/*
	@Test
	public void doBarShouldReturnBar(){
        Foo foo = new Foo();
        String result = foo.doBar();
        Assert.assertEquals("Bar", result);
	}
	*/

}
