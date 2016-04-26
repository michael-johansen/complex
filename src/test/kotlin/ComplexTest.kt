import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matcher
import org.junit.Assert.assertThat
import org.junit.Test

class ComplexTest {
  infix fun <T> T?.should(matcher: Matcher<*>): T? {
    assertThat(this, matcher as Matcher<in T?>)
    return this
  }

  @Test
  fun shouldBeAbleToAddTwoComplex() {
    ((1 + 2 * i) + (2 + 3 * i)) should equalTo((3 + 5 * i))
  }

  @Test
  fun shouldBeAbleToAddARealAndComplex() {
    (1 + (2 + 3 * i)) should equalTo(3 + 3 * i)
  }

  @Test
  fun shouldBeAbleToAddAComplexAndReal() {
    ((2 + 3(i)) + 1) should equalTo(3 + 3 * i)
  }

  @Test
  fun shouldBeAbleToConvertRealToImaginary() {
    (5 * i) should equalTo(Complex(0, 5))
  }

  @Test
  fun shouldBeAbleToExtractRealAndImaginaryPart() {
    Re(3 + 5 * i) should equalTo(3.0)
    Im(3 + 5 * i) should equalTo(5.0)
  }

  @Test
  fun shouldBeAbleToSubtract() {
    ((1 + 1 * i) - 1) should equalTo(0 + 1 * i)
    ((1 + 1 * i) - 1 * i) should equalTo(1 + 0 * i)
  }

  @Test
  fun shouldBeAbleToMultiply() {
    (i * i) should equalTo(Complex(-1, 0))
    (i * 1) should equalTo(i)
    (1 * i) should equalTo(i)

    ((1 + 2 * i) * (3 + 4 * i)) should equalTo(
      (1 * 3 - 2 * 4) + (2 * 3 + 1 * 4) * i
    )
  }

  @Test
  fun shouldBeAbleToConjugate() {
    (2.0 + 3.0 * i).conjugate() should equalTo(2.0 - 3.0 * i)
  }

  @Test
  fun shouldBeAbleToDivide() {
    (1 + 1 * i).div((1 + 1 * i)) should equalTo(1.0 + 0 * i)
  }
}

