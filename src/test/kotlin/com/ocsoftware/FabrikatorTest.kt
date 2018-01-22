package com.ocsoftware

import com.ocsoftware.model.Article
import com.ocsoftware.model.Email
import com.ocsoftware.model.UnusedClass
import com.ocsoftware.model.User
import io.kotlintest.matchers.shouldEqual
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.specs.StringSpec

class FabrikatorTest : StringSpec() {
  private val factory = Factory()

  init {
    "raises an error if the factory is not defined" {
      shouldThrow<UndefinedFactoryException> {
        factory.build(UnusedClass::class)
      }
    }

    "build returns the matching factory" {
      User(3, "John Doe", false) shouldEqual factory.build(User::class)
    }

    "build merges passed in options" {
      User(3, "John Doe", true) shouldEqual factory.build(User::class, listOf(Pair("admin", true)))
    }

    "build raises an exception if invalid keys are passed in via options" {
      // TODO implement and enable
    }.config(enabled = false)

    "buildPair builds 2 factories" {
      // TODO implement and enable
    }.config(enabled = false)

    "buildList builds the factory passed in the number of times" {
      // TODO implement and enable
    }.config(enabled = false)

    "buildList handles the number 0" {
      // TODO implement and enable
    }.config(enabled = false)
  }
}

class Factory : Fabrikator() {
  fun userFactory(): User {
    return User(3, "John Doe", false)
  }

  fun emailFactory(): Email {
    return Email("someEmail@foo.com")
  }

  fun articleFactory(): Article {
    return Article("Post Title")
  }
}