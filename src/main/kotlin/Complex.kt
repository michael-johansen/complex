class Complex(
    val real: Int,
    val imaginary: Int
) {
  operator fun plus(complex: Complex): Complex {
    return Complex(this.real + complex.real, this.imaginary + complex.imaginary)
  }

  operator fun plus(real: Int): Complex {
    return Complex(this.real + real, this.imaginary)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other?.javaClass != javaClass) return false

    other as Complex

    if (real != other.real) return false
    if (imaginary != other.imaginary) return false

    return true
  }

  override fun hashCode(): Int {
    var result = real
    result += 31 * result + imaginary
    return result
  }

  override fun toString(): String {
    return "($real ${imaginary}i)"
  }

  operator fun minus(real: Int): Complex {
    return this + -real
  }

  operator fun minus(complex: Complex): Complex {
    return this + -complex
  }

  operator fun unaryMinus(): Complex {
    return Complex(-real, -imaginary)
  }

  operator fun times(complex: Complex): Complex {
    val a = real
    val b = imaginary
    val c = complex.real
    val d = complex.imaginary

    return Complex(
        a * c - b * d,
        b * c + a * d
    )
  }

  operator fun times(real: Int): Complex {
    return this * (Complex(real, 0))
  }


}
