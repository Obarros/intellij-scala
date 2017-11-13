package org.jetbrains.plugins.scala.testingSupport.utest.scala2_11.utest_0_5_4

import org.jetbrains.plugins.scala.DependencyManager
import org.jetbrains.plugins.scala.DependencyManager._
import org.jetbrains.plugins.scala.testingSupport.utest.UTestTestCase

/**
  * @author Roman.Shein
  * @since 02.09.2015.
  */
abstract class UTestTestBase_2_11_0_5_4 extends UTestTestCase {

  override protected def loadIvyDependencies(): Unit = DependencyManager(
    "com.lihaoyi"     %% "utest"        % "0.5.4",
  ).loadAll

  override protected val testSuiteSecondPrefix = ""
}
