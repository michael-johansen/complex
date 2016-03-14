import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matcher
import org.junit.Assert.assertThat
import org.junit.Test

class ComplexTest {
  fun <T> T?.should(matcher: Matcher<T?>): T? {
    assertThat(this, matcher)
    return this
  }

  @Test
  fun shouldBeAbleToAddTwoComplex() {
    ((1 + 2 * i) + (2 + 3 * i)).should(equalTo((3 + 5 * i)))
  }

  @Test
  fun shouldBeAbleToAddARealAndComplex() {
    (1 + (2 + 3 * i)).should(equalTo(3 + 3 * i))
  }

  @Test
  fun shouldBeAbleToAddAComplexAndReal() {
    ((2 + 3 * i) + 1).should(equalTo(3 + 3 * i))
  }

  @Test
  fun shouldBeAbleToConvertRealToImaginary() {
    (5 * i).should(equalTo(Complex(0, 5)))
  }

  @Test
  fun shouldBeAbleToExtractRealAndImaginaryPart() {
    (3 + 5 * i).real.should(equalTo(3))
    (3 + 5 * i).imaginary.should(equalTo(5))
  }

  @Test
  fun shouldBeAbleToSubtract() {
    ((1 + 1 * i) - 1).should(equalTo(0 + 1 * i))
    ((1 + 1 * i) - 1 * i).should(equalTo(1 + 0 * i))
  }

  @Test
  fun shouldBeAbleToMultiply() {
    (i * i).should(equalTo(Complex(-1, 0)))
    (i * 1).should(equalTo(i))
    (1 * i).should(equalTo(i))

    ((1 + 2 * i) * (3 + 4 * i)).should(equalTo((1 * 3 - 2 * 4) + (2 * 3 + 1 * 4) * i))
  }

}

