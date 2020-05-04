package com.in28minutes.junit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.in28minutes.junit.helper.ArraysCompareTest;
import com.in28minutes.junit.helper.StringHelperTest;

@RunWith(Suite.class)
@SuiteClasses({ArraysCompareTest.class,StringHelperTest.class})
public class DummyTestSuite {

}
