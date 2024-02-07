import org.junit.jupiter.api.*;

public class SimpleJunitTest {

    int result;
    @BeforeAll
    static void beforeAll() {
        System.out.println("\n#beforeAll\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("#   beforeEach");
        result = getResult();
    }

    @AfterEach
        void AfterEach(){
            System.out.println("#          afterEach\n");
            result = 0;
    }

    @Test
    void firstTest() {
        int result = getResult();
        System.out.println("#      firstTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        int result = getResult();
        System.out.println("#      secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        int result = getResult();
        System.out.println("#      thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("#   afterAll\n");
    }
}
