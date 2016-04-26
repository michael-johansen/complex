class Complex(
  val real: Double,
  val imaginary: Double
) {

  constructor(real: Int, imaginary: Int) : this(
    real.toDouble(),
    imaginary.toDouble()
  )

  operator fun plus(complex: Complex): Complex {
    return Complex(Re(this) + Re(complex), Im(this) + Im(complex))
  }

  operator fun plus(real: Double): Complex {
    return Complex(this.real + real, this.imaginary)
  }

  operator fun plus(real: Int): Complex {
    return plus(real.toDouble())
  }

  operator fun minus(complex: Complex): Complex {
    return this + -complex
  }


  operator fun minus(real: Double): Complex {
    return this + -real
  }

  operator fun minus(real: Int): Complex {
    return minus(real.toDouble())
  }

  operator fun unaryMinus(): Complex {
    return -Re(this) + -Im(this) * i
  }

  operator fun times(other: Complex): Complex {
    val a = Re(this)
    val b = Im(this)
    val c = Re(other)
    val d = Im(other)

    return Complex(
      a * c - b * d,
      b * c + a * d
    )
  }

  operator fun times(real: Double): Complex {
    return this * (Complex(real, 0.0))
  }

  operator fun times(real: Int): Complex {
    return this * (Complex(real.toDouble(), 0.0))
  }

  fun conjugate(): Any {
    return Re(this) - Im(this) * i
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other?.javaClass != javaClass) return false

    other as Complex

    return Re(this) == Re(other) && Im(this) == Im(other)
  }

  override fun hashCode(): Int {
    var result = real.hashCode()
    result += 31 * result + imaginary.hashCode()
    return result
  }

  override fun toString(): String {
    return "($real ${imaginary}i)"
  }

  fun div(other: Complex): Complex {
    val a = Re(this)
    val b = Im(this)
    val c = Re(other)
    val d = Im(other)
    return Complex(
      (a * c + b * d) / (c * c + d * d),
      (b * c - a * d) / (c * c + d * d)
    )
  }
}
