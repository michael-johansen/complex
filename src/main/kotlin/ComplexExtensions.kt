val i = Complex(0, 1)

operator fun Int.plus(complex: Complex): Complex {
  return Complex(this + complex.real, complex.imaginary)
}

operator fun Int.times(complex: Complex): Complex {
  return complex.times(this)
}
