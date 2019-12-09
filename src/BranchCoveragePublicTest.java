import java.lang.reflect.*;
import java.io.*;

public class BranchCoveragePublicTest {
	// ========== SYSTEM ==========
	protected static final String EX_NAME = "BranchCoverage-Test";

	// ========== SUT is the test class itself #-) ==========
	static final Class<SchiffVersenkenZweigueberdeckungsTest> testClass = SchiffVersenkenZweigueberdeckungsTest.class;
	// ========== the SUT of the SUT is... #-) ==========
	static final String SUT_SUT_CLASS_NAME = "SchiffVersenken";
	static final String SUT_SUT_CONSTRUCTOR = "<init>";
	static final String SUT_SUT_METHOD_neuesSpielfeld = "neuesSpielfeld";
	static final String SUT_SUT_METHOD_positioniereSchiff = "positioniereSchiff";
	static final String SUT_SUT_METHOD_feldAusgeben = "feldAusgeben";
	static final String SUT_SUT_METHOD_spielzugAusfuehren = "spielzugAusfuehren";

	// ========== Test the test #-) ==========
	@org.junit.Test(timeout = 666)
	public void pubTest__EXTREMELY_TACITURN_SmokeTest() {
		new SchiffVersenkenZweigueberdeckungsTest();
	}

	// ========== main ==========
	// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
	// to run on command line: java -cp .:/usr/share/java/junit4.jar <nameOfThisClass> <nameOfYourTestClass>
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Run me with exactly one argument denoting the name of your test class!");
		} else {
			try {
				Class<?> testClass = ClassLoader.getSystemClassLoader().loadClass(args[0]);
				System.out.println("JUnit AuD-fake-version 0.1");
				Constructor<?> constructor = null;
				int testsRun = 0, testsFailed = 0;
				String result = "";
				long startTime = System.currentTimeMillis();
				System.setErr(new PrintStream(new ByteArrayOutputStream()));
				try {
					constructor = testClass.getDeclaredConstructor();
					if (!Modifier.isPublic(constructor.getModifiers())) {
						System.out.println("Test class should have exactly one public constructor");
					}
					Object target = constructor.newInstance();
					for (Method testCaseMethod : testClass.getMethods()) {
						if (testCaseMethod.isAnnotationPresent(Test.class) && testCaseMethod.getParameterTypes().length == 0) {
							try {
								testsRun++;
								testCaseMethod.invoke(target);
								System.out.print(".");
							} catch (Throwable t) {
								testsFailed++;
								System.out.print("E");
								result += testsFailed + ") " + testCaseMethod.getName() + "(" + testClass.getName() + ")" + "\n";
								StringWriter sw = new StringWriter();
								PrintWriter pw = new PrintWriter(sw);
								t.getCause().printStackTrace(pw);
								result += sw.toString();
							}
						}
					}
				} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException nsme) {
					System.out.println("Test class should have exactly one public zero-argument constructor");
				}
				long endTime = System.currentTimeMillis();
				System.out.println();
				System.out.println("Time: " + (endTime - startTime) / 1000d);
				if (testsFailed != 0) {
					System.out.println("There " + (testsFailed == 1 ? "was " : "were ") + testsFailed + " failure" + (testsFailed == 1 ? "" : "s") + ":");
					System.out.println(result);
					System.out.println("FAILURES!!!");
					System.out.println("Tests run: " + testsRun + ",  Failures: " + testsFailed);
				} else {
					System.out.println();
					System.out.println("OK (" + testsRun + " test" + (testsRun == 1 ? "" : "s") + ")");
				}
			} catch (ClassNotFoundException e) {
				System.out.println("Error: Could not find or load main class " + args[0]);
			}
		}
	}
}
