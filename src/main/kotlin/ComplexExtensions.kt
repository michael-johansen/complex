val i = Complex(0.0, 1.0)

operator fun Double.plus(complex: Complex): Complex {
  return complex + this
}

operator fun Double.times(complex: Complex): Complex {
  return complex * this
}

operator fun Double.minus(complex: Complex): Complex {
  return -(complex - this)
}

infix operator fun Int.invoke(complex: Complex): Complex {
  return this * complex
}

operator fun Int.plus(complex: Complex): Complex {
  return complex + this.toDouble()
}

operator fun Int.times(complex: Complex): Complex {
  return complex * this.toDouble()
}

operator fun Int.minus(complex: Complex): Complex {
  return complex - this.toDouble()
}

fun Re(complex: Complex): Double = complex.real

fun Im(complex: Complex): Double = complex.imaginary