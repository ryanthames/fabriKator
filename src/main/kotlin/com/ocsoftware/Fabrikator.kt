package com.ocsoftware

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions

open class Fabrikator {
  fun build(klass: KClass<*>, attrs: List<Pair<*, *>> = emptyList()): Any? {
    val filteredFunctions = this::class.declaredFunctions.filter { it.name == "${klass.simpleName}Factory" }

    if (filteredFunctions.isEmpty()) {
      throw UndefinedFactoryException("""
      No factory defined for ${klass.simpleName}. Please check for typos or define your factory:

      def ${klass.simpleName}Factory(): ${klass.simpleName} {
        ...
      }
      """.trimIndent())
    }

    return filteredFunctions[0].call()
  }
}