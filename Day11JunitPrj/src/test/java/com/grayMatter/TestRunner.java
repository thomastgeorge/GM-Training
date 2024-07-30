//package com.grayMatter;
//
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//import org.junit.runners.Suite.SuiteClasses;
//
//@SuiteClasses({AppTest.class, Calculator.class})
//@RunWith(Suite.class)
//public class TestRunner {
//
//}

package com.grayMatter;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({AppTest.class, Calculator.class})
@IncludeCategory(MarkerInterface.class)
@RunWith(Categories.class)
public class TestRunner {

}
