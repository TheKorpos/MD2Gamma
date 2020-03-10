package hu.bme.mit.md2g.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hu.bme.mit.md2g.test.DummyTest;

@RunWith(Suite.class)
@SuiteClasses({
		DummyTest.class
})

public class AllTests {}
