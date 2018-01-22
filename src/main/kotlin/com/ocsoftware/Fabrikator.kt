package com.ocsoftware

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions

open class Fabrikator {
  fun build(klass: KClass<*>, attrs: List<Pair<*, *>> = emptyList()): Any? {
    val name = klass.simpleName?.decapitalize()
    val filteredFunctions = this::class.declaredFunctions.filter { it.name == "${name}Factory" }

    if (filteredFunctions.isEmpty()) {
      throw UndefinedFactoryException("""
      No factory defined for $name. Please check for typos or define your factory:

      def ${name}Factory(): ${klass.simpleName} {
        ...
      }
      """.trimIndent())
    }

    return filteredFunctions[0].call(this)
  }
}