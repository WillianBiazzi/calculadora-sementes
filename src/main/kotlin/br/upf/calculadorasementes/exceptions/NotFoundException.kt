package br.upf.calculadorasementes.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()